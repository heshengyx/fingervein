package com.grgbanking.fingervein.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grg.recognition.finger.jni.GRGFingerRecognitionJNI;
import com.grgbanking.fingervein.dao.IEmployeeDao;
import com.grgbanking.fingervein.dao.IFingerVeinDao;
import com.grgbanking.fingervein.dao.IRecognitionLogDao;
import com.grgbanking.fingervein.dao.ITerminalDao;
import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.entity.FingerVein;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.entity.Result;
import com.grgbanking.fingervein.entity.Terminal;
import com.grgbanking.fingervein.enums.OptEnum;
import com.grgbanking.fingervein.enums.StatusEnum;
import com.grgbanking.fingervein.param.FingerVeinQueryParam;
import com.grgbanking.fingervein.service.IRecognitionService;
import com.grgbanking.fingervein.util.BASE64Util;
import com.grgbanking.fingervein.util.DateUtil;
import com.grgbanking.fingervein.util.FileUtil;
import com.grgbanking.fingervein.util.ListUtil;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("recognitionService")
public class RecognitionServiceImpl implements IRecognitionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecognitionServiceImpl.class);
	
	private static final int TEMPLATE_SIZE = 1000; // 特征值组大小
	private static final int TEMPLATE_NUM = 3; // 特征值个数
	private static final int TEMPLATE_LENGTH = 6001; // 特征值长度
	private List<FingerVein> fingerVeins = new ArrayList<FingerVein>();
	//private ExecutorService pools = Executors.newCachedThreadPool();
	
	@Value("${fingervein.password}")
	private String fpassword;
	
	@Value("${fingervein.threshold}")
	private String threshold;
	
	@Value("${fingervein.folder}")
	private String folder;
	
	@Value("${recognition.password}")
	private String rpassword;
	
	@Value("${register.length}")
	private String registerLength;
	
	@Value("${register.employee}")
	private String registerEmployeeJson;
	
	@Value("${register.fingerVein}")
	private String registerFingerVeinJson;
	
	@Autowired
	private ITerminalDao terminalDao;
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Autowired
	private IFingerVeinDao fingerVeinDao;
	
	@Autowired
	private IRecognitionLogDao recognitionLogDao;
	
	@PostConstruct
	public void init() {
		int count = 0;
		LOGGER.info("指静脉信息开始加载中...");
		try {
			synchronized (this) {
				FingerVeinQueryParam param = new FingerVeinQueryParam();
				param.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
				fingerVeins = fingerVeinDao.queryAll(param);
				count = fingerVeins.size();
				createTemplates(count);
			}
		} catch (Exception e) {
			count = 0;
			LOGGER.info("指静脉信息加载出错", e);
		}
		LOGGER.info("指静脉信息开始加载完成，共加载到[" + count + "]条指纹信息");
	}
	
	@Override
	public Result heartbeat(String json, String ipaddr) {
		Result result = new Result();
		String code = ipaddr.replaceAll("[.]", "");
		Terminal terminal = new Terminal();
		terminal.setCode(code);
		terminal = terminalDao.getData(terminal);
		
		if (terminal == null) {
			terminal = new Terminal();
			terminal.setId(UUIDGeneratorUtil.getUUID());
			terminal.setName("指静脉终端");
			terminal.setCode(code);
			terminal.setIpaddr(ipaddr);
			terminal.setHeartbeat(new Date()); // 当前心跳时间
			terminal.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue())); // 1在线,0断线
			terminal.setCreateBy(OptEnum.SYSTEM.name().toLowerCase());
			terminal.setCreateTime(new Date());

			int count = terminalDao.save(terminal);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据保存失败");
			}
		} else {
			terminal.setHeartbeat(new Date());
			terminal.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
			terminal.setUpdateTime(new Date());
			int count = terminalDao.update(terminal);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据修改失败");
			}
		}
		result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
		result.setMessage(OptEnum.HeartBeat.name());
		return result;
	}
	
	@Override
	public Result syncTime(String json, String ipaddr) {
		Result result = new Result();
		result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
		result.setMessage(DateUtil.getDayTime(new Date()));
		return result;
	}

	/**
	 * json:{'id': '000001', 'password': '123456', 'type': 'CreatePplReq'}
	 */
	@Override
	public Result registerEmployee(String json, String ipaddr) {
		Result result = null;
		JSONObject jsonObject = JSONObject.fromObject(json);
		String code = jsonObject.optString("id");
		if (StringUtils.isEmpty(code)) {
			throw new IllegalArgumentException("工号不能为空");
		} else {
			String password = jsonObject.optString("password");
			if (this.fpassword != null && this.fpassword.equals(password)) {
				result = new Result();
				Employee employee = new Employee();
				employee.setCode(code);
				employee = employeeDao.getData(employee);
				if (employee == null) {
					//工号不存在
					LOGGER.info("工号：" + code + "不存在");
					employee = new Employee();
					employee.setId(UUIDGeneratorUtil.getUUID());
					employee.setName(code);
					employee.setCode(code);
					employee.setCreateBy(OptEnum.SYSTEM.name().toLowerCase());
					employee.setCreateTime(new Date());
					int count = employeeDao.save(employee);
					if (count == 0) {
						throw new DataAccessResourceFailureException("数据保存失败");
					}
				}
				result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
				result.setMessage(employee.getName());
			} else {
				LOGGER.info("密码不正确");
				throw new IllegalArgumentException("密码不正确");
			}
		}
		return result;
	}

	/**
	 * json:{'id': '000001', 'feature': '8wAAAAABCxkrKgIIAAAAAAAJAAoDB....', 'type': 'CreateFgVeinReq'}
	 */
	@Override
	public Result registerFingerVein(String json, String ipaddr) {
		Result result = null;
		JSONObject jsonObject = JSONObject.fromObject(json);
		String code = jsonObject.optString("id");
		if (StringUtils.isEmpty(code)) {
			throw new IllegalArgumentException("工号不能为空");
		}
		String feature = jsonObject.optString("feature");
		if (StringUtils.isEmpty(feature)) {
			throw new IllegalArgumentException("特征值不能为空");
		}
		Employee employee = new Employee();
		employee.setCode(code);
		employee = employeeDao.getData(employee);
		if (employee == null) {
			//工号不存在
			LOGGER.info("工号：" + code + "不存在");
			throw new IllegalArgumentException("工号不存在");
		} else {
			result = new Result();
			FingerVein fingerVein = new FingerVein();
			fingerVein.setId(UUIDGeneratorUtil.getUUID());
			fingerVein.setSeq("01");
			fingerVein.setEmployeeId(employee.getId());
			fingerVein.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
			try {
				fingerVein.setFeature(BASE64Util.decoder(feature));
			} catch (IOException e) {
			}
			fingerVein.setCreateTime(new Date());

			int count = fingerVeinDao.save(fingerVein);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据保存失败");
			}
			// 指静脉信息新增时，在内存中也新增一条
			synchronized (this) {
				fingerVeins.add(fingerVein);
				createTemplates(fingerVeins.size());
			}
			result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
			result.setMessage(employee.getName());
		}
		return result;
	}

	@Override
	public Result recognitionFingerVein(String json, String ipaddr) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		String sample = jsonObject.getString("sample");
		if (StringUtils.isEmpty(sample)) {
			throw new IllegalArgumentException("特征值不能为空");
		}
		FingerVein fingerVein = new FingerVein();
		try {
			fingerVein.setFeature(BASE64Util.decoder(sample));
		} catch (IOException e) {
		}
		float threshold = Float.parseFloat(this.threshold);
		LOGGER.info("指静脉特征值阀值：" + threshold);
		LOGGER.info("指静脉识别开始");
		long startTime = System.currentTimeMillis(); // 获取开始时间
		int[] results = new int[] { 0, 0 }; // 识别结果
		int index = 0;

		byte[] destFeatures = new byte[TEMPLATE_SIZE * TEMPLATE_NUM * TEMPLATE_LENGTH];
		synchronized (this) {
			List<List<FingerVein>> fingerVeinList = ListUtil.splitList(fingerVeins, TEMPLATE_SIZE);
			for (List<FingerVein> list : fingerVeinList) {
				int i = 0;
				int length = 0;
				for (FingerVein fVein : list) {
					byte[] srcFeatures = fVein.getFeature();
					length += srcFeatures.length;
					if (i > 0) {
						System.arraycopy(srcFeatures, 0, destFeatures, length - srcFeatures.length, srcFeatures.length);
					} else {
						System.arraycopy(srcFeatures, 0, destFeatures, 0, srcFeatures.length);
					}
					i++;
				}
				results = recognition(fingerVein.getFeature(), destFeatures, list.size());
				if (Float.parseFloat(String.valueOf(results[0])) > threshold && results[1] > -1) {
					index++;
					break;
				} else {
					index++;
				}
			}
			
			/*try {
				for (List<FingerVein> list : fingerVeinList) {
					Future<int[]> future = pools.submit(new RecognitionCallable(list, fingerVein.getFeature(), destFeatures));
					results = future.get();
					if (Float.parseFloat(String.valueOf(results[0])) > threshold && results[1] > -1) {
						index++;
						break;
					} else {
						index++;
					}
				}
			} catch (Exception e) {}*/
		}
		LOGGER.info("指静脉识别结束，执行时间： " + (System.currentTimeMillis() - startTime) + "ms");
		LOGGER.info("指静脉识别相似度：" + results[0] + "，索引：" + results[1]);

		StringBuilder message = new StringBuilder("");
		FingerVein fVein = fingerVeins.get((index - 1) * TEMPLATE_SIZE + results[1]);
		String employeeId = fVein.getEmployeeId();
		EmployeeData employee = employeeDao.getDataById(employeeId);
		message.append(employee.getName()).append("=").append(employee.getCode()).append("=").append(fVein.getSeq())
				.append("=").append(results[0]);

		RecognitionLog recognitionLog = new RecognitionLog();
		recognitionLog.setId(UUIDGeneratorUtil.getUUID());
		recognitionLog.setName(employee.getName());
		recognitionLog.setCode(employee.getCode());
		recognitionLog.setSeq(fVein.getSeq());
		recognitionLog.setThreshold(String.valueOf(results[0]));
		recognitionLog.setIndexed(results[1]);
		recognitionLog.setOrgName(employee.getOrgName());
		recognitionLog.setIpaddr(ipaddr);
		recognitionLog.setType("1");
		recognitionLog.setEmployeeId(employeeId);
		recognitionLog.setFingerveinId(fVein.getId());
		recognitionLog.setCreateTime(new Date());
		recognitionLog.setCreateBy(OptEnum.SYSTEM.name().toLowerCase());
		
		Result result = new Result();
		if (Float.parseFloat(String.valueOf(results[0])) > threshold && results[1] > -1) {
			// 识别通过
			if (!StringUtils.isEmpty(employee.getOrgName())) {
				message.append("=").append(employee.getOrgName());
			}
			result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
			recognitionLog.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
		} else {
			LOGGER.info("识别失败");
			result.setCode(String.valueOf(StatusEnum.FAIL.getValue()));
			recognitionLog.setStatus(String.valueOf(StatusEnum.FAIL.getValue()));
		}
		File file = null;
		try {
			file = writeFile(message.toString(), result.getCode(), sample, ipaddr);
		} catch (Exception e) {
			LOGGER.error("文件写入失败", e);
		}
		if (file != null) {
			String path = file.getPath();
			path = path.substring(folder.length() + 1);
			recognitionLog.setFilePath(path);
		}
		try {
			recognitionLogDao.save(recognitionLog);
		} catch (Exception e) {
			LOGGER.error("识别日志保存失败", e);
		}
		result.setMessage(message.toString());
		return result;
	}

	@Override
	public Result recognitionPassword(String json, String ipaddr) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		String password = jsonObject.getString("password");
		if (StringUtils.isEmpty(password)) {
			throw new IllegalArgumentException("密码不能为空");
		}
		Result result = new Result();
		RecognitionLog recognitionLog = new RecognitionLog();
		recognitionLog.setId(UUIDGeneratorUtil.getUUID());
		recognitionLog.setIpaddr(ipaddr);
		recognitionLog.setType("2");
		recognitionLog.setCreateTime(new Date());
		recognitionLog.setCreateBy(OptEnum.SYSTEM.name().toLowerCase());
		if (password.equals(this.rpassword)) {
			recognitionLog.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
			result.setCode(String.valueOf(StatusEnum.SUCCESS.getValue()));
			result.setMessage("验证通过");
		} else {
			LOGGER.info("验证不通过");
			recognitionLog.setStatus(String.valueOf(StatusEnum.FAIL.getValue()));
			result.setCode(String.valueOf(StatusEnum.FAIL.getValue()));
			result.setMessage("验证不通过");
		}
		try {
			recognitionLogDao.save(recognitionLog);
		} catch (Exception e) {
			LOGGER.error("识别日志保存失败", e);
		}
		return result;
	}

	/**
	 * 创建特征模板
	 * 
	 * @param count
	 */
	private void createTemplates(int count) {
		if (count == 0) {
			String ipaddr = "127.0.0.1";
			try {
				registerEmployee(registerEmployeeJson, ipaddr);
				for (int i = 0; i < Integer.parseInt(registerLength); i++) {
					registerFingerVein(registerFingerVeinJson, ipaddr);
				}
			} catch (Exception e) {
				LOGGER.error("初始化指静脉数据失败", e);
			}
		} else {
			int size = count % 1000;
			if (size > 0 && size < 3) {
				// 如果小于3条，补充3条模板
				for (int i = 0; i < 3; i++) {
					fingerVeins.add(fingerVeins.get(0));
				}
			}
		}
	}
	
	/**
	 * 指静脉识别
	 * 
	 * @param sample
	 * @param template
	 * @param size
	 * @return
	 */
	private int[] recognition(byte[] feature, byte[] template, int size) {
		int[] index = new int[] { 0 };
		int[] statusNum = new int[] { 0 };
		int[] similarity = new int[] { 0 };
		int[] modelNum = new int[] { size };

		GRGFingerRecognitionJNI.GRGRecognition(feature, template, modelNum, index, similarity, statusNum);
		return new int[] { similarity[0], index[0] };
	}
	
	private File writeFile(String result, String code, String sample, String ip) {
		String folder = this.folder;
		String[] message = result.split("[=]");
		if (String.valueOf(StatusEnum.SUCCESS.getValue()).equals(code)) {
			folder += File.separator + "accept";
		} else {
			folder += File.separator + "reject";
		}
		
		//创建文件目录
		File file = FileUtil.mkdirs(folder, ip);
		String fileName = message[1] + "_" + message[2] + "_" + message[0];
		if (message.length > 5) {
			fileName += "_" + message[5];
		}
		String date = DateUtil.getDayTime(new Date());
		fileName += "_" + message[3] + "_" + date.replaceAll(" ", "_").replaceAll(":", "-");
		return FileUtil.writeFile(file.getPath() + File.separator + fileName + ".bin", sample);
	}
}

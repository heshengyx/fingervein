package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.fingervein.dao.IFingerVeinDao;
import com.grgbanking.fingervein.data.FingerVeinData;
import com.grgbanking.fingervein.entity.FingerVein;
import com.grgbanking.fingervein.param.FingerVeinQueryParam;
import com.grgbanking.fingervein.service.IFingerVeinService;
import com.grgbanking.fingervein.util.FileUtil;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

public class FingerVeinJunitTest extends BaseJunitTest {

	@Autowired
	private IFingerVeinService fingerVeinService;
	
	@Autowired
	private IFingerVeinDao fingerVeinDao;
	
	@Test
	public void testQueryData() {
		List<FingerVeinData> list = fingerVeinDao.queryData();
		int i = 0;
		for (FingerVeinData fingerVeinData : list) {
			String name = fingerVeinData.getName();
			String code = fingerVeinData.getCode();
			String seq = fingerVeinData.getSeq();
			byte[] data = fingerVeinData.getFeature();
			try {
				FileUtil.writeFile("E:/templates/" + name + "_" + code + "_" + seq + "_" + (i++) + ".bin", data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testSaveBatch() {
		List<FingerVein> fingerVeins = new ArrayList<FingerVein>();
		for (int i = 10; i < 50; i++) {
			FingerVein fingerVein = new FingerVein();
			fingerVeins.add(fingerVein);
		}
		fingerVeinService.saveBatch(fingerVeins);
	}
	
	@Test
	public void testQueryAll() {
		FingerVeinQueryParam param = new FingerVeinQueryParam();
		param.setStatus("1");
		List<FingerVein> fingerVeins = fingerVeinService.queryAll(param);
		for (FingerVein fingerVein : fingerVeins) {
			//System.out.println(fingerVein.getId());
			fingerVein.setId(UUIDGeneratorUtil.getUUID());
			fingerVeinService.save(fingerVein);
			//String fea = BASE64Util.encode(fingerVein.getFeature());
			//System.out.println(fea.replaceAll("\\s", ""));
			//System.out.println(fingerVein.getEmployeeId());
			//break;
		}
	}
}

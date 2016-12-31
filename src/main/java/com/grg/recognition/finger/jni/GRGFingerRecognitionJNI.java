package com.grg.recognition.finger.jni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指静脉JNI
 */
public class GRGFingerRecognitionJNI {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(GRGFingerRecognitionJNI.class);

	static {
		String classPath = GRGFingerRecognitionJNI.class.getResource("/") + "";
		String dllPath = classPath.substring(6) + "bin/Finger/GRG/";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			System.load(dllPath + "GRGfingerVenaIDAlgorithm.dll");
			System.load(dllPath + "GRGFingerVeinJNI.dll");
			LOGGER.info("加载指静脉*.dll库成功");
		} else {
			System.load(dllPath + "GRGfingerVenaIDAlgorithm.so");
			System.load(dllPath + "GRGFingerVeinJNI.so");
			LOGGER.info("加载指静脉*.so库成功");
		}
	}

	/**
	 * 输入待认证的指静脉模板与注册的指静脉模板，返回两者的相似度 in:param :identifyModel:待认证的指静脉模板 in:param
	 * :registerModel:已注册指静脉模板 out:param:similarity:相似度（0-100），取值范围0到100，
	 * 数值越大表示越相似 out:param:statusNum 状态码
	 */
	public native static void GRGIdentify(byte[] indentifyModel, byte[] registerModel, int[] similarity,
			int[] statusNum);

	public native static void GRGIdentifyReader(byte[] inputImg, byte[] outputModel, int[] statusNum);

	public native static void GRGRegister(byte[] srcModel_1, byte[] srcModel_2, byte[] srcModel_3, byte[] dstModel,
			int[] statusNum);

	public native static void GRGSameFinger(byte[] model1, byte[] model2, int[] same, int[] statusNum);

	public native static void GRGIdentifySingelModel(byte[] indentifyModel, byte[] registerModel, int[] similarity,
			int[] statusNum);

	// 新增1:N识别接口
	public native static void GRGRecognition(byte[] identifyModel, byte[] registerModel, int[] modelNum, int[] index,
			int[] similarity, int[] statusNum);

}

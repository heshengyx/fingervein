package com.grgbanking.fingervein.callable;

import java.util.List;
import java.util.concurrent.Callable;

import com.grg.recognition.finger.jni.GRGFingerRecognitionJNI;
import com.grgbanking.fingervein.entity.FingerVein;

public class RecognitionCallable implements Callable<int[]> {

	private List<FingerVein> fingerVeins;
	private byte[] feature;
	private byte[] destFeatures;
	
	public RecognitionCallable(List<FingerVein> fingerVeins, byte[] feature,
			byte[] destFeatures) {
		this.fingerVeins = fingerVeins;
		this.feature = feature;
		this.destFeatures = destFeatures;
	}

	@Override
	public int[] call() throws Exception {
		if (Thread.currentThread().isInterrupted()) {
			System.out.println("=====================Thread.currentThread().isInterrupted()");
			throw new InterruptedException("中断线程");
		}
		int i = 0;
		int length = 0;
		for (FingerVein fVein : fingerVeins) {
			byte[] srcFeatures = fVein.getFeature();
			length += srcFeatures.length;
			if (i > 0) {
				System.arraycopy(srcFeatures, 0, destFeatures, length - srcFeatures.length, srcFeatures.length);
			} else {
				System.arraycopy(srcFeatures, 0, destFeatures, 0, srcFeatures.length);
			}
			i++;
		}
		return recognition(feature, destFeatures, fingerVeins.size());
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
}

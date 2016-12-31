package com.grgbanking.fingervein.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class BASE64Util {
	
	private BASE64Util() {}

	/**
	 * 解码
	 * @param content
	 * @return
	 * @throws IOException
	 */
	public static byte[] decoder(String content) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] data = decoder.decodeBuffer(content);
		for (int i = 0; i < data.length; ++i) {
			if (data[i] < 0) {
				data[i] += 256;
			}
		}
		return data;
	}
	
	/**
	 * 编码
	 * @param fileName
	 * @return
	 */
	public static String encode(String fileName) throws IOException {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(fileName);
			data = new byte[in.available()];
			in.read(data);
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {throw e;}
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	/**
	 * 编码
	 * @param data
	 * @return
	 */
	public static String encode(byte[] data) {
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	// 图片转化成base64字符串
	public static String getImageStr(String imgFile) {
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	// base64字符串转化成图片
	public static boolean generateImage(String imgStr) {
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream out = null;
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; i++) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = "d://222.jpg";// 新生成的图片
			out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			return true;
		} catch (Exception e) {
			return false;
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

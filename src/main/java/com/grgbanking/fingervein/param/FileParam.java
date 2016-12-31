package com.grgbanking.fingervein.param;

import java.io.Serializable;

public class FileParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String filePath;
	private String fileFolder;
	private int fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileFolder() {
		return fileFolder;
	}
	public void setFileFolder(String fileFolder) {
		this.fileFolder = fileFolder;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
}

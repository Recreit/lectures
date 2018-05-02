package com.ohhoonim.vo;

public class FilesVo {
	private String filesId;
	private String filesNm;
	private String filesUfn;
	private String filesSize;
	private String filesType;
	private String filesDl;

	public String getFilesId() {
		return filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}

	public String getFilesNm() {
		return filesNm;
	}

	public void setFilesNm(String filesNm) {
		this.filesNm = filesNm;
	}

	public String getFilesUfn() {
		return filesUfn;
	}

	public void setFilesUfn(String filesUfn) {
		this.filesUfn = filesUfn;
	}

	public String getFilesSize() {
		return filesSize;
	}

	public void setFilesSize(String filesSize) {
		this.filesSize = filesSize;
	}

	public String getFilesType() {
		return filesType;
	}

	public void setFilesType(String filesType) {
		this.filesType = filesType;
	}

	public String getFilesDl() {
		return filesDl;
	}

	public void setFilesDl(String filesDl) {
		this.filesDl = filesDl;
	}

	@Override
	public String toString() {
		return "FilesVo [ fileN=" + filesNm + ", fileU=" + filesUfn + ", fileS=" + filesSize + ", cType=" + filesType
				+ ", link=" + filesDl + "]";
	}

}

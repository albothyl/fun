package org.project.common.module.file.vo;

public class FileVO {
	
	protected String convertFileName;
	protected String filePath;
	protected int    bbsno;
	protected String orgFileName;
	
	public FileVO(String convertFileName, String filePath, String orgFileName) {
		this.convertFileName = convertFileName;
		this.filePath        = filePath;
		this.orgFileName     = orgFileName;
	}

	public String getConvertFileName() {
		return convertFileName;
	}
	public void setConvertFileName(String convertFileName) {
		this.convertFileName = convertFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	@Override
	public String toString() {
		return "fileInfoVO [convertFileName=" + convertFileName + ", filePath="
				+ filePath + ", bbsno=" + bbsno + ", orgFileName="
				+ orgFileName + "]";
	}
}

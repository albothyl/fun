package org.project.common.vo;

public class SearchVO {
	private String subject;
	private String title;
	private String content;
	private String writer;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "searchVO [subject=" + subject + ", title=" + title
				+ ", content=" + content + ", writer=" + writer + "]";
	}	
	
}

package org.project.member.certification.dto;

public class Certification {
	private String email;
	private int    randomKey;
	
	public Certification() {
		super();
	}
	
	public Certification(String email, int randomKey) {
		super();
		this.email = email;
		this.randomKey = randomKey;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRandomKey() {
		return randomKey;
	}
	public void setRandomKey(int randomKey) {
		this.randomKey = randomKey;
	}
	
	@Override
	public String toString() {
		return "certificationVO [email=" + email + ", randomKey=" + randomKey
				+ "]";
	}
	
}

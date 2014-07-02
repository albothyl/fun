package org.project.member.dto;

public class Duplication {
	boolean duplicated;
			
	public Duplication() {
		super();
	}

	public Duplication(boolean duplicated) {
		super();
		this.duplicated = duplicated;
	}

	public boolean getDuplicated() {
		return duplicated;
	}

	public void setDuplicated(boolean duplicated) {
		this.duplicated = duplicated;
	}

	@Override
	public String toString() {
		return "Duplication [duplicated=" + duplicated + "]";
	}	
	
}

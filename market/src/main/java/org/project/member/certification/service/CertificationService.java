package org.project.member.certification.service;

import org.project.member.certification.dto.Certification;

public interface CertificationService {
	//certification
	public Certification certify(String email);
	public boolean certified(Certification certification);
}

package org.project.member.certification.dao;

import org.project.member.certification.dto.Certification;

public interface CertificationDAO {
	//certification
	public void certify(Certification certification);
	public Certification certified(String email);
	public void certifyComplete(String email);
}

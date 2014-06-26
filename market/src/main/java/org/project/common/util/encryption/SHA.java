package org.project.common.util.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.project.common.system.customAnnotation.Util;

@Util("shaEncryption")
public class SHA {
	private String savePassword;
	
	public boolean encryption(String inputPassword, String Algorithm) {
		MessageDigest md;
	    boolean isSuccess;
	    String  tempPassword = "";
	
	    try {
	        md = MessageDigest.getInstance(Algorithm);
	
	        md.update(inputPassword.getBytes());
	        byte[] mb = md.digest();
	        for (int i = 0; i < mb.length; i++) {
	            byte temp = mb[i];
	            String s = Integer.toHexString(new Byte(temp));
	            while (s.length() < 2) {
	                s = "0" + s;
	            }
	            s = s.substring(s.length() - 2);
	            tempPassword += s;
	        }
	        setPassword(tempPassword);
	        isSuccess = true;
	    } catch (NoSuchAlgorithmException e) {
	        isSuccess = false;
	        return isSuccess;
	    }
	    return isSuccess;
	}

	private void setPassword(String temppassword) {
	    this.savePassword = temppassword;
	}
	
	public String getPassword() {
	    return savePassword;
	}
}

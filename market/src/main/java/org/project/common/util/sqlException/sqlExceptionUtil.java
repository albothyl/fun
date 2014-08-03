package org.project.common.util.sqlException;

import java.sql.SQLException;

import org.project.common.system.globalCode.defineCode;

public class sqlExceptionUtil {
	
	public int sqlResultCheck(SQLException e) {
		
		if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
		{			
			System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
			
			if(e.getErrorCode() != defineCode.SQLCODE_NOTFOUND)
			{
				System.out.println("SQL ERROR MSG   :: " + e.getMessage());
				return defineCode.SQLCODE_NOTFOUND;
			}
			else if(e.getErrorCode() != defineCode.SQLCODE_DUP)
			{
				System.out.println("SQL ERROR MSG   :: " + e.getMessage());
				return defineCode.SQLCODE_DUP;
			}
			else
			{
				System.out.println("SQL ERROR MSG   :: " + e.getMessage());
				return defineCode.SQLCODE_ELSE;
			}
		}
		return defineCode.SQLCODE_GOOD;
	}
}

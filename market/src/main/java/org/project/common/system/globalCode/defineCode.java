package org.project.common.system.globalCode;

public class defineCode {
	
	//SQL ERROR CODE	
	public static final int SQLCODE_GOOD     =  0;    //query success
	public static final int SQLCODE_DUP      = -1;
	public static final int SQLCODE_NOTFOUND =  1403;
	public static final int SQLCODE_EOQ      =  1403;
	public static final int SQLCODE_EOF      =  1403;
	public static final int SQLCODE_NULL     = -1405; //include NULL data field
	public static final int SQLCODE_NOTEXIST = -942;
	public static final int SQLCODE_OVF      = -2112;
	public static final int SQLCODE_ELSE     = -9999;
	
	//BOARD SUBJECT CODE
	public static final int IS_OK = 1;
	public static final int NOT_FOUND_EMAIL = 2;
	public static final int WRONG_CERIFICATION_KEY = 3;
	
	//MENU LIST DEFAULT VALUE
	public static final int MENU_PAGE_CNT = 10;
	public static final int MENU_PAGE_NUM = 1;
	
	//CODE SEARCH
	public static final int TRADE_STATUS_CODE    = 1;
	public static final int SHTBOARD_SEARCH_CODE = 2;
	public static final int SWINDLE_SEARCH_CODE  = 3;
}

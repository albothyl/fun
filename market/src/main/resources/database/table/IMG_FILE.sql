CREATE TABLE IMG_FILE
(
	CONVERTFILENAME VARCHAR2(100)
  , FILEPATH        VARCHAR2(200) NOT NULL
  , BBSNO           NUMBER
  , ORGFILENAME     VARCHAR2(100) NOT NULL
  , CREATEDATE      DATE          DEFAULT  SYSDATE
  , CONSTRAINT IMG_FILE_PK_CONVERTNAME PRIMARY KEY(convertFileName)
  , CONSTRAINT IMG_FILE_FK_BBSNO       FOREIGN KEY(BBSNO) REFERENCES ANYANG.SHTBOARD(TRADENO) ON DELETE CASCADE
);
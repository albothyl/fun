CREATE TABLE SWINDLE(
	ACCOUNT          VARCHAR2(50)   NOT NULL ,
    ACCOUNTOWNER     VARCHAR2(15)   NOT NULL ,
    PHONENUMBER      VARCHAR2(13)   NOT NULL ,
    WRITER           VARCHAR2(50)   NOT NULL ,
    BANKNAME         VARCHAR2(20)   NOT NULL ,
    SWINDLEPRICE     NUMBER         NOT NULL ,
    SWINDLEDATE      DATE,
    SWINDLELOCATION  VARCHAR2(25),
    SWINDLEITEMNAME  VARCHAR2(25)   NOT NULL ,    
    TITLE            VARCHAR2(50)   NOT NULL ,
    CONTENT          VARCHAR2(3000) NOT NULL ,    
    CREATEDATE       DATE DEFAULT SYSDATE
);

--한사람이 동일한 사건에 대해서 스팸할 수 있기때문에 이 조건에 해당하는 복합키를 생각해봐야함
ALTER TABLE SWINDLE ADD CONSTRAINT SWINDLE_PK_COMPOUND PRIMARY KEY (ACCOUNT, PHONENUMBER, ACCOUNTOWNER, WRITER);

------------------------------------------------------------

CREATE TABLE SWINDLE(
	SWINDLENO        NUMBER         CONSTRAINT SWINDLE_PK_SWINDLENO PRIMARY KEY ,
	BANKNAME         VARCHAR2(20)   NOT NULL ,
	ACCOUNT          VARCHAR2(25)   NOT NULL ,
    ACCOUNTOWNER     VARCHAR2(15)   NOT NULL ,
    PHONENUMBER      VARCHAR2(13)   NOT NULL ,
    SWINDLEDATE      DATE,
    SWINDLELOCATION  VARCHAR2(25),
    SWINDLER         VARCHAR2(25),
    SWINDLEITEM      VARCHAR2(25)   NOT NULL ,
    SWINDLEPRICE     NUMBER         NOT NULL ,
    TITLE            VARCHAR2(50)   NOT NULL ,
    CONTENT          VARCHAR2(3000) NOT NULL ,
    WRITER           VARCHAR2(50)   NOT NULL ,
    CREATEDATE       DATE DEFAULT SYSDATE
);

CREATE SEQUENCE SWINDLE_SWINDLENO_SEQ
START   WITH 1
INCREMENT BY 1
;

--필요한 경우 각각에 대해서 빠른 검색이 필요하기 때문에 각각 인덱스를 추가한다.
CREATE INDEX SWINDLE_ACCOUNT     ON SWINDLE(ACCOUNT);
CREATE INDEX SWINDLE_SWINDLER    ON SWINDLE(SWINDLER);
CREATE INDEX SWINDLE_PHONENUMBER ON SWINDLE(PHONENUMBER);
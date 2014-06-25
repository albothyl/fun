CREATE TABLE MEMBER( 
    EMAIL VARCHAR2(50) CONSTRAINT MEMBER_PK_EMAIL PRIMARY KEY
  , PW VARCHAR2(64) NOT NULL
  , NICK VARCHAR2(50) NOT NULL
  , GRADE NUMBER NOT NULL
  , JOINDATE DATE DEFAULT SYSDATE
);

DROP TABLE  MEMBER;

SELECT *
FROM   MEMBER;

DELETE FROM MEMBER;
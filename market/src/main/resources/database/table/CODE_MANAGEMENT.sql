CREATE TABLE CODE_MANAGEMENT(
    GROUPCODE NUMBER NOT NULL
  , SUBCODE   NUMBER NOT NULL
  , CODENAME  VARCHAR2(30) NOT NULL
  , UPDATEDATE DATE DEFAULT SYSDATE 
);

ALTER TABLE CODE_MANAGEMENT ADD CONSTRAINT CODE_MANAGEMENT_PK_COMPOUND PRIMARY KEY(GROUPCODE, SUBCODE);

INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(1, 9999, '거래상태그룹코드');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(1, 0, '거래중');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(1, 1, '거래완료');

INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(2, 9999, '중고거래게시판검색조건그룹코드');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(2, 0, '제목');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(2, 1, '젝목+내용');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(2, 2, '작성자');

INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(3, 9999, '사기꾼검색게시판조건그룹코드');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(3, 0, '계좌번호');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(3, 1, '전화번호');
INSERT INTO CODE_MANAGEMENT(GROUPCODE, SUBCODE, CODENAME)  VALUES(3, 2, '거래자');
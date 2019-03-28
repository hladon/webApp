CREATE TABLE ITEM (
ID INTEGER,
CONSTRAINT ITEM_PK PRIMARY KEY(ID),
NAME NVARCHAR2(50),
DATE_CREATED TIMESTAMP,
LAST_UPDATE TIMESTAMP,
DESCRIPTION NVARCHAR2(250)
);

CREATE SEQUENCE ITEM_SK MINVALUE 1 MAXVALUE 100 START WITH 1 INCREMENT BY 1;
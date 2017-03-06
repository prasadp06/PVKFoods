CREATE USER 'pvkfoods'@'localhost' IDENTIFIED BY 'pvkfoods';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON pvkfoods.*  TO 'pvkfoods'@'localhost';


CREATE TABLE PVK_STATUS_TYPE_LKUP (STATUS_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, STATUS_TYPE_DESC VARCHAR(100));

CREATE TABLE PVK_USER_TYPE_LKUP (USER_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, USER_TYPE_DESC VARCHAR(100));

CREATE TABLE PVK_UUID_TYPE_LKUP (UUID_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, UUID_TYPE_DESC VARCHAR(100));

CREATE TABLE PVK_ADDRESS_TYPE_LKUP (ADDRESS_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, ADDRESS_TYPE_DESC VARCHAR(100));

CREATE TABLE PVK_PHONE_TYPE_LKUP (PHONE_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, PHONE_TYPE_DESC VARCHAR(100));

CREATE TABLE PVK_OWNER_LKUP (OWNER_CD VARCHAR(10) PRIMARY KEY NOT NULL, OWNER_NAME VARCHAR(100));

CREATE TABLE PVK_UOM_TYPE_LKUP(UOM_TYPE_CD VARCHAR(10) PRIMARY KEY NOT NULL, UOM_TYPE_DESC VARCHAR(50));

CREATE TABLE PVK_DESIGNATION_LKUP (DESIGNATION_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                                   DESIGNATION_TITLE VARCHAR(100),
                                  DESIGNATION_DESC VARCHAR(250));

CREATE TABLE PVK_COUNTERY_LKUP (COUNTRY_CD VARCHAR(10) PRIMARY KEY NOT NULL, COUNTRY_NAME VARCHAR(100));

CREATE TABLE PVK_STATE_LKUP (STATE_CD VARCHAR(10), COUNTRY_CD VARCHAR(10) NOT NULL, STATE_NAME VARCHAR(100), 
                            PRIMARY KEY (STATE_CD, COUNTRY_CD));

CREATE TABLE PVK_ADDRESS (ADDRESS_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                          ADDRESS1 VARCHAR(50), STREET VARCHAR(50), CITY VARCHAR(50), 
                          STATE_CD VARCHAR(10) REFERENCES PVK_STATE_LKUP(STATE_CD),
                          COUNTRY_CD VARCHAR(10) REFERENCES PVK_COUNTERY_LKUP(COUNTRY_CD),
                          PINCODE VARCHAR(15),
                          ADDRESS_TYPE_CD VARCHAR(10) REFERENCES PVK_ADDRESS_TYPE_LKUP(ADDRESS_TYPE_CD)
                         );
                         
CREATE TABLE PVK_PHONE (PHONE_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                          PHONE_NUMBER VARCHAR(50),
                          PHONE_TYPE_CD VARCHAR(10) REFERENCES PVK_PHONE_TYPE_LKUP(PHONE_TYPE_CD)
                         );

CREATE TABLE PVK_USER (USER_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                       USERNAME VARCHAR(100) UNIQUE NOT NULL, 
                       PASSWORD VARCHAR(255) NOT NULL,  
                       USER_TYPE_CD VARCHAR(10) REFERENCES PVK_USER_TYPE_LKUP(USER_TYPE_CD),
                       FIRST_NAME VARCHAR(50),
                       LAST_NAME VARCHAR(50),
                       MIDDLE_NAME VARCHAR(50),
                       DOB DATE, 
                       UUID VARCHAR(50),
                       UUID_TYPE_CD VARCHAR(10) REFERENCES PVK_UUID_TYPE_LKUP(UUID_TYPE_CD),
                       DEACTIVE DATE,
                       EMAIL VARCHAR(60),
                       CREATE_DATE DATE,
                       UPDATED_BY VARCHAR(100), 
                       UPDATED_DATE DATE
                      );

CREATE TABLE PVK_ADDRESS_XREF (OWNER_ID INTEGER , 
                              ADDRESS_ID INTEGER REFERENCES PVK_ADDRESS(ADDRESS_ID),
                              PRIMARY_ADDR VARCHAR(1) DEFAULT 'N',
                              OWNER_CD VARCHAR(10) REFERENCES PVK_OWNER_LKUP(OWNER_CD),
                              UDATED_BY VARCHAR(100), 
                              UPDATED_DATE DATE ,
                              PRIMARY KEY (OWNER_ID, ADDRESS_ID, OWNER_CD));
                              
CREATE TABLE PVK_PHONE_XREF (OWNER_ID INTEGER, 
                              PHONE_ID INTEGER,
                              PRIMARY_PHONE VARCHAR(1) DEFAULT 'N',
                              OWNER_CD VARCHAR(10) REFERENCES PVK_OWNER_LKUP(OWNER_CD),
                              UDATED_BY VARCHAR(100), 
                              UPDATED_DATE DATE ,
                              PRIMARY KEY (OWNER_ID, PHONE_ID, OWNER_CD));


CREATE TABLE PVK_PRODUCT (PRODUCT_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                           PRODUCT_TITLE VARCHAR(250) NOT NULL, 
                           PRODUCT_DESC VARCHAR(2500),
	                       PRODUCT_STATUS VARCHAR(1) NOT NULL,
                           PRODUCT_UNIT DECIMAL(5,2), 
                           UNIT_UOM VARCHAR(10) REFERENCES PVK_UOM_TYPE_LKUP(UOM_TYPE_CD),
                           UNIT_PRICE DECIMAL(5,2),
                           UPDATED_BY VARCHAR(100), 
                           UPDATED_DATE DATE );
                           
CREATE TABLE PVK_CUSTOMER (CUSTOMER_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	                       CUSTOMER_NAME VARCHAR(250) NOT NULL, 
                           UUID VARCHAR(50),
                           UUID_TYPE_CD VARCHAR(10) REFERENCES PVK_UUID_TYPE_LKUP(UUID_TYPE_CD),
                           EMAIL VARCHAR(60),
                           UPDATED_BY VARCHAR(100), 
                           UPDATED_DATE DATE );

CREATE TABLE PVK_BRANCH (BRANCH_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
                              BRANCH_NAME VARCHAR(250) NOT NULL, 
                              PRIMARY_BRANCH VARCHAR(1) DEFAULT 'N',
                              STATUS_CD VARCHAR(10) REFERENCES PVK_STATUS_TYPE_LKUP(STATUS_TYPE_CD),
                              UDATED_BY VARCHAR(100), 
                              UPDATED_DATE DATE);
                              
 
 CREATE TABLE PVK_BRANCH_XREF (OWNER_ID INTEGER, 
                              BRANCH_ID INTEGER,
                              OWNER_CD VARCHAR(10) REFERENCES PVK_OWNER_LKUP(OWNER_CD),
                              UDATED_BY VARCHAR(100), 
                              UPDATED_DATE DATE ,
                              PRIMARY KEY (OWNER_ID, BRANCH_ID, OWNER_CD));
                              

CREATE TABLE PVK_SUPPLIER (SUPPLIER_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	                       SUPPLIER_NAME VARCHAR(250) NOT NULL, 
                           UUID VARCHAR(50),
                           UUID_TYPE_CD VARCHAR(10) REFERENCES PVK_UUID_TYPE_LKUP(UUID_TYPE_CD),
                           EMAIL VARCHAR(60),
                           UPDATED_BY VARCHAR(100), 
                           UPDATED_DATE DATE );

    
CREATE TABLE PVK_PRODUCT_SUPPLIER (SUPPLIER_ID INTEGER,  
                                   PRODUCT_ID INTEGER,
                                   UPDATED_BY VARCHAR(100), 
                                   UPDATED_DATE DATE,
                                   PRIMARY KEY (SUPPLIER_ID, PRODUCT_ID));
                                   
CREATE TABLE PVK_ORDER (ORDER_ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,  
                        SALES_AGENT_ID INTEGER REFERENCES PVK_USER(USER_ID),
                        CUSTOMER_ID INTEGER REFERENCES PVK_CUSTOMER(CUSTOMER_ID),
                        TOT_AMOUNT DECIMAL(10,2),
                        ORDER_DATE DATE, 
                        UPDATED_BY VARCHAR(100), 
                        UPDATED_DATE DATE);
                        
CREATE TABLE PVK_ORDER_PRODUCT (ORDER_ID INTEGER REFERENCES PVK_ORDER(ORDER_ID),  
                                PRODUCT_ID INTEGER REFERENCES PVK_PRODUCT(PRODUCT_ID),
                                QUANTITY INTEGER ,
                                UOM VARCHAR(10) REFERENCES PVK_UOM_TYPE_LKUP(UOM_TYPE_CD),
                                UPDATED_BY VARCHAR(100), 
                                UPDATED_DATE DATE,
                               PRIMARY KEY (ORDER_ID, PRODUCT_ID));    
                               

CREATE TABLE PVK_SALES_TARGET (SALES_AGENT_ID INTEGER REFERENCES PVK_USER(USER_ID),  
                                TARGET_AMOUNT DECIMAL(10,2),
                                TARGET_FROM DATE ,
                                TARGET_TO DATE ,
                                UPDATED_BY VARCHAR(100), 
                                UPDATED_DATE DATE,
                                PRIMARY KEY (SALES_AGENT_ID, TARGET_FROM, TARGET_TO));  
                                   
                                 
                                   
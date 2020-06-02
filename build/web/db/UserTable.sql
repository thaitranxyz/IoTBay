/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  trandamtrungthai
 * Created: 28/05/2020
 */
-- DROP TABLE CUSTOMER // uncomment this to delete table
CREATE TABLE REGISTEREDUSER 
(
    USERID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FIRSTNAME VARCHAR(30),
    LASTNAME VARCHAR(30),
    EMAIL VARCHAR(30),
    PASSWORD VARCHAR(20),   
    PHONE BIGINT,
    ADDRESS VARCHAR(30),
    ROLE INT DEFAULT 0,

    PRIMARY KEY (EMAIL, CUSTOMERID)
)
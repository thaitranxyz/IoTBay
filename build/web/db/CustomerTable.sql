/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  trandamtrungthai
 * Created: 28/05/2020
 */
DROP TABLE CUSTOMER
CREATE TABLE CUSTOMER 
(
    CUSTOMERID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FIRSTNAME VARCHAR(30),
    LASTNAME VARCHAR(30),
    EMAIL VARCHAR(30),
    PASSWORD VARCHAR(20),   
    PHONE INT,
    ADDRESS VARCHAR(30),

    PRIMARY KEY (EMAIL, CUSTOMERID);
)
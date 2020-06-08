 /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  theod
 * Created: 06/06/2020
 */
--DROP TABLE ORDERS
CREATE TABLE ORDERS
(
    ORDERID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    EMAIL VARCHAR(30) NOT NULL,
    "DATE" VARCHAR(10) NOT NULL,
    USERID INT,
    PRODUCTID INT NOT NULL,
    QUANTITY INT NOT NULL,
    TRANSACTIONID INT NOT NULL,
    ADDRESS VARCHAR(50) NOT NULL,
    STATUS VARCHAR(12) NOT NULL,
    TRACKINGCODE VARCHAR(12) NOT NULL,

    PRIMARY KEY (ORDERID)
  
)
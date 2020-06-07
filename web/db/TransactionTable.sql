/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  theod
 * Created: 06/06/2020
 */

CREATE TABLE TRANSACTIONS
(
    TRANSACTIONID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    EMAIL VARCHAR(20) NOT NULL,
    "TYPE" VARCHAR(10), 
    RECEIPTID VARCHAR(15), 
    STATUS VARCHAR(10) NOT NULL,

    PRIMARY KEY (TRANSACTIONID)
)

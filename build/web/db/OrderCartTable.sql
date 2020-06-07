/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  theod
 * Created: 07/06/2020
 */

CREATE TABLE CARTITEMS
(
    CARTID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    ORDERID INT,
    PRODUCTID INT NOT NULL,
    PRICE DOUBLE NOT NULL,
    QUANTITY INT NOT NULL,

    PRIMARY KEY (CARTID),
    FOREIGN KEY (PRODUCTID) REFERENCES PRODUCTS(PRODUCTID),
    FOREIGN KEY (ORDERID) REFERENCES ORDERS (ORDERID)
)
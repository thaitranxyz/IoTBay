/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  trandamtrungthai
 * Created: 03/06/2020
 */

CREATE TABLE ACCESSLOG
(
    ACCESSLOGID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    USERID INT,
    LOGINDATETIME VARCHAR(30),
    LOGOUTDATETIME VARCHAR(30),

    PRIMARY KEY(ACCESSLOGID)
)
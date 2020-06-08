/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  pikachu125
 * Created: 06/06/2020
 */
CREATE TABLE Payment
(creditCardNumber VARCHAR(16) NOT NULL,
userId INT NOT NULL,
creditCardExpiry VARCHAR(5),
creditCardCVC VARCHAR(3),
isDefault int,
PRIMARY KEY (creditCardNumber),
FOREIGN KEY (userId) REFERENCES CUSTOMER(userId)
);

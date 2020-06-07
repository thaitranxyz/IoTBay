CREATE TABLE Customer
(customerId INT GENERATED ALWAYS AS IDENTITY NOT NULL,
customerName VARCHAR(32) NOT NULL,
customerAddress VARCHAR(64) NOT NULL,
customerEmail VARCHAR(32) NOT NULL,
customerPhone BIGINT,
customerPassword VARCHAR(32),
PRIMARY KEY (customerId));
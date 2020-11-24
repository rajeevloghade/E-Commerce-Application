/*
    CREATE DATABASE ECOM;

    USE ECOM;

    CREATE TABLE USERS
    (
    email varchar(50) PRIMARY KEY,
    username varchar(50),
    Mobile varchar(50),
    Address varchar(60),
    password varchar(50)       
    );

    CREATE TABLE Products
    (
    Pcode varchar(50) PRIMARY KEY,
    Pname varchar(50),
    Pdesc text,
    Pcategory varchar(60),
    Price varchar(50)       
    );

    CREATE TABLE Orders
    (    
    Orderid int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Userid varchar(50) NOT NULL,
    Pcode varchar(50),
    Pname varchar(50),    
    Pcategory varchar(60),
    Price varchar(50),
    CONSTRAINT Userid_fk FOREIGN KEY(Userid) REFERENCES Users (email)
    );


    INSERT INTO products VALUES(?,?,?,?,?);

    SELECT * FROM Products WHERE PCode=?;

    UPDATE Products SET Pname=?,Pdesc=?,PCategory=?,Price=? WHERE Pcode=?;

    DELETE from Products WHERE Pcode=?;

    SELECT * FROM Products WHERE Pcategory=?

    INSERT INTO Orders VALUES(?,?,?,?,?,?);
 */

DROP TABLE IF EXISTS TBL_COMPANY;
  
CREATE TABLE TBL_COMPANY (
  company_id INT AUTO_INCREMENT  PRIMARY KEY,
  company_name VARCHAR(250) NOT NULL UNIQUE
);


DROP TABLE IF EXISTS TBL_PRODUCT;
  
CREATE TABLE TBL_PRODUCT ( 
  id INT PRIMARY KEY,
  product_id int not null,
  product_name VARCHAR(250),
  cost double,
  currency VARCHAR(3),
  company_id int 
);


 ALTER TABLE TBL_PRODUCT
    ADD FOREIGN KEY (company_id) 
    REFERENCES TBL_COMPANY(company_id)


DROP TABLE IF EXISTS TBL_SALES;
  
CREATE TABLE TBL_SALES (
  sales_id INT AUTO_INCREMENT  PRIMARY KEY,
  company VARCHAR(250),
  order_date DATE,
  order_number number,
  product_id number not null,
  quntity number,
  price double,
  currency VARCHAR(3) 
);


CREATE TABLE TBL_SALES1 AS SELECT * FROM CSVREAD('C://Users//Mahesh//Documents//creditshelf//creditshelf Backend Engineer code challenge//creditshelf Backend Engineer code challenge//files//Sales.csv');


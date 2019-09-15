create database Shopping;

use Shopping;


CREATE TABLE `shopping`.`user` (
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Firstname` VARCHAR(45) NOT NULL,
  `Lastname` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL UNIQUE,
  `Gender` VARCHAR(45) NOT NULL,
  `Dob` DATE NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Contact` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Username`));
  
DROP TABLE `shopping`.`user`;
SELECT * FROM shopping.user;
  
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('chewes0', 'Z66ETbOZ', 'Chauncey', 'Hewes', 'chewes0@instagram.com', 'Male', '1980-12-09', '83358 Nelson Lane', '227-759-9990');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('hsunman1', 'gykeI38I', 'Hugibert', 'Sunman', 'hsunman1@nature.com', 'Male', '1961-05-23', '30560 Northridge Circle', '115-731-8097');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('jbarrim2', '7PGb8A2', 'Jedediah', 'Barrim', 'jbarrim2@vkontakte.ru', 'Male', '2013-11-23', '3 Green Street', '558-371-7471');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('rsolomon3', 'dNqTYA', 'Renell', 'Solomon', 'rsolomon3@eventbrite.com', 'Female', '1979-02-18', '7 Hoffman Pass', '725-908-9435');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('wcleator4', 'SzJH8BLJpol', 'Weber', 'Cleator', 'wcleator4@who.int', 'Male', '1986-05-17', '23334 Kim Court', '746-168-2269');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('gaustins5', 'xIv20MRBYsl', 'Georas', 'Austins', 'gaustins5@whitehouse.gov', 'Male', '1971-02-21', '30 Ohio Plaza', '203-299-3371');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('blandon6', 'bKSfjgphFjYe', 'Barbi', 'Landon', 'blandon6@google.com.au', 'Female', '2006-08-10', '815 Anzinger Avenue', '484-760-8020');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('kkeavy7', '50Ns8Ix1KgS', 'Klarrisa', 'Keavy', 'kkeavy7@flickr.com', 'Female', '1988-11-25', '63 Lakewood Way', '674-124-0858');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('amarvin8', 'zuF2qBou5Fml', 'Alice', 'Marvin', 'amarvin8@mac.com', 'Female', '2003-03-20', '87675 Springview Place', '496-341-4861');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('klloyds9', 'CU1nMT', 'Katleen', 'Lloyds', 'klloyds9@gnu.org', 'Female', '2007-02-15', '3 Sachs Parkway', '432-943-0928');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('a', 'a', 'a', 'a', 'a@gnu.org', 'Female', '2007-02-15', '3 Sachs Parkway', '432-463-0928');

  
  
  
  CREATE TABLE `shopping`.`product_jacket` (
  `Jacket_id` INT NOT NULL,
  `Product_Name` VARCHAR(45) NOT NULL,
  `Product_Desc` VARCHAR(45) NOT NULL,
  `Product_Price` DOUBLE NOT NULL,
  PRIMARY KEY (`Jacket_id`));

DROP TABLE `shopping`.`product_jacket`;
SELECT * FROM shopping.product_jacket;

insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (1, 'Draw Cord Hoodie', 'draw it with style', 23.24);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (2, 'Crew Neck Jumper', 'become part of the crew', 35.23);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (3, 'Chest Print Hoodie', 'pump it', 33.00);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (4, 'Patch Down Jacket', 'cool and sleek', 41.34);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (5, 'Classic Vegan Moto Jacket', 'vintage', 500.12);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (6, 'Puma Boys Classic', 'classic all day', 61.23);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (7, 'Printed Denim Jacket', 'Replacement of Right Greater', 73.15);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (8, 'Warm Vest Jacket', 'when u are cold', 0.10);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (9, 'Pocketed Denim Jacket', ' Denim Nonautologous Tissue', 90.00);
insert into shopping.product_jacket (Jacket_id, Product_Name, Product_Desc, Product_Price) values (10, 'Hooded Outdoor Jacket', 'Bypass Superior Vena Cava', 0.59);


Create table shopping.product_shirt
(
	Shirt_Id INT,
    Product_Name VARCHAR(45),
    Product_Desc varchar(45),
    Product_Price double,
    primary key(Shirt_Id)
);

DROP TABLE product_shirt;
/**-------------Shirt Data here -----------**/
insert into shopping.product_shirt VALUES (1,'Nike Sweat','Feel like a angel when you run',35.00);
insert into shopping.product_shirt VALUES (2,'Asos Design Skinny Blazer','A blazer for skinny people',100.00);
insert into shopping.product_shirt VALUES (3,'Muscle fit shirt','For showing off muscle',11.00);
insert into shopping.product_shirt VALUES (4,'regular fit satin','A shirt with neck tie thrown in',46.00);
insert into shopping.product_shirt VALUES (5,'organic shirt crew neck','white shirt with color neck',35.00);
insert into shopping.product_shirt VALUES (6,'Black shirt crew neck','Black shirt with color neck',35.00);
insert into shopping.product_shirt VALUES (7,'Oversized sweatshirt','Comes with zip',45.00);
insert into shopping.product_shirt VALUES (8,'Knitted Muscle fit','A polo shirt that is unconfortable',33.00);
insert into shopping.product_shirt VALUES (9,'Boxy check shirt','Old school Check shirt',55.00);
insert into shopping.product_shirt VALUES (10,'Boxy check shirt pink','Pink Old school Check shirt',55.00);
/**-----------------------------------------**/


Create table shopping.product_pants
(
    Pants_Id INT,
    Product_Name VARCHAR(45),
    Product_Desc varchar(45),
    Product_Price double,
    primary key(Pants_Id)
);

DROP TABLE product_pants;
/**-------------Shirt Data here -----------**/
insert into shopping.product_pants VALUES(1,'Jeans with stretch','A jean with holes',37.00);
insert into shopping.product_pants VALUES(2,'Skinny Jean blue','A Skinny jean in blue',27.00);
insert into shopping.product_pants VALUES(3,'Super Skinny Jean','A skinny jean but worst',27.00);
insert into shopping.product_pants VALUES(4,'Tall fit jean','Comes in black',46.00);
insert into shopping.product_pants VALUES(5,'Icon Training pants','A mid length short for running',25.00);
insert into shopping.product_pants VALUES(6,'Skinny short','Comes in navy',22.00);
insert into shopping.product_pants VALUES(7,'Jersey skinny pants','comes in shorter length',55.00);
insert into shopping.product_pants VALUES(8,'adidas 3 Stripe pants','Original type',61.00);
insert into shopping.product_pants VALUES(9,'Nike Training pants','Dry 4.0 no idea.',50.00);
insert into shopping.product_pants VALUES(10,'Nike Club pants','Comes in Navy',40.00);



Create table shopping.product_shorts
(
    Shorts_Id INT,
    Product_Name VARCHAR(45),
    Product_Desc varchar(45),
    Product_Price double,
    primary key(Shorts_Id)
);
DROP TABLE product_shorts;
/**-------------Shirt Data here -----------**/
insert into shopping.product_shorts VALUES(1,'Floral Shorts','flower on shorts',23.00);
insert into shopping.product_shorts VALUES(2,'Lightweight Running shorts','fly like a bird',14.00);
insert into shopping.product_shorts VALUES(3,'Denim Shorts','What more to say',15.64);
insert into shopping.product_shorts VALUES(4,'Fly By Shorts','I dont know what it means',16.23);
insert into shopping.product_shorts VALUES(5,'Ultra High Shorts','For real',25.17);
insert into shopping.product_shorts VALUES(6,'Bondi Shorts','Bondibondibondi',22.00);
insert into shopping.product_shorts VALUES(7,'Basic Shorts','Old days',55.08);
insert into shopping.product_shorts VALUES(8,'Navy Plain Shorts','Beach type shorts',13.78);
insert into shopping.product_shorts VALUES(9,'Nike Training short','Just buy it',76.23);
insert into shopping.product_shorts VALUES(10,'Nike Club shorts','For clubbing',84.23);



Create table shopping.product_shoe
(
    Shoe_Id INT,
    Product_Name VARCHAR(45),
    Product_Desc varchar(45),
    Product_Price double,
    primary key(Shoe_Id)
);
DROP TABLE product_shoe;
/**-------------Shirt Data here -----------**/
insert into shopping.product_shoe VALUES(1,'Dr Martins','Smooth Brogue Shoe',85.12);
insert into shopping.product_shoe VALUES(2,'Mango Man','Skinny Boots',78.23);
insert into shopping.product_shoe VALUES(3,'Addidas','Superstar Original',75.76);
insert into shopping.product_shoe VALUES(4,'Keds','Champion Core',56.89);
insert into shopping.product_shoe VALUES(5,'Timberland','Ashwood park Chukka',34.30);
insert into shopping.product_shoe VALUES(6,'Vans','Comes in navy',140.00);
insert into shopping.product_shoe VALUES(7,'Aldo','Derby Shoe',88.05);
insert into shopping.product_shoe VALUES(8,'adidas 3xm','Original type',204.00);
insert into shopping.product_shoe VALUES(9,'Jack And Jones','Leather Trainers',34.45);
insert into shopping.product_shoe VALUES(10,'Nike Club Shoes','For clubbing',01.00);



CREATE TABLE `shopping`.`cart` (
  `Cart_Id` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NOT NULL,
  `Product_Name` VARCHAR(45) NOT NULL,
  `Product_Desc` VARCHAR(45) NOT NULL,
  `Product_Price` DOUBLE NOT NULL,
  `Quantity` INT NOT NULL,
  `Total_Quantity_Price` DOUBLE NOT NULL,
  PRIMARY KEY (`Cart_id`),
  CONSTRAINT `Username`
    FOREIGN KEY (`Username`)
    REFERENCES `shopping`.`user` (`Username`));

  DROP TABLE `shopping`.`Cart`;

SELECT * FROM cart;
 

SELECT sum(Product_Price) AS Payable FROM cart WHERE Username='a';



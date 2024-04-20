SELECT *
FROM employees;

SELECT EmployeeId,
       CONCAT(LastName, ' ', FirstName) FULL_NAME,
       department_name,
       City
FROM Employee as e
         INNER JOIN Department as d on e.Title = d.department_name
ORDER BY e.EmployeeId;

SELECT c.FirstName, e.FirstName
FROM Customer c
         LEFT JOIN Employee e
                   ON c.FirstName = e.FirstName;

SELECT e1.employeeNumber,
       e1.firstName,
       e1.jobTitle,
       e1.reportsTo,
       e2.firstName as boss,
       e2.jobTitle  as boss_Title
FROM employees e1
         LEFT JOIN employees e2 on e1.reportsTo = e2.employeeNumber;

SELECT COUNT(*)
FROM employees e
         JOIN offices o
              ON e.officeCode = o.officeCode;

SELECT COUNT(*)
FROM customers c
         INNER JOIN employees e
                    on c.salesRepEmployeeNumber = e.employeeNumber;

SELECT COUNT(*)
FROM customers c
         JOIN orders o
              ON c.customerNumber = o.customerNumber;

SELECT COUNT(*)
FROM orders o
         JOIN orderdetails od
              ON o.orderNumber = od.orderNumber;

SELECT COUNT(*)
FROM products
         JOIN productlines pl
              ON products.productLine = pl.productLine;

SELECT COUNT(*)
FROM customers c
         JOIN payments p
              ON c.customerNumber = p.customerNumber;

SELECT productDescription, productVendor
FROM products
WHERE productVendor like 'Shelby Cobra';


SELECT productDescription, productVendor
FROM products;

-- which product is the most and least expensive?
SELECT *
FROM products
WHERE products.buyPrice = (SELECT MIN(products.buyPrice) FROM products);

SELECT *
FROM products
ORDER BY buyPrice
LIMIT 1;

-- which product has the most quantityInStock?
SELECT *
FROM products
WHERE products.quantityInStock = (SELECT MAX(products.quantityInStock)
                                  FROM products);

SELECT *
FROM products
ORDER BY quantityInStock DESC
LIMIT 1;

-- 10.list all products that have quantity in stock less than 20
SELECT *
FROM products
WHERE products.quantityInStock < 20;

-- 11.which customer has the highest and lowest credit limit?
(SELECT *
 FROM customers
 ORDER BY creditLimit DESC
 LIMIT 1)
UNION ALL
(SELECT *
 FROM customers
 ORDER BY creditLimit
 LIMIT 1);


-- 1.how many vendors, product lines, and products exist in the database?
SELECT COUNT(DISTINCT p.productLine)   as 'Line',
       COUNT(DISTINCT p.productVendor) as 'Vendor',
       COUNT(DISTINCT p.productName)   as 'Name'
FROM products p
         LEFT JOIN productlines pl
                   on p.productLine = pl.productLine;

-- 2.what is the average price (buy price, MSRP) per vendor?
SELECT AVG(buyPrice) as 'Price',
       AVG(MSRP)     as 'MSRP'
FROM products
GROUP BY productVendor;

SELECT DISTINCT productVendor,
                (SELECT AVG(buyPrice)
                 FROM products p1
                 WHERE p1.productVendor = p.productVendor) as 'Price',
                (SELECT AVG(MSRP)
                 FROM products p2
                 WHERE p2.productVendor = p.productVendor) as 'MSRP'
FROM products p
ORDER BY productVendor;

SELECT DISTINCT productVendor,
                (SELECT AVG(buyPrice)
                 FROM products p1
                 WHERE p1.productVendor = p.productVendor) as 'Price',
                (SELECT AVG(MSRP)
                 FROM products p2
                 WHERE p2.productVendor = p.productVendor) as 'MSRP'
FROM products p;

-- 3.what is the average price (buy price, MSRP) per customer?
SELECT c.customerName,
       AVG(p.MSRP)     as 'MSRP',
       AVG(p.buyPrice) as 'buyPrice'
FROM customers c
         JOIN orders o ON c.customerNumber = o.customerNumber
         JOIN orderdetails od ON o.orderNumber = od.orderNumber
         JOIN products p ON od.productCode = p.productCode
GROUP BY c.customerName;

-- 4.what product was sold the most?
SELECT p.productName,
       SUM(od.quantityOrdered) as 'amount Ordered',
       c.customerName
FROM products p
         JOIN orderdetails od ON p.productCode = od.productCode
         JOIN orders o ON od.orderNumber = o.orderNumber
         JOIN customers c ON o.customerNumber = c.customerNumber;

SELECT p.productCode,
       p.productName,
       SUM(quantityOrdered) AS totalQuantitySold
FROM orderdetails od
         JOIN orders o ON od.orderNumber = o.orderNumber
         JOIN customers c ON o.customerNumber = c.customerNumber
         JOIN products p ON od.productCode = p.productCode
GROUP BY productCode, productName
ORDER BY totalQuantitySold DESC
LIMIT 1;

SELECT p.productCode,
       p.productName,
       SUM(od.quantityOrdered) AS totalQuantitySold
FROM orderdetails od
         JOIN orders o ON od.orderNumber = o.orderNumber
         JOIN customers c ON o.customerNumber = c.customerNumber
         JOIN products p ON od.productCode = p.productCode
GROUP BY p.productCode, p.productName
ORDER BY totalQuantitySold DESC
LIMIT 1;

-- 5.how much money was made between buyPrice and MSRP?
SELECT SUM(p.MSRP - p.buyPrice) as 'amount'
FROM products p;

SELECT TABLE_NAME, COLUMN_NAME, COLUMN_TYPE, COLUMN_KEY
FROM INFORMATION_SCHEMA.columns
WHERE TABLE_SCHEMA = 'freedb_chinook'
  and COLUMN_NAME like '%vendor%';

-- 6.which vendor sells 1966 Shelby Cobra?
SELECT productVendor, productDescription
FROM products p
WHERE p.productDescription LIKE '%Shelby Cobra%';

-- 7.which vendor sells more products?
SELECT productVendor, COUNT(*) AS totalSold
FROM products
GROUP BY productVendor
ORDER BY totalSold DESC
LIMIT 1;

-- 12.rank customers by credit limit
SELECT customerName,
       creditLimit,
       RANK() over (ORDER BY creditLimit DESC) AS 'rank'
FROM customers c;

-- 13.list the most sold product by addressBook
SELECT c.addressBook, p.productName, SUM(od.quantityOrdered) as 'totalSold'
FROM orderdetails od
         JOIN orders o ON od.orderNumber = o.orderNumber
         JOIN customers c ON o.customerNumber = c.customerNumber
         JOIN products p ON od.productCode = p.productCode
GROUP BY c.addressBook, p.productName
ORDER BY totalSold DESC;

-- 17.customers without payment
SELECT c.customerNumber, c.customerName
FROM customers c
         LEFT JOIN payments p ON c.customerNumber = p.customerNumber
WHERE p.customerNumber IS NULL;

-- 15.what is the average number of orders per customer?
SELECT COUNT(*) / COUNT(DISTINCT customerNumber)
           AS averageOrdersPerCustomer
FROM orders;


-- 20.how many orders are not shipped?
SELECT COUNT(*) AS unshippedOrders
FROM orders o
WHERE shippedDate IS NULL;

-- 21.list all employees by their (full name: first + last) in alpabetical order
SELECT e.employeeNumber, CONCAT(LastName, ' ', FirstName) FULL_NAME
FROM employees e
ORDER BY FULL_NAME;


SELECT TABLE_NAME, COLUMN_NAME, COLUMN_TYPE, COLUMN_KEY
FROM INFORMATION_SCHEMA.columns
WHERE TABLE_SCHEMA = 'freedb_chinook'
  and COLUMN_NAME like '%addressBook%';

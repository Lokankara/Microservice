-- show all customers in Australia
SELECT *
FROM customers
WHERE country LIKE 'Au%';

-- show First and Last name of customers in Melbourne
SELECT *
FROM customers
WHERE city like 'NY%';

-- show all customers with Credit Limit over $200,000
SELECT *
FROM customers
WHERE creditLimit > 200000
ORDER BY creditLimit;

-- who is the president of the company?
SELECT employeeNumber, lastName, firstName
FROM employees
WHERE jobTitle = 'President';

-- who is the VIP of the company?
SELECT *
FROM employees
WHERE jobTitle like 'VP%';

-- how many Sales Reps are in the company?
SELECT COUNT(*)
FROM employees
WHERE jobTitle = 'Sales Rep';

-- show payments in descending order
SELECT quantityOrdered, priceEach, quantityOrdered * priceEach AS total
FROM orderdetails
ORDER BY total DESC;

-- Show payments in descending order
SELECT *
FROM payments
ORDER BY paymentDate DESC;

-- What was the check# for the payment done on December 17th 2004
SELECT checkNumber, paymentDate
FROM payments
WHERE paymentDate between '2004-12-01' and '2004-12-31'
ORDER BY paymentDate DESC;

-- Show product line with the word 'realistic' in the description
SELECT productline, textDescription
FROM productlines
WHERE textDescription like '%realistic%';

-- Show product line with the word 'any ' in the description
SELECT productline, textDescription
FROM productlines
WHERE productline like '______';

SELECT productName, productDescription, productVendor
FROM products
WHERE productVendor like '%Art Galleries';

SELECT checkNumber, amount
FROM payments
ORDER BY amount DESC
LIMIT 5;

-- Show the contents of the table of performers (artists)
SELECT *
FROM Artist;

-- Show the names of customers from the city of Paris
SELECT Customer.CustomerId, FirstName, LastName, Country
FROM Customer
WHERE Customer.City = 'Paris';

-- Show sales for the year 2022, with a sales value of more than 4 dollars.
SELECT *
FROM Invoice
WHERE InvoiceDate BETWEEN '2022-01-01' AND '2022-12-31'
  AND Total > 4;

SELECT *
FROM Invoice
WHERE YEAR(InvoiceDate) > 2022
  AND Total > 4;


-- Show the date of the sale, the address of the sale, the city to which the sale was made and the purchase price of 16.86.
SELECT i.InvoiceDate    as Date_Sale,
       i.BillingAddress as Sale_Address,
       i.BillingCity    as Sale_City
FROM Invoice as i
WHERE Total = 16.86;


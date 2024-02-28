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

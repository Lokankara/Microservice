SELECT productLine,
       buyPrice,
       SUM(buyPrice)
           OVER (PARTITION BY productLine ORDER BY quantityInStock) AS sum
FROM products;

SELECT productLine, SUM(buyPrice)
FROM products
WHERE productLine = 'Classic Cars';

SELECT customers.country,
       FIRST_VALUE(creditLimit) OVER (PARTITION BY customers.country
           ORDER BY customers.country),
       LAST_VALUE(customers.creditLimit) OVER (PARTITION BY customers.country
           ORDER BY customers.country),
       AVG(customers.creditLimit) OVER (PARTITION BY customers.country)
FROM customers;

SELECT country, customers.creditLimit,
       RANK() OVER (ORDER BY customers.creditLimit DESC),
       LAG(customers.creditLimit, 1) OVER (ORDER BY customers.creditLimit DESC )
FROM customers
ORDER BY creditLimit DESC, customers.customerNumber;

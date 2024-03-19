SELECT MAX(amount), MIN(amount), AVG(amount), COUNT(*), SUM(amount)
FROM payments;

-- Show product name for vendor 'Unimax Art Galleries'
SELECT count(DISTINCT productVendor)
FROM products;

-- what is the customer number for the highest amount of payment
SELECT checkNumber, MAX(amount)
FROM payments;

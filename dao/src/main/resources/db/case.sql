SELECT productName,
       CASE
           WHEN products.productName
                    LIKE '%Ford%' OR products.productName
                    LIKE '%Harley%' THEN 'USA'
           WHEN products.productName
                    LIKE '%Suzuki%' OR productName
                    LIKE '%Ducat%'
               THEN 'Japan'
           ELSE 'other'
           END AS car_country
FROM products
ORDER BY car_country;

SELECT products.productCode,
       products.productName,
       products.buyPrice AS old_price,
       IF(products.buyPrice <= 100,
          ROUND(products.buyPrice * 1.10, 2),
          buyPrice) AS new_price
FROM products;


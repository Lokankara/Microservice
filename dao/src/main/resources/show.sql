-- Show the contents of the customer list
SELECT *
FROM Customer;

-- Show the contents of a customer list. Display Customer's Last Name, First Name, Phone Number and Email
SELECT LastName, FirstName, Phone, Email
FROM Customer;

-- Show the contents of sales. Output the date of the purchase, the city in which the sale was made, and the purchase price.
# Name the purchase price as "Amount"
SELECT InvoiceDate, BillingCity, Total AS Amount
FROM Invoice;

-- Select all music tracks with a price less than 1 dollar.
SELECT TrackId, Name, Composer, UnitPrice
FROM Track
WHERE UnitPrice < 1;

-- Select all music tracks with a price greater than 1 dollar.
SELECT TrackId, Name, UnitPrice
FROM Track
WHERE UnitPrice > 1;

-- Select all music tracks with a price not equal to $0.99 dollars.
SELECT TrackId, Name, UnitPrice
FROM Track
WHERE UnitPrice <> 0.99;

-- Show the contents of sales. Display the date of the purchase, the city in which the sale was made,
# and the purchase price greater than $10. Name the purchase price as "Total"
SELECT InvoiceDate, BillingCity, Total AS Amount
FROM Invoice
WHERE Total > 10;

-- What are the names of the sales employees in the company?
# Show last names and first names in one column named FULL_NAME.
SELECT CONCAT(LastName, ' ', FirstName) FULL_NAME
FROM Employee;

-- Display all tracks whose composers are the Red Hot Chili Peppers and Nirvana.
SELECT TrackId, Name, Composer, UnitPrice
FROM Track
WHERE Composer = 'Red Hot Chili Peppers'
   OR Composer = 'Nirvana';

-- Show all sales with a price greater than $1.98 and less than 4 dollars
SELECT InvoiceDate, BillingCity, Total AS Amount
FROM Invoice
WHERE Total > 1.98 and Total < 4;

SELECT InvoiceDate, BillingCity, Total AS Amount
FROM Invoice
WHERE Total between 1.98 and 4;

-- Show unique composers from the music tracks table
SELECT Composer, TrackId, Name, UnitPrice
FROM Track
GROUP BY Composer;

-- Show 3 composers from the music tracks table
SELECT Composer, TrackId, Name, UnitPrice
FROM Track
WHERE Composer in ('Metallica', 'AC/DC', 'Green Day');

-- Select all tracks with the word night in the title.
SELECT Name, Composer, TrackId, UnitPrice
FROM Track
WHERE Name like '%night%';

-- Retrieve all tracks whose title begins with the letter b
SELECT Name, Composer, TrackId, UnitPrice
FROM Track
WHERE Name like 'b%';

-- Get a list of tracks that contain the letter b, where the composers are Apocalyptica and Metallica.
SELECT Name, TrackId, UnitPrice
FROM Track
WHERE Name LIKE 'w%'
AND (Composer = 'Apocalyptica' OR Composer = 'Metallica');

SELECT Name, Composer, TrackId, UnitPrice
FROM Track
WHERE Name LIKE 'w%'
AND Composer IN ('Apocalyptica', 'Metallica');

SELECT Composer, COUNT(*) AS DuplicateCount
FROM Track
GROUP BY Composer
HAVING COUNT(*) > 1;

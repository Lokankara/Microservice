[deploy](https://project-ky5m.onrender.com/albums)

[![Java CI with Maven](https://github.com/Lokankara/Micronaut/actions/workflows/maven.yml/badge.svg)](https://github.com/Lokankara/Micronaut/actions/workflows/maven.yml)

### Assignments:

#### SQL:

-- Show the names of company employees hired in 2004 who reside in the town of Lethbridge
-- Show the Canadian cities to which sales were made in August 2009.
-- Show the Names of the employees hired in May. Solve in 2 ways:
    using the like operator
    using date formatting*.
-- Show the names of the employees who hold the positions of IT Staff and IT manager. 
Solve the problem in two ways: using the IN operator

Show clients with the first name Frank.
Show the name and first name of clients with the first name Mark.
Show the name and size of the tracks in Megabytes, rounded to 2 digits and sorted in descending order. Name the column MB.
Show the age of the employees, at the time of onboarding. Output last name, first name, age. date of onboarding and birthday. Name the column age.*
It will be necessary to "google" the solution to this problem on the Internet.
One of the solutions is here: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_datediff.   
Show American customers without a fax machine.
Show the mailing addresses of customers from the gmail.com domain.
Show in alphabetical order all the unique positions in the company.
Show the title of the shortest song.
Show the title and duration in seconds of the shortest song. Column name the sec.
Show the average age of the employees working in the company*.
Do some analytical work: find out the last name, first name and company of the customer (number 5). How many orders he made and for what amount. Show 2 queries of your work.
Write a query that determines the number of tracks where playlist ID > 15.
Name the columns accordingly to their location.
The result obtained should be as follows:

```
______________________
| condition | result | 
| 16        |   15   | 
| 17        |   26   | 
| 18        |   1    | 
----------------------
```

Find all invoice IDs where the number of items is greater than or equal to 6 and less than or equal to 9.

P.S. If you have time left, try to:
1) design a query job for the invoice line table so that the query contains 
   aggregation functions using grouping;
2) prepare and execute the query on the basis of item 1
3) create a query job that selects unique values from the table
4) Prepare and execute a query based on step 3
5) Show the states (counties) of countries where the number of customers is not more than 1

-- 14.customers in what city are the most profitable to the company? -- based on highest single payment
-- 16.who is the best customer? --based on single payment
-- 18.what is the average number of days between the order date and ship date?
-- 19.sales by year
-- 22.list of employees  by how much they sold in 2003?
-- 23.which city has the most number of employees?
-- 24.which office has the biggest sales?

-- Part #2  -- library_simple database
-- 1.find all information (query each table separately for book_id = 252)
-- 2.which books did Van Parks write?
-- 3.which books where published in 2003?

Show the title and duration in seconds of the shortest song by applying rounding according to the rules of mathematics. Name the column sec.
Show all invoices with a lower than average cost.
Show the invoice with a high cost.
Show the cities where both employees and customers live (use the example from lesson #4).
Show the customer's first name, last name (number 19), company, and the total amount of their orders. Name the column sum.
Show how many times the tracks of the composer of the band Queen were bought.  The number of purchases should be counted for each track. Output the name, track ID and the number of purchased tracks of the composer of the band Queen. Name the column total.
Count the number of tracks in each album. Output the album name and the number of tracks.

1. create database xxxxxx;
2. right click on that database - Table Data Import Wizard - next - next - next ...*/
     
-- ---------------------------------------------------
-- Homework #6
-- Part 1  finish queries from classicmodels db: -- 12,13,15,18,19,20,22,23,24 but we'll go over all of them
-- 1.how many vendors, product lines, and products exist in the database?
-- 2.what is the average price (buy price, MSRP) per vendor?
-- 3.what is the average price (buy price, MSRP) per customer?
-- 4.what product was sold the most?
-- 5.how much money was made between buyPrice and MSRP?
-- 6.which vendor sells 1966 Shelby Cobra?
-- 7.which vendor sells more products?
-- 8.which product is the most and least expensive?
-- 9.which product has the most quantityInStock?
-- 10.list all products that have quantity in stock less than 20
-- 11.which customer has the highest and lowest credit limit?
-- 12.rank customers by credit limit
-- 13.list the most sold product by city
-- 14.customers in what city are the most profitable to the company?
-- 15.what is the average number of orders per customer?
-- 16.who is the best customer?
-- 17.customers without payment
-- 18.what is the average number of days between the order date and ship date?
-- 19.sales by year
-- 20.how many orders are not shipped?
-- 21.list all employees by their (full name: first + last) in alpabetical order
-- 22.list of employees  by how much they sold in 2003?
-- 23.which city has the most number of employees?
-- 24.which office has the biggest sales?
-- Advanched homework: join all tables together 

/* Homework - Part #2 
Find any dataset you want to analyze (csv, xls, etc.) and import the data 
https://www.dataquest.io/blog/free-datasets-for-projects/
https://www.kaggle.com/datasets
https://catalog.data.gov/dataset
https://data.world
https://datasf.org/opendata/


/*Film Locations in San Francisco
-- import csv file Film_Locations_in_San_Francisco.csv from course meterials or from source
-- https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am

Queries:
Count distinct movies
Count of all films by release year
Count of all films by 'production company'
Count of all films directed by Woody Allen
How many movies have/don't have fun facts?
In how many movies were Keanu Reeves and Robin Williams?

Download the file 
Gather statistics about each column, such as counts, unique values, and missing values. 
-- Answer
The dataset contains 1,976 entries and 11 columns. 
Here is a summary of the non-null count for each column:
Title: 1976 non-null entries
Release Year: 1976 non-null entries
Locations: 1922 non-null entries
Fun Facts: 463 non-null entries
Production Company: 1974 non-null entries
Distributor: 1837 non-null entries
Director: 1976 non-null entries
Writer: 1971 non-null entries
Actor 1: 1972 non-null entries
Actor 2: 1883 non-null entries
Actor 3: 1504 non-null entries
*/

-- Homework - Part #3
-- ------------------- ETL (EXTRACT TRANSFORM LOAD) -------------------
-- ------------------- Loading the same .csv file via the Command-Line --------------
-- 1. Create database and table structure (with column names and datatypes) for CSV data load
-- look up the data type of existing columns if imported table exists
SELECT  column_name, column_type 
FROM INFORMATION_SCHEMA.columns
WHERE TABLE_SCHEMA = 'film';

-- create new database and empty table
DROP DATABASE IF EXISTS film2;
CREATE DATABASE film2;

-- 2. Set Client and Server ON - to Enable local data load on MySQL Client and Server
-- Instructions for Windows in file: 'ETL - Enabling local data load on MySQL Client and Server.docx'

-- 3. Import the CSV file
-- Windows - Search MySQL - In command prompt paste:

LOAD DATA LOCAL INFILE 'C:/A_A/A_Tania/SQL/Teaching SQL/film_locations_in_san_francisco.csv'
 INTO TABLE film2.film_locations_in_san_francisco
 FIELDS TERMINATED BY ',' 
 ENCLOSED BY '"' 
 LINES TERMINATED BY '\n' 
 IGNORE 1 ROWS
 (`Title`,`Release Year`,`Locations`,`Fun Facts`,`Production Company`,`Distributor`,
 `Director`,`Writer`,`Actor 1`,`Actor 2`,`Actor 3`);

-- see 1976 records loaded  
  select * from film2.film_locations_in_san_francisco;

#### Python

1. Use the PATCH method to make some changes to a previously created reservation record
2. Verify that the changes have been applied. You can also practice on the following sites:
https://jsonplaceholder.typicode.com
https://playground.learnqa.ru/api/map 

https://www.codewars.com/kata/59252121fb1f93fc8200013a/train/python
https://www.codewars.com/kata/58663693b359c4a6560001d6
https://www.codewars.com/kata/54b724efac3d5402db00065e
https://www.codewars.com/kata/58feb7ac627d2fdadf000111
https://www.codewars.com/kata/534d0a229345375d520006a0
https://www.codewars.com/kata/6071ef9cbe6ec400228d9531
https://www.codewars.com/kata/51fd6bc82bc150b28e0000ce
https://www.codewars.com/kata/599cf86d01a4108584000064
https://www.codewars.com/kata/56c30eaef85696bf35000ccf
https://www.codewars.com/kata/588453ea56daa4af920000ca
https://www.codewars.com/kata/55ee3ebff71e82a30000006a
https://www.codewars.com/kata/55b54be931e9ce28bc0000d6
https://www.codewars.com/kata/586538146b56991861000293
https://www.codewars.com/kata/52efefcbcdf57161d4000091    
https://www.codewars.com/kata/55b051fac50a3292a9000025
https://www.codewars.com/kata/56a946cd7bd95ccab2000055
https://www.codewars.com/kata/56a3f08aa9a6cc9b75000023
https://www.codewars.com/kata/567bf4f7ee34510f69000032
https://www.codewars.com/kata/55ccdf1512938ce3ac000056
https://www.codewars.com/kata/56a25ba95df27b7743000016
https://www.codewars.com/kata/58f8b35fda19c0c79400020f
https://www.codewars.com/kata/62c93765cef6f10030dfa92b
https://www.codewars.com/kata/642b375dca15841d3aaf1ede
https://www.codewars.com/kata/56d19b2ac05aed1a20000430
https://www.codewars.com/kata/586beb5ba44cfc44ed0006c3
https://www.codewars.com/kata/53d32bea2f2a21f666000256
https://www.codewars.com/kata/5966f6343c0702d1dc00004c
https://www.codewars.com/kata/559cc2d2b802a5c94700000c
https://www.codewars.com/kata/563fb342f47611dae800003c
https://www.codewars.com/kata/58f8b35fda19c0c79400020f
https://www.codewars.com/kata/580755730b5a77650500010c
https://www.codewars.com/kata/55e9529cbdc3b29d8c000016
https://www.codewars.com/kata/55968ab32cf633c3f8000008
https://www.codewars.com/kata/64c743cb0a2a00002856ff73
https://www.codewars.com/kata/5834fec22fb0ba7d080000e8
https://www.codewars.com/kata/56453a12fcee9a6c4700009c
https://www.codewars.com/kata/56fc55cd1f5a93d68a001d4e
https://www.codewars.com/kata/5862f663b4e9d6f12b00003b
https://www.codewars.com/kata/57faf7275c991027af000679
https://www.codewars.com/kata/57faf12b21c84b5ba30001b0
https://www.codewars.com/kata/56bcaedfcf6b7f2125001118
https://www.codewars.com/kata/56bc1acf66a2abc891000561
https://www.codewars.com/kata/526c7363236867513f0005ca
https://www.codewars.com/kata/53dbd5315a3c69eed20002dd
https://www.codewars.com/kata/55b051fac50a3292a9000025
https://www.codewars.com/kata/5697fb83f41965761f000052
https://www.codewars.com/kata/57ee4a67108d3fd9eb0000e7
https://www.codewars.com/kata/56069d0c4af7f633910000d3
https://www.codewars.com/kata/514a6336889283a3d2000001
https://www.codewars.com/kata/55ed875819ae85ca8b00005c
https://www.codewars.com/kata/59f70440bee845599c000085
https://www.codewars.com/kata/585d7d5adb20cf33cb000235
https://www.codewars.com/kata/585d8c8a28bc7403ea0000c3
https://www.codewars.com/kata/628df6b29070907ecb3c2d83
https://www.codewars.com/kata/5a86073fb17101e453000258
https://www.codewars.com/kata/57fafb6d2b5314c839000195
https://www.codewars.com/kata/586560a639c5ab3a260000f3
https://www.codewars.com/kata/59269e371a640c0e98000085
https://www.codewars.com/kata/590c4c342ad5cd6a8700005c
https://www.codewars.com/kata/5442e4fc7fc447653a0000d5
https://www.codewars.com/kata/58bf67eb68d8469e3c000041
https://www.codewars.com/kata/58c20c8d61aefc518f0000fd
https://www.codewars.com/kata/6344701cd748a12b99c0dbc4
https://www.codewars.com/kata/55f347cfb44b879e1e00000d
https://www.codewars.com/kata/5637b03c6be7e01d99000046
https://www.codewars.com/kata/56a24b309f3671608b00003a
https://www.codewars.com/kata/552e45cc30b0dbd01100001a
https://www.codewars.com/kata/56a24b4d9f3671584d000039
https://www.codewars.com/kata/563a8656d52a79f06c00001f
https://www.codewars.com/kata/56d31aaefd3a52902a000d66
https://www.codewars.com/kata/52fba66badcd10859f00097e
https://www.codewars.com/kata/55d410c492e6ed767000004f
https://www.codewars.com/kata/585a36b445376cbc22000072
https://www.codewars.com/kata/51f2b4448cadf20ed0000386
https://www.codewars.com/kata/55f91a98db47502cfc00001b
https://www.codewars.com/kata/62cb487e43b37a5829ab5752

	


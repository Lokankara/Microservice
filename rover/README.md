"C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\javac" -encoding UTF-8 Arithmetic.java && "C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\java" -Dfile.encoding=UTF-8 Arithmetic
"C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\javac" -encoding UTF-8 Conditions.java && "C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\java" -Dfile.encoding=UTF-8 Conditions
"C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\javac" -encoding UTF-8 Loop.java && "C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\java" -Dfile.encoding=UTF-8 Loop
"C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\javac" -encoding UTF-8 MultiDimensionalArrays.java && "C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot\bin\java" -Dfile.encoding=UTF-8 MultiDimensionalArrays

SQL:
-- Show the contents of the table of performers (artists)
-- Show the names of customers from the city of Paris
-- Show sales for the year 2012, with a sales value of more than 4 dollars.
-- Show the date of the sale, the address of the sale, the city to which the sale was made and the purchase price of 16.86. Assign names to the columns InvoiceDate - Date_Sale, BillingAddress - Sale Address, and BillingCity - Sale City.
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
______________________
| condition | result | 
| 16        |   15   | 
| 17        |   26   | 
| 18        |   1    | 
----------------------

Find all invoice IDs where the number of items is greater than or equal to 6 and less than or equal to 9.

P.S. If you have time left, try to:
1) design a query job for the invoiceline table so that the query contains aggregation functions using grouping;
2) prepare and execute the query on the basis of item 1
3) create a query job that selects unique values from the table
4) Prepare and execute a query based on step 3
5) Show the states (counties) of countries where the number of customers is not more than 1

Create 3 arrays:

- array of cat names
- array of cat color colors
- array of cat ages



Perform the tests:
2.1 If the lengths of all arrays are equal, print "Pass", otherwise print "Fail"
2.2 If box number 4 contains a ginger-colored cat with the name ginger and age 3 years, then print "Pass", otherwise print "Fail".
2.3 If there are 2 ginger cats less than 3 years old in the boxes, print "Pass", otherwise print "Fail".
2.4 If the cats in the boxes with odd indexes are not gray, print "Pass", otherwise print "Fail"
Feed the cat Carrot-top
Feed the cat in the box with index 6
Print data (name, age, color) of cats in even numbered boxes
Feed gray cats at 11am and leave a message "Cat _____ fed" where" _____" is the cat's name.
If the cat is not gray, or the time is not 11am, then leave the message "Something went wrong..."
Print the names and box numbers of all cats under 4 years old
Print the box number and the result of the "isCatBlack" check for each cat
Print the data of all cats, then swap the cats in boxes 6 and 2, and print the data of all cats again.
Count which cats are more (by color)
Sort the cats by color in the following order: ginger, gray, black.
Sort the cats in ascending order of the number of cats of the same color.
Combine the names of the cats in the even numbered boxes into one line.
Swap all the cats in mirror order (reverse)
After moving the cats, collect the names of the cats in the even numbered boxes on the same line.
If the results of 13 and 15 match, print "Fail", otherwise print "Pass"

Fruit Loops, a manufacturer of breakfast cereal, claims that a box contains at least 1500 rings and that the box contains the same number of rings of each color.
An enthusiastic amateur John counted the number of rings in one of the boxes.
If the number of rings in the box is less than claimed, and the number of rings of each color does not fall within the 5% margin of error, John can sue the company for defamation.
Run tests to see
whether the actual total number of rings matches the expected number of rings,
match the actual number of rings of each color ( +- 5% error) to the expected number of rings of each color.
Based on the test results, if suing the company is not possible, print "Pass". If it is possible to sue the company, print "Fail".
The problem should be solved through 2D array

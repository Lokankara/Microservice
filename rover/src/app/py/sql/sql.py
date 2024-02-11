import csv

csv_file = 'pg_catalog.csv'
sql_file = 'insert_data.sql'

with open(csv_file, 'r', newline='', encoding='utf-8') as csvfile:
    csv_reader = csv.DictReader(csvfile)
    
    with open(sql_file, 'w', encoding='utf-8') as sqlfile:
        
        for row in csv_reader:
            insert_statement = f'''
                INSERT INTO book (text_number, Type, Issued, Title, Language, Authors, Subjects, LoCC, Bookshelves)
                VALUES (
                    {row["Text#"]},
                    '{row["Type"]}',
                    '{row["Issued"]}',
                    '{row["Title"].replace("'", "''")}',  -- Handling single quotes in the data
                    '{row["Language"]}',
                    '{row["Authors"]}',
                    '{row["Subjects"]}',
                    '{row["LoCC"]}',
                    '{row["Bookshelves"]}'
                );
            '''
            
            sqlfile.write(insert_statement)

print(f'SQL statements have been written to {sql_file}')

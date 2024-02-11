import json
import psycopg2
from urllib.parse import urlparse

# URL of the PostgreSQL database
database_url = "postgres://admin:gaVirwBZUgu9BIsZWbcMgTZmLu2E8nY5@dpg-cmr9l9n109ks73fh0ah0-a.oregon-postgres.render.com/book_apib"

# Parse the database URL
url_parts = urlparse(database_url)
dbname = url_parts.path[1:]
user = url_parts.username
password = url_parts.password
host = url_parts.hostname
port = url_parts.port

# Connect to the PostgreSQL database
conn = psycopg2.connect(
    dbname=dbname,
    user=user,
    password=password,
    host=host,
    port=port
)

# Create a cursor
cursor = conn.cursor()

# Read JSON data
with open('gutenberg_catalog.json', 'r', encoding='utf-8') as json_file:
    json_data = json.load(json_file)

# Define the table name
table_name = 'book'

# Get maximum lengths for each column
max_lengths = {col: max(len(str(entry[col])) for entry in json_data) for col in json_data[0].keys()}

# Define the table columns and their data types
table_columns = ', '.join(['"{}" VARCHAR({})'.format(col, max_lengths[col]) for col in max_lengths])

# Create the new table
create_table_query = f'CREATE TABLE IF NOT EXISTS {table_name} ({table_columns})'
cursor.execute(create_table_query)

# Insert data into the new table using parameterized query
for entry in json_data:
    columns = ', '.join(['"{}"'.format(col) for col in entry.keys()])
    values = ', '.join(['%s' for _ in entry.values()])
    insert_query = f'INSERT INTO {table_name} ({columns}) VALUES ({values})'

    # Use parameterized query to handle special characters
    cursor.execute(insert_query, tuple(entry.values()))

# Commit the changes
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()

print(f"Data inserted into PostgreSQL table: {table_name}")

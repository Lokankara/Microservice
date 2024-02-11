from sqlalchemy import create_engine
from sqlalchemy.exc import SQLAlchemyError
import os
import re

pg_password = 'gaVirwBZUgu9BIsZWbcMgTZmLu2E8nY5'

connection_string = f"postgresql://admin:{pg_password}@oregon-postgres.render.com:5432/book_apib"

engine = create_engine(connection_string)

try:
    with open('insert_data.sql', 'r') as sql_file:

        sql_script = sql_file.read()

        sql_statements = re.split(';|\n', sql_script)

        with engine.connect() as connection:
            for statement in sql_statements:
                if statement.strip():
                    connection.execute(statement)

except SQLAlchemyError as e:

    import traceback
    print("Error executing SQL script:")
    traceback.print_exc()

finally:
    
    engine.dispose()

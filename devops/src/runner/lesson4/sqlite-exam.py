import sqlite3
conn = sqlite3.connect('collection.db')
c = conn.cursor()


c.execute('''
          CREATE TABLE testuser
          (id INTEGER PRIMARY KEY ASC,
	     name varchar(250) NOT NULL)
          ''' )
c.execute("INSERT INTO testuser VALUES(1, 'Vasya')")

conn.commit()
conn.close()

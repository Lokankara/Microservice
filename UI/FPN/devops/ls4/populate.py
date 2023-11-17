from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from database_setup import User, Base

engine = create_engine('sqlite:///Users-collection.db')
# Свяжим engine с метаданными класса Base,
# чтобы декларативы могли получить доступ через экземпляр DBSession
Base.metadata.bind = engine

DBSession = sessionmaker(bind=engine)
# Экземпляр DBSession() отвечает за все обращения к базе данных
# и представляет «промежуточную зону» для всех объектов,
# загруженных в объект сессии базы данных.
session = DBSession()

# CREATE
UserOne = User(title="Чистый Python", author="Дэн Бейде", genre="компьютерная литература")
session.add(UserOne)
session.commit()

# READ
all_Users = session.query(User).all()
first_User = session.query(User).first()

# UPDATE
editedUser = session.query(User).filter_by(id=1).one()
editedUser.author = "Testuser"
session.add(editedUser)
session.commit()

# DELETE
UserToDelete = session.query(User).filter_by(title='test').one()
session.delete(UserToDelete)
session.commit()

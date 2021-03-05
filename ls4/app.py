from flask import Flask, render_template, request, redirect, url_for
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from database_setup import Base, Users

app = Flask(__name__)

engine = create_engine('sqlite:///collection.db?check_same_thread=False')
Base.metadata.bind = engine

DBSession = sessionmaker(bind=engine)
session = DBSession()


# страница, которая будет отображать все книги в базе данных
# Эта функция работает в режиме чтения.
@app.route('/')
@app.route('/users')
def showusers():
    users = session.query(Users).all()
    return render_template("users.html", users=users)


# Эта функция позволит создать новую книгу и сохранить ее в базе данных.
@app.route('/users/new/', methods=['GET', 'POST'])
def newUser():
    if request.method == 'POST':
        newUser = User(title=request.form['name'], author=request.form['author'], genre=request.form['genre'])
        session.add(newUser)
        session.commit()
        return redirect(url_for('showusers'))
    else:
        return render_template('newUser.html')


# Эта функция позволит нам обновить книги и сохранить их в базе данных.
@app.route("/users/<int:User_id>/edit/", methods=['GET', 'POST'])
def editUser(User_id):
    editedUser = session.query(User).filter_by(id=User_id).one()
    if request.method == 'POST':
        if request.form['name']:
            editedUser.title = request.form['name']
            return redirect(url_for('showusers'))
    else:
        return render_template('editUser.html', User=editedUser)


# Эта функция для удаления книг
@app.route('/users/<int:User_id>/delete/', methods=['GET', 'POST'])
def deleteUser(User_id):
    UserToDelete = session.query(User).filter_by(id=User_id).one()
    if request.method == 'POST':
        session.delete(UserToDelete)
        session.commit()
        return redirect(url_for('showusers', User_id=User_id))
    else:
        return render_template('deleteUser.html', User=UserToDelete)


if __name__ == '__main__':
    app.debug = True
    app.run(port=4996)

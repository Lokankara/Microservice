FROM python:3.9

ENV LANG=C.UTF-8 \
    LC_ALL=C.UTF-8

RUN apt-get update && apt-get install -y ffmpeg

WORKDIR /app

COPY /rover/src/app/py/mp3/ /app

RUN pip install --no-cache-dir -r requirements.txt

COPY . .

EXPOSE 5000

CMD ["python", "app.py"]

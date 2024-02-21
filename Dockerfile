FROM python:3.9

ENV LANG=C.UTF-8 \
    LC_ALL=C.UTF-8

RUN apt-get update && apt-get install -y ffmpeg

WORKDIR /app

COPY /rover/src/app/py/mp3/ /app

RUN pip install --no-cache-dir -r requirements.txt

RUN python -m venv venv
ENV PATH="/app/venv/bin:$PATH"

RUN pip install gunicorn

COPY . .

EXPOSE 5000

CMD ["gunicorn", "-b", "0.0.0.0:5000", "app:app"]

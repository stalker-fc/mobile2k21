FROM python:3.8

WORKDIR /app

ENV LC_ALL C.UTF-8
ENV LANG C.UTF-8
ENV N_WORKERS 2

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

RUN pip check

COPY run_app.py .

COPY swagger.yaml .

COPY /app ./app

COPY /resources ./resources

ENTRYPOINT /bin/bash -c "gunicorn run_app:app --workers=${N_WORKERS} --bind 0.0.0.0:8080 --worker-class aiohttp.GunicornWebWorker --timeout 0"

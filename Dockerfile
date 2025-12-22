FROM mcr.microsoft.com/playwright/java:v1.56.0-noble
WORKDIR /app
RUN apt-get update && apt-get install -y xvfb curl && rm -rf /var/lib/apt/lists/*

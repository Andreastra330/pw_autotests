FROM mcr.microsoft.com/playwright/java:v1.56.0-noble

WORKDIR /app

RUN apt-get update && apt-get install -y xvfb && rm -rf /var/lib/apt/lists/*

CMD ["/bin/sh","-c","chmod +x ./gradlew && xvfb-run -a ./gradlew --no-daemon clean test && chmod -R a+rX build/allure-results || true"]

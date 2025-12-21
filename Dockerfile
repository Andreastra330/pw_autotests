# Официальный образ с предустановленными браузерами Playwright
FROM mcr.microsoft.com/playwright/java:v1.56.0-noble

WORKDIR /app

# ВАЖНО: запретить любые попытки скачивания браузеров
ENV PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1

# (опционально) если в проекте где-то включён download через node/install скрипты — тоже полезно
ENV CI=true

# Gradle Wrapper
COPY gradlew .
COPY gradle/wrapper/gradle-wrapper.jar gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/

# Скриптам нужен executable bit
RUN chmod +x ./gradlew

# Чтобы лучше кешировались зависимости: сначала только файлы сборки
COPY build.gradle.kts .
# если есть settings.gradle(.kts) / gradle.properties — тоже лучше скопировать сюда
COPY settings.gradle.kts* settings.gradle* gradle.properties* ./

# Кешируем зависимости (браузеры не трогаем)
RUN ./gradlew dependencies --no-daemon --quiet

# Теперь копируем весь проект
COPY . .

# Запуск тестов (браузеры уже внутри образа)
CMD ["xvfb-run","-a","-s","-screen 0 1920x1080x24","./gradlew","clean","test","--no-daemon"]
FROM openjdk:12

WORKDIR /usr/src/app

COPY . ./


CMD ["./gradlew", "run"]


FROM openjdk:12

RUN ls
RUN pwd
WORKDIR /usr/src/app
RUN pwd
COPY . /usr/src/app/
RUN pwd
RUN ls
RUN ./gradlew :distTar

RUN mv build/distributions/project-website-0.1.tar .

RUN tar -xvf project-website-0.1.tar

WORKDIR /usr/src/app/project-website-0.1

EXPOSE 8080

CMD ./bin/project-website server config.yml



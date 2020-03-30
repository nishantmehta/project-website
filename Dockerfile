FROM openjdk:12

RUN ./gradlew :distTar

RUN ls
RUN pwd

RUN mv build/distributions/project-website-0.1.tar .

RUN tar -xvf project-website-0.1.tar

WORKDIR /usr/src/app/project-website-0.1

EXPOSE 8080

CMD ./bin/project-website server config.yml



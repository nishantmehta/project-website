FROM openjdk:12

RUN ls
RUN pwd

RUN ./gradlew :distTar

RUN mv build/distributions/project-website-0.1.tar .

RUN tar -xvf project-website-0.1.tar

WORKDIR /usr/src/app/project-website-0.1

EXPOSE 8080

CMD ./bin/project-website server config.yml



FROM centos

#java
RUN curl -O https://download.java.net/java/GA/jdk12.0.1/69cfe15208a647278a19ef0990eea691/12/GPL/openjdk-12.0.1_linux-x64_bin.tar.gz
RUN tar xvf openjdk-12.0.1_linux-x64_bin.tar.gz
RUN mv jdk-12.0.1 /opt/
ENV JAVA_HOME=/opt/jdk-12.0.1
ENV PATH="$PATH:/opt/jdk-12.0.1/bin"
RUN java -version

#nodejs
RUN yum -y update; yum clean all
RUN yum -y install epel-release; yum clean all
RUN yum -y install nodejs npm; yum clean all

#haproxy
RUN yum install -y haproxy && yum clean all

#install fornt end
RUN mkdir -p /usr/src/app/frontend
COPY frontend/ /usr/src/app/frontend/
WORKDIR /usr/src/app/frontend
RUN npm install
EXPOSE 3000

WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN ./gradlew :distTar
RUN mkdir -p /usr/src/app/backend
RUN mv build/distributions/project-website-0.1.tar backend/
WORKDIR /usr/src/app/backend
RUN tar -xvf project-website-0.1.tar
EXPOSE 8080

WORKDIR /usr/src/app/
EXPOSE 80
RUN chmod +x start.sh
CMD ["./start.sh"]




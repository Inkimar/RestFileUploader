FROM tomcat:8.5-jdk8
LABEL Author <ingimar.erlingsson@nrm.se>

#Directory where the file is saved.
RUN mkdir /tmp/uploader

WORKDIR  /usr/local/tomcat/webapps
RUN curl -O -L https://archive.org/download/biouploadv03/BioUploadv03.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
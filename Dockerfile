FROM tomcat:latest

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

VOLUME /usr/local/tomcat/webapps

EXPOSE 8080

CMD ["catalina.sh", "run"]

#docker build -t <nome_immagine> .
#docker run -p 127.0.0.1:8080:8080 -v C:\Users\sgosta\IdeaProjects\Spring_Docker\app5\target:/usr/local/tomcat/webapps my-tomcat-image && start http://localhost:8080/app5/

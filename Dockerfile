FROM tomcat:9-jre17

COPY target/app5.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
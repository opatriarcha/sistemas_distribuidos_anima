FROM tomcat:9.0.62-jdk8
ADD target/jaxrswar.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
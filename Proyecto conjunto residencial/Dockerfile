FROM openjdk:8
MAINTAINER JEISON jmelovargas@uniminuto.edu.co
RUN apt-get update
RUN apt-get install unzip
RUN apt-get -y install wget
RUN wget http://download.java.net/glassfish/4.1/release/glassfish-4.1-web.zip -O ~/glassfish-4.1-web.zip
RUN unzip /root/glassfish-4.1-web.zip
RUN chown root -R glassfish4
RUN export PATH=glassfish4/bin:$PATH
EXPOSE 8080




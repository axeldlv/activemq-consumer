# ActiveMQ Consumer
Java Application to consume ActiveMQ message

Status : [![Build Status](https://travis-ci.org/axeldlv/activemqconsumer.svg?branch=master)](https://travis-ci.org/axeldlv/activemqconsumer)

- **FRONT** : REST RequestMapping
- **BACK** : Spring Boot 1.5.2, CXF 3.1.10
- **JAVA** : JDK 1.8
- **Database** : H2

If you want to use Tomcat container with activeMQ :

ActiveMQ pour Tomcat 6 (in lib folder) :
activemq-all-5.4.0.jar (version for java 1.5)
Commons-logging-1.1.jar

Download ActiveMQ on http://activemq.apache.org/

To start ActiveMQ, go to the bin folder from ActiveMQ and start the server with : activemq start

Go to the admin console : http://localhost:8161/admin

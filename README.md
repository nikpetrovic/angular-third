# my-awesome-app

This project is generated with [yo angular generator](https://github.com/yeoman/generator-angular)
version 0.11.1.

## Prerequisites

Before start building project you have to install:

- [Java](http://www.oracle.com/technetwork/java/javase/downloads)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [MongoDB](https://www.mongodb.org/downloads)
- [Node.js](https://nodejs.org/download/">)
 

## Build & development

Run `mvn package -DskipTests=true` for building in prod mode without tests or `mvn package` with MongoDB instance started with default configuration. To build in production mode ensure that you can find uncommented line in src/main/resources/application.properties:
`spring.profiles.active=prod`

To start development change this property to:
`spring.profiles.active=dev`

and run MongoDB instance with default configuration. From eclipse IDE navigate to src/main/java and run `demo.DemoApplication.java` as Java Application. This way you will start embedded Tomcat Server and be able to access the application on [localhost:8080] (http://localhost:8080).

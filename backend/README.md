Sample ToDo application.

A simple Todo list application using Spring Boot with the following options:

Spring JPA and MySQL for data persistence

In this application user can create , update and delete todos.

##Dependencies:

1) Java 8
2) Maven
3) MySql


##Configure MySQL


1) Create database schema in Mysql.
2) For tables read sqlScript file in resource folder.
3) After creating schema and tables change in application properties file as per your database configuration.


##Build and run the backend app using maven

cd TodoApp
mvn package
java -jar target/TodoApp.jar

Alternatively, you can run the app without packaging it using -
mvn spring-boot:run














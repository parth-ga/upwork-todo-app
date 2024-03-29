## Todo APP Backend
Sample ToDo application.

A simple Todo list application using Spring Boot with the following options:
Spring JPA and MySQL for data persistence
In this application user can create , update and delete todos.

## Dependencies:
1) Java 8
2) Maven
3) MySql

## Configure MySQL
1) Create database schema in Mysql.
2) For tables read sqlScript file in resource folder.
3) After creating schema and tables change in application properties file as per your database configuration.

## Build and run the backend app using maven
cd TodoApp
mvn package
java -jar target/TodoApp.jar


## TodoAppFrontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.4.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Steps :

1) First of clone this repo in your local.
2) After successfully clone, Run `npn install` command to install `node modules` and `dependencies`.
3) After successfull installation, make sure backend is hosted on some server and running up.
4) After it, you have to `copy` that hosted `URL` and `paste` it into `environments/environment.ts` and `environments/environment.prod.ts`.
5) Done.
6) Now you can run `ng serve`.
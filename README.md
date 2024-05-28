# Git Java Assignment 2
This repository is made to complete Assignment 2 Java of GIT Scholarship

## Setup
This repository contains Spring Boot Application with these specifications:
* Maven
* Java 21
* JDK 21
* PostgreSQL
The application will connect to the local database `java-2`. Change database config in `application.properties`

## Endpoint
|        Endpoint        |                                     Function                                     |
|:----------------------:|:--------------------------------------------------------------------------------:|
| GET /users             | Get all users                                                                    |
| GET /users/id          | Get one user and its address (id is set static to 1)                             |
| POST /users            | Add new user (static)                                                            |
| POST /users/id/address | Add new address by user id (user id is set to the first user with empty address) |

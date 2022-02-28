# basicFullStackApp
This app is a simple Full Stack Application that connects both Frontend and Backend along with a database locally.<br>
The backend is an API Spring Boot Application that connects to a MySQL database.<br>
The frontend is using React that makes HTTP calls to the backend app.<br>
***Work is still in progress for the frontend...***

### Requirements
* IntelliJ
* Java 11
* Apache Maven 3.8.4
* MySQL
* VSCODE
* npm
* node

# Backend App
Open the backend-app folder through Intellij<br>
Backend App is a Spring Boot application using java 11 and Apache Maven 3.8.4<br>
It is also connecting to a mysql database locally. I used this link to help me get started with this project:<br>
https://betterprogramming.pub/building-a-spring-boot-rest-api-part-iii-integrating-mysql-database-and-jpa-81391404046a

### First Create The DB Table
Open up mysql in the terminal and paste in this block of code.

    CREATE DATABASE restapi;
    USE restapi;
    CREATE TABLE blog (
        id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(500) NOT NULL,
        content VARCHAR(5000) NOT NULL
    );
    
This will create the database for you with a schema of "resetapi" and a table of "blog". <br>
Note that there will be no values in the db, so you can either add them using the mysql command or opening and connecting through MySQL Workbench. You can also just get the backend app running locally and use Postman to send requests to the api to create data.

Clone the backend app repo and run it locally.<br>
Test using postman to see if you are getting any response.<br>
Make sure that the backend is running on localhost:8080

# Frontend App
Open the frontend-app folder through VSCODE.

First install all dependencies with

    npm install

To start the web server, run

    npm start
    
This should open up a localhost:3000 port on your browser

# Expected Result
The frontend is still a work in progress so currently it is just displaying the list of blogs from your MySQL database. It should be displaying the Blog's Title on the webpage and the Blog Objects in the console. It is only calling one endpoint, which is the "/api/v2/blog" endpoint.

Make sure to have the MySQL server and backend running first before starting your frontend. You should expect to see something like this (depending if you have data in the restapi.blog db).

![Screen Shot 2022-02-05 at 2 16 06 PM](https://user-images.githubusercontent.com/54555626/152655766-85333039-1b39-4f4e-9073-f7fa4f88453b.png)

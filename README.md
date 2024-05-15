# Find-Talent Application



Find Talent is a small Spring Boot application created by Krisztina Szathmary, as a part of the interview process at codecentric AG.

The purpose of this application is to search in the database of developers at the company by programming language.


## Requirements

- Java 17
- Maven
- Docker
- Node v20.9.0


## Installation
- start docker container
   ```
   docker run --name findtalent-db -p 3306:3306 -v findtalent-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=test1234 --detach mysql:8.1.0
   ```
- connect to database and create a new schema "find_talent"
  
  ```
  username: root

  password: test1234
  ```

- create a personal access token, more instructions can be found [here](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic).

- before you start the Srping application export your newly created token as an environment variable like this:

  ```
  export GITHUB_OAUTH=<your-token>
  ``` 

  This is necessary because GitHub Api has a [rate limit](https://docs.github.com/en/rest/using-the-rest-api/rate-limits-for-the-rest-api?apiVersion=2022-11-28#primary-rate-limit-for-unauthenticated-users) of 60 requests per hour, and this 

  application starts more than 60 requests. But with the token, you can start 5000 requests per hour.



----------------------------------------------------------------------------------------------------------------------------

- you can start the Spring Boot Application in two way:
     - importing the project into IntelliJ as a Spring Boot project
     - from the command line by calling `  mvn clean package  ` followed by `  java -jar find_talent.jar  `

- importing node packages and run frontend

    ```
    npm install
    
    ng serve
     ```


----------------------------------------------------------------------------------------------------------------------------



- and now you will be able to find developers at codecentric who can work in the programming language of your choice.



----------------------------------------------------------------------------------------------------------------------------



<img width="1000" alt="find_talent_pic1" src="https://github.com/SzathmaryKriszti/find_talent/assets/131468067/ca7afd6a-e4b0-43d9-85a9-6394699cbf7d"> 



----------------------------------------------------------------------------------------------------------------------------







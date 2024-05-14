# Find-Talent Application

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

`export GITHUB_OAUTH=<your-token>` This is necessary because GitHub Api has a rate limit of 60 requests per hour, and this 

application starts more than 60 requests. But with the token, you can start 5000 requests per hour.

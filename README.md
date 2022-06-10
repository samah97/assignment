# Assignment

## About

##### This is a simple banking application which will allow creation of bank accounts with initial credit and then checking customer's balance.
##### Two seperate services have been developed, one responsible for account business and other for transactions, and according to the requirement the account service will be consuming the transaction's APIs in order create transactions.

## Notes

##### The APIs are open apis as no requirement have been added to secure the APIs, can be added later.
##### Project assignment_common is non executable but it is a common module used in both services. 

##### Use the stable branch `main`

## Used Technologies

1. Spring Boot along with spring web, jpa, test
2. Gradle
3. Swagger
4. Docker

## Running the app

##### There are two ways to run the application, legacy and containerized one.

#### Legacy

##### Running the jar found under each project located under `{projectName}/build/libs/*.jar`. Below is an example

```
java -jar java -jar account_service/build/libs/account_service-0.0.1.jar
```

##### In account_service application it is required to set the Endpoint of the transactions service, so it will be this way:

```
java -jar java -jar account_service/build/libs/account_service-0.0.1.jar -TRANSACTIONS_ENDPOINT=http://localhost:8083
```


#### Docker

##### In order to the run the application using docker, all what is supposed to be done is using docker-compose.yml file this way:

```
docker-compose up -d
```

## Testing

##### Testing the application can be done using the included postman collection's URL:

```
https://www.getpostman.com/collections/e4ad4b32047e5ffb6040
```

## Issues

#### Please create an issue or contact me if you faced any problems with the application


## Thank you

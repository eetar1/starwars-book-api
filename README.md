# Starwars Book Tracker

## Description

This application was created to track a collection of star wars books. This app enables you to see which book you have 
collected and which you still need to source. When you collect a book you can update the book's status to owned.

## Running the application

The recommended way to run the application is through intellij. This can be done by creating a run configuration with the following environmental variables.

BASIC_AUTH_USER: This is the username that will be used to authenticate restricted actions

BASIC_AUTH_PASS: This is the username that will be used to authenticate restricted actions

MONGO_URI: This is a  URI to a mongo db that will be used to store data about the collection.
This database can be initially populated using the [starwars-book-migrator](https://github.com/eetar1/Start-Wars-Book-Migrator)

If you don't want to run the application through intellij you can build and run the jar by running
```./gradlew bootJar``` and the ```java -jar build/libs/starwars-book-api-1.0.jar```. You will still need the environmental variables exported.

## Running Version

A running version of this application can be found [here](https://star-wars-book-app.herokuapp.com/). 
The application is running on free tier heroku so the application can take a minute or two to start up.

## Deploying a new version

The file ```deploy.sh``` is set up to deploy this application to heroku. To use this file you must create a heroku app
called star-wars-book-app and login to the cli. If the version of this application is changed in the gradle file then 
the deployment file must also be updated to point to the new jar.

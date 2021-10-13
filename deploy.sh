./gradlew bootjar
heroku deploy:jar build/libs/starwars-book-api-0.0.1-SNAPSHOT.jar --app star-wars-book-app

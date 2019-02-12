FROM openjdk AS BUILD_IMAGE
ENV APP_HOME=/todo_app/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY build.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY ./src  $APP_HOME/src
RUN ./gradlew build

FROM openjdk:11-jre
WORKDIR /app/
COPY --from=BUILD_IMAGE /todo_app/build/libs/todo_app.jar .
CMD ["java","-jar","todo_app.jar"]
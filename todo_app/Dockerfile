FROM openjdk:8 AS BUILD_IMAGE
ENV APP_HOME=/todo_app/
# RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY build.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle
# RUN ./gradle build
COPY . .
RUN ./gradlew build

FROM openjdk:8-jre
WORKDIR /todo_app/
COPY --from=BUILD_IMAGE /todo_app/build/libs/todo_app.jar .
EXPOSE 8080
CMD ["java","-jar","todo_app.jar"]
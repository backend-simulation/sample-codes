## Builder
FROM eclipse-temurin:17-jdk-jammy AS BUILDER

ARG APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY build.gradle.kts settings.gradle.kts gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY src $APP_HOME/src
RUN ./gradlew clean assemble --info

# Runner
FROM eclipse-temurin:17-jre-jammy AS RUNNER

ARG APP_HOME=/usr/app/
ARG ARTIFACT_NAME=plus-two-number-0.0.1-SNAPSHOT.jar
ARG APP_NAME=app.jar
RUN addgroup tester && adduser tester --ingroup tester
USER tester:tester

WORKDIR $APP_HOME

COPY --chown=tester:tester --from=BUILDER $APP_HOME/build/libs/$ARTIFACT_NAME ./app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

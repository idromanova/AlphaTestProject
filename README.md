# AlphaTestProject
## _Тестовое задание на вакансию Java Junior Developer_

##  Prerequirements
- Java 11
- Gradle 6+

## Installation and Start
1. Download project from Git.
2. Unzip downloaded archive.
3. Open command prompt and check versions of Java and Gradle:

```sh
java -version
gradle -version
```
4. Navigate to the folder with project using `cd`.
5. Run `gradle build` to build project.
6. Make sure a folder `build` has been created in the project folder.
7. Run `java -jar` to start the project:
```sh
java -jar build\libs\test-0.0.1-SNAPSHOT.jar
```

## Configuration

To configurate project open the file `src/main/resources/application.properties` in text editor.

| Property | Description | Value By Default |
| ------ | ------ | ------ |
| server.port | port that server use | 8081
| client.rate.baseUrl | url of server with rates | https://openexchangerates.org/api/
| client.rate.app_key | application key that used to access to API  | -
| client.rate.base | currency against which comparison is made | USD, another is available in enterprise account
| client.giphy.baseUrl | url of server with gifs | https://api.giphy.com/v1/gifs/
| client.giphy.app_key | application key that used to access to API  | -

## Using
1. Open your browser and type `http://localhost:8081/api/romanova/alpha/rates/amd` in the address bar. When installed correctly, a GIF will be displayed.
2. Remove `amd` and type another currency to show change in this currency compared to yesterday.

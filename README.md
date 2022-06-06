# AlphaTestProject
## _Тестовое задание на вакансию Java Junior Developer_

##  Prerequirements
- Java 11
- Gradle 6+

## Downloading
1. Download project from Git.
2. Unzip downloaded archive.

## Configuration
To configurate project open the file `/src/main/resources/application.properties` in text editor.

| Property | Description | Value By Default |
| ------ | ------ | ------ |
| server.port | port that server use | 8081
| client.rate.baseUrl | url of server with rates | https://openexchangerates.org/api/
| client.rate.app_key | application key that used to access to API  | {Your app_key}
| client.rate.base | currency against which comparison is made | USD, another is available in enterprise account
| client.giphy.baseUrl | url of server with gifs | https://api.giphy.com/v1/gifs/
| client.giphy.app_key | application key that used to access to API  | {Your app_key}

## Installation and Start
1.. Open command prompt and check versions of Java and Gradle:

```sh
C:\Users\idromanova>java -version
C:\Users\idromanova>gradle -version
```

2. Navigate to the folder with project using `cd`.
```sh
C:\Users\idromanova>cd C:\AlphaTestProject-master
```

3. Run `gradle build` to build project.
```sh
C:\AlphaTestProject-master>gradle build
```
4. Make sure a folder `build` has been created in the project folder.
5. Run `java -jar` to start the project:
```sh
C:\AlphaTestProject-master>java -jar build\libs\test-0.0.1-SNAPSHOT.jar
```

## Using
1. Open your browser and type `http://localhost:8081/api/romanova/alpha/rates/amd` in the address bar. When installed correctly, a GIF will be displayed.
2. Remove `amd` and type another currency to show change in this currency compared to yesterday.

## Docker
You can also run the project using Docker 
https://hub.docker.com/r/iromanova/alpha-test-project

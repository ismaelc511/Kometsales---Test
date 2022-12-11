# Kometsales---Test
The resolution of the test is stored in this repository

# Technical test

_This project was developed with springboot, and we tried to meet most of the requested requirements._

## To get started 🚀

To start the review it will be necessary to download the project from the repository and for this you can follow the following steps:
1. Press the green button labeled "Code"
2. Then select the Download Zip option to download. 
3. Finally unzip the file and open the folder with the preferred IDE, although it is recommended that it be Intellij IDEA


### Prerequisites 📋

To run the project you need the following technical characteristics:
1. Java 17 Oracle OpenJDK version 17.0.5
2. Modify the file named "application.properties" which contains the database url, database name, database username and password

```
EXAMPLE:

The aplication.properties could look like this:

#General

server.port=8084


#
#DATABASE
spring.datasource.url=jdbc:mysql://localhost:3306/flowerinventory?useSSL=true
spring.jpa.show-sql=true
spring.datasource.dbname=flowerinventory
spring.datasource.username=root
spring.datasource.password=Ismael08@
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```

## Run the app ⚙️

Console: mvn spring-boot:run


## Autores ✒️

* **Ismael Carvajal** - (https://github.com/ismaelc511)



---
⌨️ con ❤️ por [Ismael Carvajal](https://github.com/ismaelc511)

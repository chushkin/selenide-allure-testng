
## Selenide and Allure TestNG

### Getting Started

To run tests you need to install [maven][maven]

add your credentials in file testng.xml in the project
 - login
 - password
 - nickname
 
To generate Report you should perform following steps:

$ mvn clean test
$ mvn site


To see a report, in space your project go to folder \target\site\allure-maven-plugin\ and open by firefox index.html

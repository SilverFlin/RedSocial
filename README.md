
# RedSocial

<p align="center">
<image src="03_Implementation/views/login-register/strix.png"><br>
  RedSocial is a web application called "Strix" built with Java, HTML, CSS, JavaScript, and Love.


---

## Table contents

- [RedSocial](#redsocial)
  - [Table contents](#table-contents)
  - [Install Guide](#install-guide)
  - [Current Progress](#current-progress)
  - [What's in this repository?](#whats-in-this-repository)
    - [Requeriments](#requeriments)
    - [Design](#design)
    - [Implementation](#implementation)
  - [Authors](#authors)

---

## Install Guide

You will need [Apache Tomcat](https://tomcat.apache.org) and [JDK 17](https://www.oracle.com/java/technologies/javase/17-relnotes.html) for this project, now the java extensions that you will need are: Maven dependency plugin V2.6, Maven war plugin V3.3.2, and the Jakarta servlet V1.2.6 extension, besides, we are using [MongoBD](https://mongodb.github.io/mongo-java-driver/).


Now in NetBeans, in the "Services" section, you will need to create a new "Server" with Apache Tomcat. Just right-click on the "Servers" node and select "Add Server" to begin configuring Tomcat.

<image src="https://github.com/SilverFlin/RedSocial/assets/116768281/cefecdd2-d09e-4972-bbc3-a373070c0d0a">
  
Once you have selected "Add Server," in the tab that opens, choose "Apache Tomcat" from the options and then next.
  
![image](https://github.com/SilverFlin/RedSocial/assets/116768281/4c010a3c-ca56-4950-8e94-966d3da13c16)

After that, you need to select the path where you downloaded Apache Tomcat and enter it in the "Server Location" section. Then, add a username and password that will be prompted every time the web application starts. In this case, I will enter "admin" in both fields, and then select "Finish."


![image](https://github.com/SilverFlin/RedSocial/assets/116768281/46b3c2eb-f086-4a6c-a3e7-e99c52ea35ad)


with these steps, you would have Apache Tomcat server configured in your NetBeans.

![image](https://github.com/SilverFlin/RedSocial/assets/116768281/d77b23e3-f442-4496-8d38-9b2d64f9bed0)


</p>

## Current Progress

Check out the [Trello](https://trello.com/b/Bx6lTeoI/kanban-template) board to see the current progress of the project.

## What's in this repository?

### [Requeriments](./01_Requirements/)
This directory contains the requirements and specifications of the system.

### [Design](./02_Design/)

In this directory, you can find the software architecture and design of the system. It also includes UI/UX prototypes and related materials.

### [Implementation](./03_Implementation/)

The implementation directory contains the code implementation of the system, which is separated into different subsystems.



## Authors

This project is developed by the following contributors:

- [@MoonArt7](https://github.com/MoonArt7)
- [@GerardoZillmann](https://github.com/GerardoZillmann)
- [@LuisReynoso233531](https://github.com/LuisReynoso233531)
- [@SilverFlin](https://github.com/SilverFlin)

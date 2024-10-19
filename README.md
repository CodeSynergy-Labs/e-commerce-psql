# Cartify Application - PostgreSQL Testcontainers Integration

This repository contains a Java Spring Boot application for managing products (`ProductDao` entity) and integrates with PostgreSQL using **Testcontainers** for database testing in isolated environments. This document outlines the project setup, Testcontainers usage, and instructions for running tests.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Dependencies](#dependencies)
- [Running the Tests](#running-the-tests)
- [CRUD Operations](#crud-operations)


## Introduction

This project demonstrates the use of **Testcontainers** to run integration tests with a real PostgreSQL database in a containerized environment. By using Testcontainers, you can ensure that your tests run in a consistent and isolated environment without requiring a dedicated PostgreSQL instance.

## Prerequisites

- Java 21+
- Gradle or Maven
- Docker (Testcontainers uses Docker to run the containers)

Ensure that Docker is installed and running on your system before you proceed with running the tests.


## Dependencies

Make sure you have the following dependencies in your `build.gradle` (for Gradle) or `pom.xml` (for Maven) file.

### Gradle

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.postgresql:postgresql'
    
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.testcontainers:testcontainers:1.18.3'
    testImplementation 'org.testcontainers:postgresql:1.18.3'
}

<dependencies>
    <!-- Spring Boot and PostgreSQL dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    
    <!-- Testcontainers for PostgreSQL -->
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>testcontainers</artifactId>
        <version>1.18.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>postgresql</artifactId>
        <version>1.18.3</version>
        <scope>test</scope>
    </dependency>
</dependencies>



Running the Tests
To run the tests, use the following command:

Gradle
```
./gradlew test ```
Maven

```
mvn test ```

Ensure that Docker is running when you execute the tests, as Testcontainers requires it to start the PostgreSQL container.

CRUD Operations
The application supports basic CRUD operations for managing products. These operations are tested in the integration test class:

Create a new product.
Retrieve a product by its ID.
Update a product’s details.
Delete a product from the database


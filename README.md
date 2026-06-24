# Auth Service

A production-ready authentication and authorization microservice built with **Spring Boot 3** and **Spring Security 6**, following modern backend development practices and a feature-branch Git workflow.

## 🚀 Tech Stack

* Java 21
* Spring Boot 3
* Spring Security 6
* Gradle (Kotlin DSL)
* MySQL 8
* Docker & Docker Compose
* JWT (planned)
* Spring Data JPA
* REST APIs

## 📂 Project Structure

The project is developed incrementally using feature branches and pull requests to simulate a real-world team workflow.

```text
main
└── development
    └── feature/*
```

## 🛠️ Getting Started

### 1. Start MySQL

```bash
docker compose up -d
```

### 2. Run the application

```bash
./gradlew bootRun --args="--spring.profiles.active=local"
```

## 📌 Planned Features

* User Registration
* User Authentication
* JWT Access & Refresh Tokens
* Role-Based Authorization
* Secure Password Hashing (BCrypt)
* Global Exception Handling
* Production-Ready Configuration
* Dockerized Infrastructure

## 📈 Project Status

🚧 **Work in Progress**

Current Sprint: **Sprint 1 – Project Bootstrap & Infrastructure Setup**
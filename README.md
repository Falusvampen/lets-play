# 🌟 Let's Play CRUD API 🌟

## 📝 Table of Contents

1. [Overview](#-overview)
2. [Technologies Used](#-technologies-used)
3. [Running the project](#-running-the-project)

   3.1 [Start MongoDB Server](#mongodb-server)

   3.2 [Build and Run Project](#build-and-run-project)

4. [Usage](#-usage)
5. [Contributors](#-contributors)
6. [Endpoints 🔗](https://documenter.getpostman.com/view/28709714/2s9YJc23Pw)
7. [Graceful Shutdown](#the-application-supports-graceful-shutdown)
8. [Notes](#-notes)

## 📌 Overview

The **Let's Play CRUD API** is a Spring Boot application that demonstrates the basic CRUD (Create, Read, Update, Delete) operations using MongoDB as the database. Designed and developed by Falusvampen during their tenure at Grit:lab, dated 2023-09-26, this project aims to serve as an efficient template for CRUD-based APIs.

## 🛠 Technologies Used

- **Programming Language** : Java
- **Framework** : Spring Boot
- **Database** : MongoDB

## 📥 Running the project

### MongoDB Server

Run the following command to start your MongoDB server.

```bash
docker compose up -d
```

### Build and Run Project

Run the following command to build and run the project.

```bash
mvn spring-boot:run
```

Or `run the project from inside your IDE.`

## 🔧 Usage

To interact with the API, you may utilize either Postman or curl to send API requests. Ensure that the application is running, and direct your API calls accordingly.

## 👥 Contributors

- [**Axel Wallström**](https://github.com/Falusvampen) - _Initial work and Core Maintainer_
- [**Sagar Yadav**](https://www.github.com/sagarishere) - _Contributor_

## ☁️ [Endpoints Documentation](https://documenter.getpostman.com/view/28709714/2s9YJc23Pw) 🔗

## 【﻿⏻】 Graceful Shutdown 【﻿⏻】

#### The application supports graceful shutdown.
To gracefully shut down the application, send a `POST` request to the `/actuator/shutdown` endpoint.

Or, if you prefer `curl`:

```bash
curl -X POST http://localhost:8080/actuator/shutdown
```

Follow it by docker-compose down to stop the MongoDB server.

```bash
docker-compose down
```

## 📝 Notes

- There are no `@Field` annotations for brevity. They are optional when the field names match.

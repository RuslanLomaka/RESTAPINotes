# 📝 Notes REST API

## 📘 Project Overview

**What:**
A simple REST API for managing personal notes, now with user registration and JWT-based authentication.

**Why:**
Built as part of a learning journey to gain hands-on experience with backend development, REST principles, and working with PostgreSQL and Spring Boot. After integrating the user entity and JWT security token feature, it was a true debugging hell—but the satisfaction from success outweighed all expectations! 🚀

**Who:**
Developed by Ruslan Lomaka — Java learner exploring backend development through real projects (and plenty of Postman tears of joy).

---

> **Note:** This README is still a work in progress. Full documentation—particularly on authentication flows and environment configuration—will arrive soon.

---

## 📂 Table of Contents

1. [Features](#✨-features)
2. [API Endpoints](#📬-api-endpoints)
3. [Authentication & Postman Usage](#🔐-authentication--postman-usage)
4. [Tech Stack](#🛠-tech-stack)
5. [Deployment](#🚚-deployment)
6. [Roadmap](#🛣-roadmap)

---

## ✨ Features

* **User Management:** Register, confirm, and log in
* **JWT Security:** Protected endpoints with HMAC-SHA256 tokens
* **Notes CRUD:** Create, read, update (PUT), partial update (PATCH), and delete notes
* **DTO Validation:** Strong request/response models
* **Flyway Migrations:** Versioned DB schema
* **CI/CD Pipeline:** Automated via GitHub Actions to Raspberry Pi
* **Self-Hosted:** Runs on Raspberry Pi with Cloudflare Tunnel for HTTPS

---

## 📬 API Endpoints

### Public (no auth)

| Method | Endpoint                       | Description               |
| ------ | ------------------------------ | ------------------------- |
| POST   | `/users/register`              | Create a new user         |
| GET    | `/users/confirm?token={token}` | Confirm email address     |
| POST   | `/users/login`                 | Authenticate, receive JWT |

### Protected (bearer token required)

| Method | Endpoint      | Description             | Request Body                  |
| ------ | ------------- | ----------------------- | ----------------------------- |
| POST   | `/notes`      | Create a new note       | `{ title, content }`          |
| GET    | `/notes/{id}` | Get a note by ID        | –                             |
| GET    | `/notes`      | Get all notes           | –                             |
| PUT    | `/notes/{id}` | Replace entire note     | `{ title, content }`          |
| PATCH  | `/notes/{id}` | Partially update fields | Optional `title` or `content` |
| DELETE | `/notes/{id}` | Delete note by ID       | –                             |
| GET    | `/notes/test` | Health check (debug)    | –                             |

---

## 🔐 Authentication & Postman Usage

1. **Register** a new user via `POST /users/register` with JSON:

   ```json
   {
     "username": "johndoe",
     "password": "Secret123!"
   }
   ```
2. **Confirm** your email by visiting the link sent (or `GET /users/confirm?token=…`).
3. **Login** with `POST /users/login`:

   ```json
   {
     "username": "johndoe",
     "password": "Secret123!"
   }
   ```

   Response returns:

   ```json
   { "token": "<JWT_TOKEN_HERE>" }
   ```
4. In **Postman**, set **Authorization** ➡️ **Bearer Token** and paste your `<JWT_TOKEN_HERE>`.
5. Now call any protected endpoint (e.g. `GET /notes`) and enjoy!

> Tip: Save your JWT as an environment variable in Postman for easy reuse (e.g., `{{jwt_token}}`).

---

## 🛠 Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **Flyway** (DB migrations)
* **Lombok**, **Gradle**
* **Docker & Docker Compose**
* **GitHub Actions** CI/CD
* **Cloudflare Tunnel** *(optional for HTTPS)*

---

## 🚚 Deployment

> Deployment instructions have been moved to **[DEPLOYMENT.md](./DEPLOYMENT.md)**.

---

## 🛣 Roadmap

* [ ] Complete API documentation (OpenAPI/Swagger)
* [ ] Add user roles & permissions
* [ ] Implement password reset flows
* [ ] Frontend integration (React/Vue)
* [ ] Automated integration tests in CI

---

*Thanks for stopping by!* Feel free to raise issues or send pull requests. 😊

# 📝 Notes REST API

## 📘 Project Overview

**What:** A simple REST API for managing personal notes, now with user registration and JWT-based authentication.  
**Why:** Built as a learning journey to master backend development, REST principles, PostgreSQL, and Spring Boot—surviving a debugging hell after JWT integration to deliver a rock-solid, stateless service.  
**Who:** Developed by Ruslan Lomaka — Java learner exploring real projects (and plenty of Postman tears).

> **⚡ Documentation:** All details, request/response schemas, and try-it-out features are now live in Swagger UI:  
> 🔗 https://notes.ruslanlomaka.org/swagger-ui/index.html

---

## 📡 API Endpoints

Available endpoints (names only). Endpoints marked **(*)** require a valid JWT in the **Authorization: Bearer <token>** header.

- **Public (no auth):**
   - `users/register`
   - `users/confirm`
   - `users/login`

- **Protected (*JWT required*):**
   - `notes/create`
   - `notes/list`
   - `notes/get/{id}`
   - `notes/update/{id}`
   - `notes/partial-update/{id}`
   - `notes/delete/{id}`

We use JWT (HMAC-SHA256) for stateless, RESTful authentication—no server-side sessions, just secure, scalable token verification.

---

## 🛠 Tech Stack

- Java 17 & Spring Boot
- Spring Data JPA & PostgreSQL
- Flyway migrations
- Lombok & Gradle
- Docker & Docker Compose
- GitHub Actions CI/CD
- Cloudflare Tunnel for HTTPS (via Raspberry Pi)

---

## 🚚 Deployment

Full deployment steps will be available soon in DEPLOYMENT.md. Currently it is automatically built on GitHub Actions
and deployed to Raspberry Pi.

---

## 🛣 Roadmap

- [ ] Enhance API docs with examples
- [ ] Add user roles & permissions
- [ ] Implement password reset flows
- [ ] Frontend integration (React/Vue)
- [ ] Automated integration tests in CI

---

*Thank you for exploring the Notes REST API—happy coding!*  

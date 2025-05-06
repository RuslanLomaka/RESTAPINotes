# 📝 Notes REST API

## 📘 Project Overview

**What:**  
A simple REST API for managing personal notes. Users can create, read, update, partially update, and delete notes using HTTP requests.

**Why:**  
Built as part of a learning journey to gain hands-on experience with backend development, REST principles, and working with PostgreSQL and Spring Boot.

**Who:**  
Developed by Ruslan Lomaka — Java learner exploring backend development through real projects and Postman tears of joy.

---
## 📡 Deployment & Hosting

This project is proudly self-hosted on a Raspberry Pi 4, running 24/7 at my home.

### ⚙️ CI/CD Pipeline
- Built using **GitHub Actions**, configured with a two-step workflow:
  - `build`: compiles the app and prepares the JAR
  - `deploy`: connects to my Raspberry Pi via SSH, pulls the latest code, rebuilds Docker containers, and restarts the service
- Deployments happen automatically every time I push to the `master` branch.

### 🌐 Cloudflare Tunnel
- To make my Raspberry Pi accessible from the internet, I configured a **Cloudflare Tunnel**, providing a secure, persistent public HTTPS address:
  
  🔗 [https://notes.ruslanlomaka.org/notes/test](https://notes.ruslanlomaka.org/notes/test)

> I set this up completely from scratch, including key management, Docker networking, and GitHub secrets — just press "Push" and the app rebuilds and redeploys itself ✨

## ✨ Features

- Create new notes
- Retrieve all or single note by ID
- Update note (PUT)
- Partially update note (PATCH)
- Delete note
- Returns proper HTTP status codes and error messages
- Uses DTO for PATCH requests
- Postman collection for testing included

---

## 🛠 Tech Stack


- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Flyway** (for DB migration)
- **Lombok**
- **Gradle** (build system)
- **Docker** (containerization)
- **docker-compose** (multi-container orchestration)
- **Postman** (for API testing)
- **GitHub Actions** (for CI/CD pipeline)
- **Cloudflare Tunnel** *(for remote HTTPS access – optional, not needed for local deployment)*
---

## 📬 API Endpoints

| Method | Endpoint        | Description             | Request Body                  |
|--------|-----------------|-------------------------|-------------------------------|
| POST   | `/notes`        | Create a new note       | `title`, `content`            |
| GET    | `/notes/{id}`   | Get a note by ID        | –                             |
| GET    | `/notes`        | Get all notes           | –                             |
| PUT    | `/notes/{id}`   | Update entire note      | `title`, `content`            |
| PATCH  | `/notes/{id}`   | Partially update fields | Optional `title` or `content` |
| DELETE | `/notes/{id}`   | Delete note by ID       | –                             |

---

## 🧾 Sample JSON for Saving a Note

```json
{
  "title": "Meeting Notes",
  "content": "Discuss quarterly targets and budget."
}
```

---

## 🛢️ PostgreSQL Setup

Before running the app, make sure you have a local PostgreSQL server running.

### 🧩 Create Database and User

```sql
-- Step 1: Create the database and user (run from any DB, like 'postgres')
CREATE DATABASE notesdb;
CREATE USER notes_user WITH PASSWORD 'yourpassword';

-- Step 2: Connect to the newly created database
\c notesdb;

-- Step 3: Grant privileges inside that DB
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO notes_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO notes_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO notes_user;
```

---

## 🐳 Docker Deployment

This project includes a `Dockerfile` and a `docker-compose.yml` file for easy deployment.

### 📂 Files:
- `Dockerfile` — builds the Spring Boot application
- `docker-compose.yml` — launches the app with a PostgreSQL container

### 🚀 Run the App

```bash
# 1. Clone the repository
git clone https://github.com/RuslanLomaka/RESTAPINotes.git
cd RESTAPINotes

# 2. Build and start the containers
docker-compose up --build
```

Once the containers are up, the backend will be accessible at:  
🔗 **http://localhost:8080/notes/test**  
✅ You should see a plain `"CI/CD works"` response.

### 🛑 Stop the containers
```bash
docker-compose down
```

---

## 🧪 Postman Testing

A Postman collection is included for testing all endpoints. You can import it into Postman to explore all API routes with example requests and responses.

---

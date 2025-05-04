# 📝 Notes REST API

## 📘 Project Overview

**What:**  
A simple REST API for managing personal notes. Users can create, read, update, partially update, and delete notes using HTTP requests.

**Why:**  
Built as part of a learning journey to gain hands-on experience with backend development, REST principles, and working with PostgreSQL and Spring Boot.

**Who:**  
Developed by Ruslan Lomaka — Java learner exploring backend development through real projects and Postman tears of joy.



## ✨ Features

- Create new notes
- Retrieve all or single note by ID
- Update note (PUT)
- Partially update note (PATCH)
- Delete note
- Returns proper HTTP status codes and error messages
- Uses DTO for PATCH requests
- Postman collection for testing included



## 🛠 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Flyway** (for DB migration)
- **Lombok**
- **Postman** (for API testing)
- **Gradle**

## 📬 API Endpoints

| Method | Endpoint      | Description             | Request Body               |
|--------|---------------|-------------------------|----------------------------|
| POST   | `/notes`      | Create a new note       | `title`, `content`         |
| GET    | `/notes/{id}` | Get a note by ID        | –                          |
| GET    | `/notes`      | Get all notes           | –                          |
| PUT    | `/notes/{id}` | Update entire note      | `title`, `content`         |
| PATCH  | `/notes/{id}` | Partially update fields | Optional `title` or `content` |
| DELETE | `/notes/{id}` | Delete note by ID       | –                          |


### 🛠️ PostgreSQL Setup

Before running the app, make sure you have a local PostgreSQL server running.

#### 🧩 Create Database and User

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
## 🧪 Postman Testing

Use the following Postman collection to test the API:

📫 [Notes API Postman Collection](https://github.com/RuslanLomaka/RESTAPINotes/blob/master/Notes%20API.postman_collection.json)

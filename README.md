# 📝 Notes REST API

This is a simple RESTful API for managing notes, built with **Java**, **Spring Boot**, **PostgreSQL**, and **Flyway**.  
It supports basic CRUD operations and returns JSON responses.  
The project follows an *API-first* approach.

## ✅ Features

- Create new notes  
- Retrieve notes by ID  
- List all notes  
- Update entire notes (PUT)  
- Partially update notes (PATCH)  
- Delete notes  
- Returns proper HTTP status codes and error messages

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

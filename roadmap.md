# 🚀 Notes App Development Roadmap

This project was started with planning the REST API endpoints from the beginning.  
It was designed with clear intention to keep the architecture clean, scalable, and ready for UI integration.

---

### ✅ Completed so far

- ✅ Initialized Spring Boot project with REST API
- ✅ Planned and implemented core endpoints for `Note` entity
- ✅ Configured PostgreSQL and Flyway for database migrations
- ✅ Implemented basic CRUD for `Note`
- ✅ Tested endpoints using Postman
- ✅ Integrated Swagger UI / OpenAPI for interactive API documentation
- ✅ Added `User` entity, registration, email confirmation & JWT-based authentication
- ✅ Secured endpoints with HMAC-SHA256 JWT tokens
- ✅ Docker-ready structure for efficient Raspberry Pi deployment
- ✅ Connected Cloudflare Tunnel to host the project from a Raspberry Pi
- ✅ Made the project globally accessible via `notes.ruslanlomaka.org`
- ✅ Set up GitHub Actions CI/CD pipeline: build on push → SSH deploy to Pi → restart Docker
- ✅ Integrated Swagger/OpenAPI documentation via Swagger UI (available at `/swagger-ui/index.html`)

---

### 🟡 Currently, I am here

- 🟡 Developing Thymeleaf-based web UI integration
- 🟡 Writing integration tests and expanding CI coverage
- 🟡 Planning a homelab expansion: install Linux on an old smartphone for microservice experiments alongside the Pi

---

### ⬜ Upcoming features and improvements

- ⬜ Secure notes per user (private ownership)
- ⬜ Build full Thymeleaf UI pages: list, create, edit, delete notes
- ⬜ Add search, filters, tags for better UX
- ⬜ Implement note expiration/reminder system
- ⬜ Add note versioning and view statistics
- ⬜ Toggle public/private notes with shareable links
- ⬜ Optional: integrate AI for auto-tagging or note suggestions
- ⬜ Improve UI styling with CSS/Bootstrap
- ⬜ Expand microservice architecture using second device
- ⬜ Replace Cloudflare Tunnel with Nginx for SSL/HTTPS
- ⬜ Enforce passing tests in CI before deployment

---

🧠 *Update this roadmap regularly to track progress and stay focused.*  

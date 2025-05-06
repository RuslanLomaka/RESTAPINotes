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
- ✅ Docker-ready structure for efficient Raspberry Pi deployment
- ✅ Connected Cloudflare Tunnel to host the project from a Raspberry Pi
- ✅ Made the project globally accessible via `RuslanLomaka.org`
- ✅ Set up CI/CD pipeline via GitHub Actions:
    - ✅ On push to `master`, GitHub Actions compiles and builds the project
    - ✅ SSH connection to Raspberry Pi is established from GitHub runner
    - ✅ The new build is uploaded to Raspberry Pi and replaces the old one
    - ✅ Docker container is restarted to apply the latest version

---

### 🟡 **Currently, I am here**

- 🟡 Implementing `User` entity and authentication system
- 🟡 Preparing Thymeleaf-based UI integration
- 🟡 Laying foundation for CI with test coverage

---

### ⬜ Upcoming features and improvements

- ⬜ Add user login & registration via Thymeleaf
- ⬜ Secure notes per user (private ownership)
- ⬜ Create full Thymeleaf UI (list, create, edit, delete notes)
- ⬜ Add search, filters, and tags for better UX
- ⬜ Include note expiration/reminder system
- ⬜ Add note versioning and view statistics
- ⬜ Toggle public/private notes with shareable links
- ⬜ Optional: integrate AI for auto-tagging or note suggestions
- ⬜ Improve UI styling with CSS or Bootstrap
- ⬜ Write full test suite (unit + integration)
- ⬜ Expand CI/CD: enforce passing tests before push or deploy
- ⬜ Final deployment as a Docker container on Raspberry Pi

---

🧠 *Update this file daily to track progress and stay focused.*  
🧰 *Goal: A clean, professional-grade full-stack notes app hosted on your own hardware.*
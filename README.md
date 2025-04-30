# Spring Boot Security Basic Authentication Demo

This is a simple Spring Boot application demonstrating **Spring Security** concepts like:
- Basic Authentication
- Form-based login
- Logout handling
- Role-based access (optional)
- Public and protected endpoints

## 🛠 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Security
- Thymeleaf (for HTML login pages)
- Maven

## 📂 Project Structure

src/ ├─ main/ │ ├─ java/ │ │ └─ com.example.securitydemo/ │ │ ├─ SecurityDemoApplication.java │ │ ├─ config/SecurityConfig.java │ │ └─ controller/PageController.java │ └─ resources/ │ ├─ templates/ │ │ ├─ login.html │ │ ├─ home.html │ │ └─ hello.html │ └─ application.properties

markdown
Copy
Edit

## 🔐 Authentication Details

- **Username:** `john`
- **Password:** `password`
- (Configured via `InMemoryUserDetailsManager`)

## 🚀 Features

- ✅ Public homepage (`/`)
- ✅ Login page (`/login`)
- ✅ Secured endpoint (`/hello`)
- ✅ Logout with session invalidation
- ✅ Thymeleaf dynamic content based on login status

## 🧪 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/springboot-security-demo.git
   cd springboot-security-demo
Build and run:

bash
Copy
Edit
./mvnw spring-boot:run
Visit in browser:

Home: http://localhost:8080

Login: http://localhost:8080/login

✅ Screenshots (optional)
You can add screenshots of the login form, home page before and after login, etc.


yaml
Copy
Edit

---

Let me know if you'd like help writing unit tests or adding database-backed authentication next!

🔐 Spring Boot Password Hashing & Authentication Demo

This is a simple Spring Boot application demonstrating secure password handling using BCrypt hashing and Spring Security. It provides endpoints for user registration and login, storing users in a database with hashed passwords.

🚀 Features

✅ Register user with hashed password

✅ Authenticate login credentials using BCrypt

✅ Secure REST API with Spring Security configuration

✅ Persists user data using Spring Data JPA

✅ Auto-generated registration timestamp

🛠️ Tech Stack

Java 17+

Spring Boot

Spring Web

Spring Security

Spring Data JPA

H2 / MySQL (Configurable)

BCryptPasswordEncoder

📆 Project Structure

com.hashpassword
├── config
│   └── SecureConfig.java             # Spring Security configuration
├── controller
│   └── PasswordController.java       # REST endpoints
├── model
│   └── Users.java                    # JPA entity
├── repo
│   └── PasswordRepo.java            # Repository interface
├── service
│   └── HashPasswordService.java      # Business logic

📄 API Endpoints

➕ Register User

POST /register

Request Body (JSON):
{
  "username": "john123",
  "password": "secret123"
}

Response:
Register Successful

🔐 Login User
POST /login?username=john123&password=secret123
Response:
login Successful
or
Invalid Credentials

🧠 How It Works

When a user registers, the password is hashed using BCryptPasswordEncoder and stored in the DB.

On login, the raw password is compared with the stored hash using encoder.matches().

Passwords are never stored in plain text.

CSRF is disabled for ease of testing. (Enable in production)

🧪 Testing with Postman / curl

Register:
curl -X POST http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d '{"username":"alice", "password":"test123"}'

  Login:
  curl -X POST "http://localhost:8080/login?username=alice&password=test123"

  💡 Notes

This is a basic prototype and not production ready.

Add input validations, exception handling, and secure HTTPS in real-world apps.

You can switch from H2 to MySQL by updating application.properties.

🔧 Run Locally

Clone the repository:
git clone https://github.com/your-username/hash-password-springboot.git
cd hash-password-springboot

Run using Maven:
mvn spring-boot:run

The server will start on http://localhost:8080

🔐 Sample BCrypt Output
Input password: test123
Hashed: $2a$10$8sWYQgbS...Yw0Y9vUrwRLf72

🙌 Author
Shaik MahaboobBackend Developer | Spring Boot EnthusiastLinkedIn | GitHub | LinkedIn

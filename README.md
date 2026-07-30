# 🚀 Career Compass AI

**Career Compass AI** is an AI-powered career guidance platform that helps students and fresh graduates improve their resumes, analyze ATS scores, identify skill gaps, and receive personalized career recommendations.

The platform combines **Spring Boot**, **React**, **MySQL**, and **Google Gemini AI** to provide intelligent resume analysis and career guidance.

---

## ✨ Features

- 🔐 User Registration & Login using JWT Authentication
- 📄 Resume Upload (PDF)
- 🤖 AI-Powered Resume Analysis
- 📊 ATS Score Prediction
- 💡 Skill Gap Analysis
- 🎯 Job Recommendation
- 👤 User Profile Management
- 📚 REST APIs with Swagger Documentation

---

## 🛠️ Tech Stack

### Frontend
- React (Vite)
- Bootstrap
- Axios
- React Router

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication
- Hibernate

### Database
- MySQL

### AI
- Google Gemini AI
- Apache PDFBox

### Tools
- Git
- GitHub
- Maven
- Postman
- Swagger
- IntelliJ IDEA

---

## 📂 Project Structure

```
text
CareerCompassAI
│
├── career-compass-backend
├── career-compass-frontend
├── database
├── docs
└── README.md

```

---

## ⚙️ Installation

### Prerequisites

Before running the project, make sure you have installed:

- Java 17
- Node.js
- MySQL
- Git
- Maven

### Clone the Repository

```bash
git clone https://github.com/durga2523/CareerCompassAI.git
cd CareerCompassAI
```

### Backend Setup

```bash
cd career-compass-backend
```

Create a MySQL database:

```sql
CREATE DATABASE career_compass_ai;
```

Configure the following environment variables:

- `DB_PASSWORD`
- `JWT_SECRET`
- `GEMINI_API_KEY`

Run the backend:

```bash
mvn spring-boot:run
```

### Frontend Setup

```bash
cd career-compass-frontend
npm install
npm run dev
```

---

## 🔐 Environment Variables

Create the following environment variables before running the backend:

| Variable | Description |
|----------|-------------|
| `DB_PASSWORD` | MySQL database password |
| `JWT_SECRET` | Secret key used for JWT authentication |
| `GEMINI_API_KEY` | Google Gemini AI API key |

The project uses environment variables to keep sensitive information secure. Never commit secrets directly to the repository.

---

## 🔮 Future Enhancements

- Email notifications
- AI-based interview preparation
- Resume version history
- Multi-language support
- Admin dashboard
- Resume templates
- Company-specific ATS analysis
- Cloud deployment

---

## 👩‍💻 Author

**Durga Devi K**

- GitHub: https://github.com/durga2523
- LinkedIn: https://www.linkedin.com/in/durgadevi-kandhasamy
- Email:<durgadevi96260@gmail.com>

### 2. Clone URL

- Git clone: https://github.com/durga2523/CareerCompassAI.git
# TreackLive API 🚀

API de autenticação desenvolvida com Spring Boot, utilizando JWT para segurança e PostgreSQL como banco de dados.

## 🔧 Tecnologias
- Java 21
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Maven

## 🔐 Funcionalidades
- Cadastro de usuários
- Login com autentação JWT
- Criptografia de senha com BCrypt
- Proteção de rotas

## 📡 Endpoints

### Cadastro
POST /auth/registrar

### Login
POST /auth/login

## ▶️ Como rodar o projeto

```bash
mvn spring-boot:run
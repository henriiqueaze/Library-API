# <p align="center"> 📚 Library API

<p align="center">
  <img src="assets/images/Logo%20-%20Library-API.png" alt="StudentProgress Logo">
</p>

## 📖 Description
API to manage and organize book data, including adding, updating, retrieving, and deleting books.

## ⚙️ How to use
1. **Clone this repository and access the folder:**
    ```bash
    git clone git@github.com:henriiqueaze/Library-API.git 
    cd Library-API
    ```

2. **Set up environment variables:**
   Create a `.env` file and define your database credentials:
    ```bash
    DB_USERNAME=root
    DB_PASSWORD=yourpassword
    ```

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the project:**
    ```bash
    mvn spring-boot:run
    ```

5. **Access the project:**
   The project will be available at:
    ```bash
    http://localhost:8080/book
    ```

## 📌 Endpoints
- **GET /book/{id}** - Retrieve a book by ID.
- **GET /book** - List all books.
- **POST /book** - Add a new book.
- **PUT /book** - Update a book by ID.
- **DELETE /book/{id}** - Delete a book by ID.

## 🛠 Stack
- Java
- Spring Boot
- Hibernate
- Flyway
- MySQL
- HATEOAS

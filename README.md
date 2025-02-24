<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book API - Documentation</title>
</head>
<body>

<div class="container">
    <h1 style="text-align: center">📚 Book API</h1>
    <div class="img-container">
        <img src="assets/images/terminal.png" alt="API Livros">
    </div>
    <h2>📖 Description</h2>
    <p>API to manage and organize book data, including adding, updating, retrieving, and deleting books.</p>
    <h2>⚙️ How to use</h2>
    <ol>
        <li>
            <strong>Clone this repository and access the folder:</strong>
            <pre><code>git clone git@github.com:henriiqueaze/Library-API.git 
cd Library-API</code></pre>
        </li>
        <li>
            <strong>Set up environment variables:</strong>
            <p>Create a <code>.env</code> file and define your database credentials:</p>
            <pre><code>DB_USERNAME=root
DB_PASSWORD=yourpassword</code></pre>
        </li>
        <li>
            <strong>Build the project:</strong>
            <pre><code>mvn clean install</code></pre>
        </li>
        <li>
            <strong>Run the project:</strong>
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <li>
            <strong>Access the project:</strong>
            <p>The project will be available at:</p>
            <pre><code>http://localhost:8080/book</code></pre>
        </li>
    </ol>
    <h2>📌 Endpoints</h2>
    <ul>
        <li><strong>GET /book/{id}</strong> - Retrieve a book by ID.</li>
        <li><strong>GET /book</strong> - List all books.</li>
        <li><strong>POST /book</strong> - Add a new book.</li>
        <li><strong>PUT /book</strong> - Update a book by ID.</li>
        <li><strong>DELETE /book/{id}</strong> - Delete a book by ID.</li>
    </ul>
    <h2>🛠 Stack</h2>
    <ul>
        <li>Java</li>
        <li>Spring Boot</li>
        <li>Hibernate</li>
        <li>Flyway</li>
        <li>MySQL</li>
    </ul>
</div>

</body>
</html>

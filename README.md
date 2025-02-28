<div class="container" style="display: flex; flex-direction: column; align-items: center; text-align: center;">
    <h1>📚 Library API</h1>
    <div class="img-container" style="display: flex; justify-content: center;">
        <img src="assets/images/terminal.png" alt="API Livros" style="width: 30%;">
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
    <h2>💡 HATEOAS</h2>
    <p>This API implements HATEOAS (Hypermedia as the Engine of Application State) principles to enhance its RESTful design. Each response includes hypermedia links that help clients navigate available actions such as self, update, and delete operations. This makes the API more intuitive and self-descriptive, allowing clients to discover functionality dynamically without relying solely on external documentation.</p>
    <h2>🛠 Stack</h2>
    <ul>
        <li>Java</li>
        <li>Spring Boot</li>
        <li>Hibernate</li>
        <li>Flyway</li>
        <li>MySQL</li>
    </ul>
</div>

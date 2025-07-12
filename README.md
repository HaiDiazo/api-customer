## API Customer 
A API using Java Spring Boot to Example CRUD customer order or user. 
This api have Swagger Documentation so you can read and how to use a API for Front-end



## 📂 Endpoints

| Method | Endpoint          | Description       | Query Params     | Body (JSON)                   | Response (JSON) | Auth Required |
| ------ | ----------------- | ----------------- | ---------------- | ----------------------------- | --------------- | ------------- |
| GET    | `/api/users`      | Get list of users | `name`, `active` | –                             | `List<User>`    | Yes         |
| POST   | `/api/users`      | Create new user   | –                | `username`, `email`, `active` | Created user    | Yes         |
| GET    | `/api/users/{id}` | Get user by ID    | –                | –                             | `User`          | Yes         |
| PUT    | `/api/users/{id}` | Update user by ID | –                | `username`, `email`, `active` | Updated user    | Yes         |
| DELETE | `/api/users/{id}` | Delete user by ID | –                | –                             | Success message | Yes         |



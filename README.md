# Employee Management System (EMS) v1

A simple CRUD web service built with Java Spring Boot and MySQL serving as the database.

---

## Endpoints

### Add Employee

**Method:** `POST`  
**Endpoint:** `/api/v1/employees/employee/add`  
**Description:** Creates a record for an employee in the database.

#### Request Body

```json
{
  "firstName": "Richard",
  "lastName": "Hendricks",
  "email": "richen@email.com",
  "title": "Developer"
}
```

---

### Update Employee

**Method:** `PUT`  
**Endpoint:** `/api/v1/employees/employee/update/?employeeId={id}`  
**Description:** Updates employee data based on the employee ID passed as a query parameter.

#### Query Parameters

- `employeeId` - The ID of the employee to update.

#### Request Body

```json
{
  "firstName": "Lady",
  "lastName": "Lovelace",
  "email": "loveada@email.com",
  "title": "CTO"
}
```

---

### Delete Employee

**Method:** `DELETE`  
**Endpoint:** `/api/v1/employees/employee/delete/?employeeId={id}`  
**Description:** Permanently deletes the employee record whose ID is passed as a query parameter.

#### Query Parameters

- `employeeId` - The ID of the employee to delete.

---

## Setup and Run

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Set up MySQL:

   - Create a database named `emd`.
   - Configure your `application.properties` file with your MySQL credentials.

3. Build and run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. The application will run on [http://localhost:8081](http://localhost:8081).

---

## Technologies Used

- **Backend:** Java (Spring Boot)
- **Database:** MySQL

---

## Author

[@Adehwanr21]

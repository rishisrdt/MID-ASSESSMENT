Postman testing (step-by-step)
A) Create a Department with Employees

Request

POST http://localhost:8080/api/departments
Content-Type: application/json


Body

{
  "deptName": "Engineering",
  "employees": [
    { "empName": "Alice Singh", "empEmail": "alice@example.com" },
    { "empName": "Ravi Kumar",  "empEmail": "ravi@example.com" }
  ]
}


Expected 200 Response (example)

{
  "deptId": 1,
  "deptName": "Engineering",
  "employees": [
    {
      "empId": 1,
      "empName": "Alice Singh",
      "empEmail": "alice@example.com",
      "latestDeptId": 1,
      "latestDeptName": "Engineering"
    },
    {
      "empId": 2,
      "empName": "Ravi Kumar",
      "empEmail": "ravi@example.com",
      "latestDeptId": 1,
      "latestDeptName": "Engineering"
    }
  ]
}

B) Get all employees currently under a department

Request

GET http://localhost:8080/api/departments/1/employees


Response

[
  {
    "empId": 1,
    "empName": "Alice Singh",
    "empEmail": "alice@example.com",
    "latestDeptId": 1,
    "latestDeptName": "Engineering"
  },
  {
    "empId": 2,
    "empName": "Ravi Kumar",
    "empEmail": "ravi@example.com",
    "latestDeptId": 1,
    "latestDeptName": "Engineering"
  }
]

C) Change the department of an employee

First create another department:

POST http://localhost:8080/api/departments
Content-Type: application/json


Body

{ "deptName": "HR", "employees": [] }


Now move employee empId = 2 (Ravi) from Engineering → HR:

PUT http://localhost:8080/api/employees/2/department
Content-Type: application/json


Body

{ "departmentId": 2 }


Response

{ "message": "Department changed successfully" }

D) Verify latest department for employee
GET http://localhost:8080/api/employees/2/department/latest


Response

{
  "empId": 2,
  "empName": "Ravi Kumar",
  "empEmail": "ravi@example.com",
  "latestDeptId": 2,
  "latestDeptName": "HR"
}

E) Verify current employees in Engineering after move
GET http://localhost:8080/api/departments/1/employees


Response

[
  {
    "empId": 1,
    "empName": "Alice Singh",
    "empEmail": "alice@example.com",
    "latestDeptId": 1,
    "latestDeptName": "Engineering"
  }
]

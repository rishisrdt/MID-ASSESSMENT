Method: POST
URL: http://localhost:8080/departments

{
  "deptName": "IT Department",
  "employees": [
    {
      "empName": "Ravi Kumar",
      "empEmail": "ravi.kumar@example.com"
    },
    {
      "empName": "Anita Sharma",
      "empEmail": "anita.sharma@example.com"
    }
  ]
}



Method: GET
URL: http://localhost:8080/employees/department/1

[
  {
    "empId": 1,
    "empName": "Ravi Kumar",
    "empEmail": "ravi.kumar@example.com",
    "assignedDate": "2025-08-23T16:00:00",
    "department": {
      "deptId": 1,
      "deptName": "IT Department"
    }
  },
  {
    "empId": 2,
    "empName": "Anita Sharma",
    "empEmail": "anita.sharma@example.com",
    "assignedDate": "2025-08-23T16:00:00",
    "department": {
      "deptId": 1,
      "deptName": "IT Department"
    }
  }
]


Method: PUT
URL: http://localhost:8080/employees/2/department/2


{
  "empId": 2,
  "empName": "Anita Sharma",
  "empEmail": "anita.sharma@example.com",
  "assignedDate": "2025-08-23T16:10:00",
  "department": {
    "deptId": 2,
    "deptName": "HR Department"
  }
}


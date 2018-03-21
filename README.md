# gl-dept
Grocery list, department service

## Build with Docker

`docker build . --build-arg version=0.0.1-SNAPSHOT -t gl-dept:latest`

# API

| URL                      | Method | Description                     |
| ------------------------ | ------ | --------------------------------|
| /api/dept/               |GET     | Gets all departments            |
| /api/dept/{departmentId} |GET     | Gets a single department by id  |
| /api/dept/               |POST    | Adds a new department           |
| /api/dept/{departmentId} |PUT     | Updates a department            |
| /api/dept/{departmentId} |DELETE  | Deletes a department            |
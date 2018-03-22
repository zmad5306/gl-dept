# gl-dept
Grocery list, department service

## Build with Docker

`gradlew build`

`docker build . --build-arg version=0.0.1-SNAPSHOT -t zmad5306/gl-dept:latest`

`docker push zmad5306/gl-dept:latest`

# API

| URL                      | Method | Description                     |
| ------------------------ | ------ | --------------------------------|
| /api/dept/               |GET     | Gets all departments            |
| /api/dept/{departmentId} |GET     | Gets a single department by id  |
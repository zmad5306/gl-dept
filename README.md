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

## GET /api/dept/

### Sample response

```json
[
    {
        "departmentId": "5ab4cf0b52faff0001f95039",
        "name": "Frozen",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/dept/5ab4cf0b52faff0001f95039",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            }
        ]
    },
    {
        "departmentId": "5ab4cf0b52faff0001f9503a",
        "name": "Dairy",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/dept/5ab4cf0b52faff0001f9503a",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            }
        ]
    },
    {
        "departmentId": "5ab4cf0b52faff0001f9503b",
        "name": "Bread",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/dept/5ab4cf0b52faff0001f9503b",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            }
        ]
    },
    {
        "departmentId": "5ab4cf0b52faff0001f9503c",
        "name": "Canned",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/dept/5ab4cf0b52faff0001f9503c",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            }
        ]
    }
]
```

## GET /api/dept/{departmentId}

### Sample response

```json
{
    "departmentId": "5ab4cf0b52faff0001f95039",
    "name": "Frozen",
    "_links": {
        "self": {
            "href": "http://minikube:31726/api/dept/5ab4cf0b52faff0001f95039"
        }
    }
}
```
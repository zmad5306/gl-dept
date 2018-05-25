# gl-dept
Grocery list, department service

## Build with Docker

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

## Continious Integration Builds

### GitHub Integration

#### Storage Bucket

A storage bucket is required to store an encrypted GitHub OAuth authenticaion token. This is utilzed by the builds to authenticate to GitHub to push changes, create branches and create pull requests. The name of the storage bucket is passed to the builds as Substitution Variables (see _GIT_HUB_KEY_BUCKET_NAME below).

#### Cryptographic Keys

In the Google Cloud Platform Console there must be a Cryptographic Key-Ring and Key created. The name of the key-ring and key are passed to the builds (see _KMS_KEY and _KMS_KEYRING below).

In addition to creating the keys a GitHub access token must be encrypted in a hub.enc and uploaded to the storage bucked created above.

Create a `hub` file in the following format:

```yaml
github.com:
  - protocol: https
    user: ${GITHUB_USERNAME}
    oauth_token: <git hub token here>
```

See Creating a personal access token for the command line for more details: https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/

Once the `hub` file is created it needs encrypted using the gcloud API:

`gcloud kms encrypt --location=global --keyring=gl-keyring --key=gl --plaintext-file=hub --ciphertext-file=hub.enc`

Then finally, the hub.enc needs uploaded to the storage bucked created above.

### Staging

**Name:** Department Micro-Service Staging CI Build

**Trigger type:** Branch

**Branch (regex):** ^develop$

**Build configration:** cloudbuild.yaml

**cloudbuild.yaml location:** /staging/cloudbuild.yaml

#### Staging Substitution variables

| Variable                    | Value               |
| --------------------------- | -----               |
| _CLOUDSDK_COMPUTE_ZONE      | us-central1-f       |
| _CLOUDSDK_CONTAINER_CLUSTER | staging             |
| _KMS_KEY                    | gl                  |
| _KMS_KEYRING                | gl-keyring          |
| _PROJECT_ID                 | grocery-list-205220 |
| _GIT_HUB_KEY_BUCKET_NAME    | gl-git-hub-key      |

### QA

**Name:** Department Micro-Service QA CI Build

**Trigger type:** Tag

**Tag (regex):** .*

**Build configration:** cloudbuild.yaml

**cloudbuild.yaml location:** /qa/cloudbuild.yaml

#### QA Substitution variables

| Variable                    | Value               |
| --------------------------- | -----               |
| _CLOUDSDK_COMPUTE_ZONE      | us-central1-f       |
| _CLOUDSDK_CONTAINER_CLUSTER | qa                  |
| _KMS_KEY                    | gl                  |
| _KMS_KEYRING                | gl-keyring          |
| _PROJECT_ID                 | grocery-list-205220 |
| _GIT_HUB_KEY_BUCKET_NAME    | gl-git-hub-key      |
# DYNAMODB-SPRINGDATA-EXAMPLE

> Development in progress

### Description

Examples of integration between DynamoDB and Spring Data:
* Entities mapping;
* Hash and sort keys;
* Searching with filters;
* Searching with paging;
* Secondary Global Index.

#### Install requirements

- Docker >= 19
- AWS CLI >= 2

#### Configure a AWS local profile credential

Add the following code to your `~/.aws/credentials` file:

```bash

[local]
aws_access_key_id = localAccessKey
aws_secret_access_key = secretAccessKey

```  

#### Run a local DynamoDB instance

To download a DynamoDB image and run it locally:

```bash

docker pull amazon/dynamodb-local
docker run -p 8000:8000 amazon/dynamodb-local

```

#### Run

This will run the script to create the database objects in your local instance of DynamoDB:

```bash

./dynamodb/local.sh

```
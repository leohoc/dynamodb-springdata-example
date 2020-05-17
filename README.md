# DYNAMODB-SPRINGDATA-EXAMPLE

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

### To run using a local instance of DynamoDB

#### #1 Configure a AWS local profile credential

Add the following code to your `~/.aws/credentials` file:

```bash

[local]
aws_access_key_id = localAccessKey
aws_secret_access_key = secretAccessKey

```  

#### #2 Run a local DynamoDB instance

To download a DynamoDB image and run it locally:

```bash

docker pull amazon/dynamodb-local
docker run -p 8000:8000 amazon/dynamodb-local

```

#### #3 Create tables in the local DynamoDB

This will run the script to create the database objects in your local instance of DynamoDB:

```bash

git clone https://github.com/leohoc/dynamodb-springdata-example
cd dynamodb-springdata-example/
./dynamodb/local.sh

```

#### #4 Running the application

```bash

./gradlew clean build test
java -jar build/libs/*.jar

```

Wait for the starting process, then navigate to `http://localhost:8080/swagger-ui.html` to access the API documentation

Hit Ctrl+C in the terminal to shutdown.

### To run using an AWS hosted instance of DynamoDB

#### #1 Configure an AWS homolog profile credential

Add the following code to your `~/.aws/credentials` file:

```bash

[homolog]
aws_access_key_id = <your-account-access-key>
aws_secret_access_key = <your-account-secret-access-key>

```  

#### #2 Create tables in your AWS account

This will run the script to create the database objects in your AWS account:

```bash

git clone https://github.com/leohoc/dynamodb-springdata-example
cd dynamodb-springdata-example/
./dynamodb/homolog.sh

```

#### #3 Running the application

```bash

./gradlew clean build test
java -jar -Dspring.profiles.active=homolog build/libs/*.jar

```

Wait for the starting process, then navigate to `http://localhost:8080/swagger-ui.html` to access the API documentation

Hit Ctrl+C in the terminal to shutdown.
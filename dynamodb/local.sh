aws dynamodb create-table --profile local --region us-west-2 \
  --cli-input-json file://dynamodb/musicTable.json \
  --endpoint-url http://localhost:8000
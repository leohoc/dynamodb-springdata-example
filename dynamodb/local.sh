aws dynamodb create-table --profile local --region us-west-2 \
  --cli-input-json file://dynamodb/music-table.json \
  --endpoint-url http://localhost:8000

aws dynamodb create-table --profile local --region us-west-2 \
  --cli-input-json file://dynamodb/improved-music-table.json \
  --endpoint-url http://localhost:8000
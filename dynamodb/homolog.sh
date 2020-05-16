aws dynamodb create-table --profile homolog --region us-east-1 \
  --cli-input-json file://dynamodb/music-table.json

aws dynamodb create-table --profile homolog --region us-east-1 \
  --cli-input-json file://dynamodb/improved-music-table.json

aws dynamodb create-table --profile homolog --region us-east-1 \
  --cli-input-json file://dynamodb/much-improved-music-table.json
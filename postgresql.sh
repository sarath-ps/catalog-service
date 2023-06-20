docker run  --name catalog-db \
  --rm \
  --net catalog-network \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -e POSTGRES_DB=catalog_db \
  -p 5432:5432 \
  postgres:14.4


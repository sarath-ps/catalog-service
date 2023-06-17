docker run  --name catalog-app \
  --rm \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -e POSTGRES_DB=catalog_app \
  -p 5432:5432 \
  postgres:14.4


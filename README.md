# catalog-api
Catalog API

## How to run locally

Run postgresql

```
docker-compose up
```

Run the app

```
./mvnw spring-boot:run
```

## Open API Doc

* [Swagger UI](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/spring-socks/catalog-api/main/src/main/resources/static/openapi/doc.yml)
* [ReDoc](https://redocly.github.io/redoc/?url=https://raw.githubusercontent.com/spring-socks/catalog-api/main/src/main/resources/static/openapi/doc.yml)

## Deploy to Tanzu Application Platform

> ℹ️ `basic` or `testing` ootb supply chain is expected to be installed.

```
NAMESPACE=...
kubectl create ns ${NAMESPACE} --dry-run=client -oyaml | kubectl apply -f-
kubectl apply -f postgresql.yaml -n ${NAMESPACE}
kubectl wait --for=condition=Available=true deploy/catalog-db -n ${NAMESPACE}
kubectl apply -f pipeline.yaml -n ${NAMESPACE}
kubectl apply -f workload.yaml -n ${NAMESPACE}
# show logs
stern -n ${NAMESPACE} catalog-api
```

Ignore `catalog-api-00001-deployment-****` as the first revision is not bound to the database.
From `catalog-api-00002-deployment-****`, it should work and  `catalog-api-00003-deployment-****` will be created after about 10 min. That's the last revision of your first deployment.
# RetailRESTfulService

Pre-Requisites:
Should have a instance of mongodb running.

Steps:
1. Clone the repo.
2. Change the application.properties inside ~/RetailRESTfulService/retail/src/main/resources to listen to a running instance of mongodb.
3. Use an IDE of choice, and start the application.
4. Use a API testing tool like postman or curl to test the service.
5. Endpoint exposed is /products/{productId}.

Example:

To GET a product with productId "13860428"

curl -X GET \
  http://localhost:9800/products/13860428 \
  -H 'Postman-Token: b45a37d3-b07b-4fbc-b704-97bbe6f845c7' \
  -H 'cache-control: no-cache'

To add a product:

curl -X POST \
  http://localhost:9800/products/1234 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 0ed6da87-88f2-4a2b-8089-e5fd95029ada' \
  -H 'cache-control: no-cache' \
  -d '{
	"id": "1234",
	"name": "Test",
	"current_price": {
		"value": 20,
		"currency_code": "Rs"
	}
}'


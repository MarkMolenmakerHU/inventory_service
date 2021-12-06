Inventory Service

Get all Items Request:
GET -> /inventory

Get a single Item by ID Request:
GET -> /inventory/{id}

Get a list of Items by ProductName Request:
GET -> /inventory?productName={name}

Register a new Item Request:
POST -> /inventory
```json
{
  "productName": "Salami Slice",
  "unit": "GRAMS",
  "capacity": 3000,
  "purchaseCapacity": 1000,
  "sellCapacity": 25,
  "purchasePrice": 1.50,
  "sellPrice": 10
}
```

- Update the stock of an Item
- Sell an Item
- Buy new stock of an Item
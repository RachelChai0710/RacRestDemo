# RacRestDemo
This project is a spring boot application with REST API.
Integrated with [FakeStoreAPI](https://github.com/keikaavousi/fake-store-api).
Postman Collection to test: [Postman Collection](https://github.com/RachelChai0710/RacRestDemo/blob/main/Rac%20Rest%20Demo.postman_collection.json)

## Resource
There are 2 main resources in this project:
- http://localhost:8080/cus
- http://localhost:8080/prd

## All available routes
GET:
- cus/getAll (Get All Customers)
- cus/get/{id} (Get Customer by ID)
- prd/getNAddAllPrd (Get Products from 3rd Party API and Store to Database)
- prd/getAllPrd/{pageNo} (Get All Product from Database with Pagination)

PUT:
- cus/upd/{id} (Update Customer Details by ID)

POST:
- cus/add (Add New Customer)
Request Body for Add and Update Customer:
```
{
    "name": "Test",
    "age": 24,
    "address":{
        "adrLine1":"25, Jalan Test 17",
        "adrLine2":"Taman Test",
        "postcode": "68100",
        "state": "Selangor",
        "country":"Malaysia"
    }
}
```

DELETE:
- cus/delete/{id} (Delete Customer by ID)
  

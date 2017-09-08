# REST API

two RESTful resources:

## Products
implement two methods:

- list product catalog
- read a single product by its id
			
## Orders
	
implement four methods:
		
- place an order
- modify an existing order
- list placed orders
- read an existing order by its id
	
for product related to queries: 
1. showing all the products:
	http://localhost:8080/products/
	this will display all the products available in the DB
2. finding a product by id:
	http://localhost:8080/products/1
	by requesting this url you will get the info related to the first product in the DB

for Order related queries:
1. showing all available orders
	http://localhost:8080/orders
	this will display all the available orders in the DB
2. add new orderitem/ add(same as updating) more to the quantity of the orderitem:
	http://localhost:8080/placeorder/iphone
	this will add iphone to the order item if iphone already exist in the orderitem it will add to 
	the quantity of it

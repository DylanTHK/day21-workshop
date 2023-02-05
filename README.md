# day21-workshop
use JDBCTemplate to query a MySQL database (northwind)

FLOW
1. Controller calls methods from NorthRepo
2. NorthRepo execute queries with JdbcTemplate
3. NorthRepo generates objects with Order and Customer models
4. object returned to Controller
5. Controller builds and returns json to user via Postman

AVAILABLE QUERIES
1. GET /api/customers
2. GET /api/customers?limit=<default=5>&offset=<default=0>
3. GET /api/customer/<customer_id>
4. GET /api/customer/<customer_id>/orders
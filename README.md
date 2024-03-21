This is a Spring Boot microservice responsible for user management.

Following CRUD operations are supported:
1. Register User
2. Get user details with the help of userid
3. Update user details
4. Delate user

REST APIs are exposed for these CRUD operations, having following endpoints:
1. Register -> /register/user   (@RequestBody User)
2. Get User -> /user/{userId}  (@RequestBod UserId)
3. Update User -> /update/user/{userId} (@RequestBody updatedUserDetails)
4. Delete User -> /delete/user/{userId} (@RequestBody UserId)

User Management service save user data in mysql 8.3.0 server. 
After doing each operation , its information and timestamp is put on Kafka (3.7.0) queue and that message is consumed by Journal Management application.


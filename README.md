User Management Appliocation

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

CURL commands:

REGISTER USER :   
curl -X POST http://localhost:8090/register/user -H "Content-Type: application/json" -d "{\"userName\":\"user1\",\"password\":\"pwd\"}"

UPDATE USER
curl -X PUT http://localhost:8090/update/user/1 -H "Content-Type: application/json" -d "{\"userName\":\"user2",\"password\":\"pwd\"}"

GET USER : 
curl http://localhost:8090/user/1

DELETE USER :
curl -X DELETE http://localhost:8090/delete/user/1



User Management service save user data in mysql 8.3.0 server. 
After doing each operation , its information and timestamp is put on Kafka (3.7.0) queue and that message is consumed by Journal Management application.

Spring JPA is used for object relational model mapping.

app_user
Id  userName  password  contactNumber  roleName  address  email

username is Unoique and UserId is a generated SEQUENCE

Service is dockerised and can docker-compose.yaml is attached to run all the components together.




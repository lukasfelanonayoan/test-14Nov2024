# Project
Java Spring Boot + MongoDB

# Database Properties
Connect to MongoAtlas Online : mongodb+srv://lukas:Test1234@cluster0.nat67.mongodb.net/

# How To Test
Perlu ditambahkan Header pada semua request API saat ini. (Ada keamanan Autentikasi)
## Header
1. X-API-KEY : Baeldung

# Documentation API

## Create (http://localhost:8080/user-api/create) => POST
### Request Body
{
  "name":"Lukas Felano Nayoan",
	"password":"test1234"
}

## Read (http://localhost:8080/user-api/detail/{id}) => GET

## Read All (http://localhost:8080/user-api/list) => GET

## Update (http://localhost:8080/user-api/edit/{id}) => POST
### Request Body
{
  "name":"Lukas Felano Nayoan",
	"password":"test1234"
}

## Delete (http://localhost:8080/user-api/delete/{id}) => GET

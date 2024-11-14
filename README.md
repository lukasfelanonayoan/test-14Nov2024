# Project
Java Spring Boot + MongoDB

untuk code nya udah termasuk CRUD untuk 1 table.
belum ada keamanan seperti data existing atau nama yang sama.
untuk Authentication sudah coba ditambahkan namun untuk setting nya ada kesalahan jadi semua API harus pakai authentication. (Kasih "X-API-KEY : Baeldung" pada header)
untuk unit test tidak saya terapkan.

# Database Properties
Connect to MongoAtlas Online : mongodb+srv://lukas:Test1234@cluster0.nat67.mongodb.net/

# How To Test
Perlu ditambahkan Header pada semua request API saat ini. (Ada keamanan Autentikasi)
## Header (Authentication)
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

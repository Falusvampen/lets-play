start the mongodb server with `mongod`

if mongodb is via brew installation, a recommended way is:

```bash
  brew services start mongodb-community@7.0
```

test the applciation with

```bash
  mvn spring-boot:run
```

you may stop the mongodb server with `mongod --shutdown`

if mongodb is via brew installation, a recommended way is:

```bash
  brew services stop mongodb-community@7.0
```

regarding 403 errors, this is in the spring main documentation.

There are several factors that can trigger a 403 error in a Spring Boot application. One of them is when the client fails to provide the authentication credentials. In such cases, the server, unable to verify the client’s privileges, rejects the request, resulting in a 403 error.

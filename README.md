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

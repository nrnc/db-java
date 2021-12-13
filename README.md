# Basic JAVA CRUD project using Pippo framework

Running the application

`mvn compile exec:java `<br>

curl commands for testing

`curl http://localhost:8338/movies/7 -H 'Content-Type: application/json' -X GET` <br>
`curl http://localhost:8338/movies/1 -H 'Content-Type: application/json' -X DELETE` <br>
`curl http://localhost:8338/movies -d '{"title":"Sarapatta","description":"A very good movie"}'  -H 'Content-Type: application/json'` <br>

`curl http://localhost:8338/movies/7 -d '{"title":"Sarapatta","description":"A very bad movie"}'  -H 'Content-Type: application/json' -X PUT` <br>
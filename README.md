
//Rodar axonserver
docker run --name axonserver -p 8024:8024 -p 8124:8124 -v "/Users/vinicio/dev/personal/docker-data/data":/data -v "/Users/vinicio/dev/personal/docker-data/eventdata":/eventdata -v "/Users/vinicio/dev/personal/docker-data/config":/config axoniq/axonserver

//Dash Axon
http://localhost:8024/#query

//Dash H2 DB
http://localhost:8082/products-service/h2-console

//Eureka
http://localhost:8761/
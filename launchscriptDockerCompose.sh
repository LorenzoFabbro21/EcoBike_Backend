cd api-gateway
./mvnw -DskipTests=true clean package
docker build -t api-gateway .

cd ../user-service
./mvnw -DskipTests=true clean package
docker build -t user-service .

cd ../negozio-service
./mvnw -DskipTests=true clean package
docker build -t negozio-service .

cd ../recensione-service
./mvnw -DskipTests=true clean package
docker build -t recensione-service .

cd ../service-discovery-server
./mvnw -DskipTests=true clean package
docker build -t service-discovery-server .
cd ..

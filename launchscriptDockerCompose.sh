cd api-gateway
./mvnw  clean package
docker build -t api-gateway .

cd ../user-service
./mvnw  clean package
docker build -t user-service .

cd ../negozio-service
./mvnw  clean package
docker build -t negozio-service .

cd ../recensione-service
./mvnw  clean package
docker build -t recensione-service .

cd ../service-discovery-server
./mvnw  clean package
docker build -t service-discovery-server .
cd ..

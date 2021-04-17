
docker build ./server -t cloudappsteam/server:1.0
docker push cloudappsteam/server:1.0

pack build cloudappsteam/weatherservice:1.0 --path ./weatherservice --builder gcr.io/buildpacks/builder:v1
docker push cloudappsteam/weatherservice:1.0

docker build ./planner -t cloudappsteam/planner:1.0
docker push cloudappsteam/planner:1.0

cd toposervice
mvn clean
mvn compile jib:build -Dimage=cloudappsteam/toposervice:1.0
cd ..
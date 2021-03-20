
docker build ./server -t cristoflop/server:latest
docker push cristoflop/server:latest

pack build cristoflop/weatherservice:latest --path ./weatherservice --builder gcr.io/buildpacks/builder:v1
docker push cristoflop/weatherservice:latest

docker build ./planner -t cristoflop/planner:latest
docker push cristoflop/planner:latest

cd toposervice
mvn clean
mvn compile jib:build -Dimage=cristoflop/toposervice:latest
cd ..
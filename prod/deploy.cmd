:: PRIMERO ES NECESARIO TENER CONFIGURADO EL OKTETO-CONFIG PARA QUE SE PUBLIQUEN LOS SERVICIOS EN LA WEB DE OKTETO CLOUD

kubectl delete --all services
kubectl delete --all deployments

kubectl apply -f broker-deployment.yaml
kubectl apply -f sqldb-deployment.yaml
kubectl apply -f nosqldb-deployment.yaml
kubectl apply -f topo-deployment.yaml
kubectl apply -f weather-deployment.yaml
kubectl apply -f planner-deployment.yaml
kubectl apply -f server-deployment.yaml

kubectl apply -f broker-service.yaml
kubectl apply -f sqldb-service.yaml
kubectl apply -f nosqldb-service.yaml
kubectl apply -f topo-service.yaml
kubectl apply -f weather-service.yaml
kubectl apply -f planner-service.yaml
kubectl apply -f server-service.yaml

kubectl delete -f ingress.yaml
kubectl apply -f ingress.yaml
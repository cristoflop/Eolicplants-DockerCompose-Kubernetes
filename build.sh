#!/bin/sh

DOCKERHUB_NAME=cloudappsteam

option=$1

if [ "$option" = "push" ]; then
  build=true
  push=true
else
  build=true
  push=false
fi

if [ $build = true ]; then
  echo "-------------------"
  echo "Building server..."
  echo "-------------------"
  docker build ./server -t "$DOCKERHUB_NAME/server":1.0
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing server..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/server":1.0
fi

if [ $build = true ]; then
  echo "-------------------"
  echo "Building weatherservice..."
  echo "-------------------"
  pack build "$DOCKERHUB_NAME/weatherservice":1.0 --path ./weatherservice --builder gcr.io/buildpacks/builder:v1
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing weatherservice..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/weatherservice":1.0
fi

if [ $build = true ]; then
  echo "-------------------"
  echo "Building planner..."
  echo "-------------------"
  docker build ./planner -t "$DOCKERHUB_NAME/planner":1.0
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing planner..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/planner":1.0
fi

if [ $build = true ] && [ $push = true ]; then
  echo "-------------------"
  echo "Building and pushing toposervice..."
  echo "-------------------"
  cd toposervice || exit
  mvn compile jib:build -Dimage="$DOCKERHUB_NAME/toposervice":1.0
  cd ..
fi
if [ $build = true ] && [ $push = false ]; then
  echo "-------------------"
  echo "Building toposervice..."
  echo "-------------------"
  cd toposervice || exit
  mvn compile jib:dockerBuild -Dimage="$DOCKERHUB_NAME/toposervice":1.0
  cd ..
fi


export POD_NAME=$(kubectl get pods --namespace default -l "app.kubernetes.io/name=eolicplants,app.kubernetes.io/instance=eolicplants-release" -o jsonpath="{.items[0].metadata.name}")
  export CONTAINER_PORT=$(kubectl get pod --namespace default $POD_NAME -o jsonpath="{.spec.containers[0].ports[0].containerPort}")
  echo "Visit http://127.0.0.1:8080 to use your application"
  kubectl --namespace default port-forward $POD_NAME 8080:$CONTAINER_PORT
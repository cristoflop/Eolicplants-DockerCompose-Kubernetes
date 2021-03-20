#!/bin/sh

DOCKERHUB_NAME=cristoflop

echo "Choose one option: "
echo "1.- Build and push"
echo "2.- Only build"
read -r option

if [ "$option" -eq "1" ]; then
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
  docker build ./server -t "$DOCKERHUB_NAME/server":latest
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing server..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/server":latest
fi

if [ $build = true ]; then
  echo "-------------------"
  echo "Building weatherservice..."
  echo "-------------------"
  pack build "$DOCKERHUB_NAME/weatherservice":latest --path ./weatherservice --builder gcr.io/buildpacks/builder:v1
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing weatherservice..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/weatherservice":latest
fi

if [ $build = true ]; then
  echo "-------------------"
  echo "Building planner..."
  echo "-------------------"
  docker build ./planner -t "$DOCKERHUB_NAME/planner":latest
fi
if [ $push = true ]; then
  echo "-------------------"
  echo "Pushing planner..."
  echo "-------------------"
  docker push "$DOCKERHUB_NAME/planner":latest
fi

if [ $build = true ] && [ $push = true ]; then
  echo "-------------------"
  echo "Building and pushing toposervice..."
  echo "-------------------"
  cd toposervice || exit
  mvn compile jib:build -Dimage="$DOCKERHUB_NAME/toposervice":latest
  cd ..
fi
if [ $build = true ] && [ $push = false ]; then
  echo "-------------------"
  echo "Building toposervice..."
  echo "-------------------"
  cd toposervice || exit
  mvn compile jib:dockerBuild -Dimage="$DOCKERHUB_NAME/toposervice":latest
  cd ..
fi

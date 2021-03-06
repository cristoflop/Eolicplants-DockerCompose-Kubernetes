#!/bin/sh

CONTEXT=docker-desktop
KUBECONFIG=$HOME/Downloads/okteto-kube.config:${KUBECONFIG:-$HOME/.kube/config}

if [ "$1" = "-h" ] || [ "$1" = "--help" ]; then
  echo "Usage:"
  echo "arg[0] => output directory of generated manifests (otherwise files will be deleted)"
  exit 0
fi

export KUBECONFIG

BK_CONTEXT=$(kubectl config current-context)

kubectl config use-context $CONTEXT

if [ "$1" = "" ]; then
  kompose convert -o .manifests.yaml
else
  mkdir "$1"
  kompose convert -o "$1"
fi

kubectl delete --all services
kubectl delete --all deployments

if [ "$1" = "" ]; then
  kubectl apply -f .manifests.yaml
else
  kubectl apply -f "$1"
fi

if [ "$1" = "" ]; then
  rm .manifests.yaml
fi

kubectl config use-context "$BK_CONTEXT"

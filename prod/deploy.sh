#!/bin/sh
export KUBECONFIG=$HOME/Downloads/okteto-kube.config:${KUBECONFIG:-$HOME/.kube/config}
kompose convert
kubectl delete --all services
kubectl delete --all deployments
for file in *.yaml
do
   kubectl apply -f "$file"
done
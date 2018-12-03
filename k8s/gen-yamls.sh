#!/bin/sh

generate() {
  name=$1
  service_type=$2
  target_port=$3

  kubectl run "${name}" --dry-run \
    --image=gcr.io/chanseok-playground-new/"${name}" --port="${target_port}" \
    -o yaml > "${name}".yaml

  kubectl expose -f "${name}".yaml --dry-run \
    --name="${name}" --port=80 --target-port="${target_port}" \
    --type="${service_type}" \
    -o yaml > service.yaml

  echo "---" >> "${name}".yaml
  cat service.yaml >> "${name}".yaml
  rm service.yaml
}

generate java-frontend LoadBalancer 8080
generate groovy-backend ClusterIP 8086
generate nodejs-backend ClusterIP 3000

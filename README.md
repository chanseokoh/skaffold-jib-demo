# skaffold-jib-demo

### Node.js Backend
Returns "Greetings from Node.js!"

Uses Dockerfile.
```
nodejs-backend/
├── Dockerfile
├── index.js
└── package.json
```

### Groovy Backend
Returns "Greetings from Groovy!"

Uses Micronaut framework + Gradle + Jib.
```
groovy-backend/
├── build.gradle
└── src/main/
    └── groovy/backend/
        ├── Application.groovy
        └── WebController.groovy
```

### Java Frontend
Accesses the two backends

Uses Spark web framework + Maven + Jib.
```
java-frontend/
├── pom.xml
└── src/main
    ├── java/frontend/Frontend.java
    └── resources/static/index.html
```

### Kubernetes YAML Files (Deployments and Services)
```
k8s/
├── nodejs-backend.yaml
├── groovy-backend.yaml
└── java-frontend.yaml
```

### Skaffold Config
```
skaffold.yaml
```

### Dev Workflow without Skaffold + Jib

1. Change source files
1. Rebuild the project
1. Build a Docker container locally
   - You need Dockerfile
   - You need Docker installed locally
1. Run the container locally
1. Push the built container to a regstiry
1. Deploy the container to the dev Kubernetes cluster
1. Set up port forwarding
1. Access `http://localhost:<port>`

### Dev Workflow with Jib but without Skaffold

1. Change source files
1. Rebuild the project
1. Deploy the built container to the dev Kubernetes cluster
1. Set up port forwarding
1. Access `http://localhost:<port>`

### Dev Workflow with Skaffold + Jib

1. Change source files
1. Access `http://localhost:<port>`

No need to use `kubectl`.

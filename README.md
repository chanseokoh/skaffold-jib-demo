# skaffold-jib-demo

### Node.js backend
Returns "Greetings from Node.js!"

Dockerfile
```
nodejs-backend/
├── Dockerfile
├── index.js
└── package.json
```

### Groovy backend
Returns "Greetings from Groovy!"

Micronaut framework + Gradle + Jib
```
groovy-backend/
├── build.gradle
└── src/main/
    └── groovy/backend/
        ├── Application.groovy
        └── WebController.groovy
```

### Java frontend
Spark web framework + Maven + Jib
```
java-frontend/
├── pom.xml
└── src/main
    ├── java/frontend/Frontend.java
    └── resources/static/index.html
```

### Kubernetes YAML files (deployments and services)
```
k8s/
├── nodejs-backend.yaml
├── groovy-backend.yaml
└── java-frontend.yaml
```

### Skaffold config
```
skaffold.yaml
```

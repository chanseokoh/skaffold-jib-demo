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

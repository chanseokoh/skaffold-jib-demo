# skaffold-jib-demo

### [Skaffold](https://github.com/GoogleContainerTools/skaffold)?

A command line tool that facilitates continuous development for Kubernetes applications.

### [Jib](https://github.com/GoogleContainerTools/jib)?

Maven and Gradle plugins to build container images for your Java applications.

### Kubernetes Dev Workflow without Skaffold + Jib

1. Change source files
1. Rebuild the project
1. Build a Docker container locally
   - You need Dockerfile
   - You need Docker installed locally
1. Run the container locally
1. Push the built container to a remote container registry
1. Deploy the container to the dev Kubernetes cluster
1. Set up port forwarding
1. Access `http://localhost:<port>`

### Dev Workflow with Jib

1. Change source files
1. Rebuild the project. These steps are now gone:
   1. ~~Build a Docker container locally~~
      - ~~You need Dockerfile~~
      - ~~You need Docker installed locally~~
   1. ~~Run the container locally~~
   1. ~~Push the built container to a remote container registry~~
1. Deploy the built container to the dev Kubernetes cluster
1. Set up port forwarding
1. Access `http://localhost:<port>`

- Setting up Jib for Gradle:
```diff
 plugins {
   id 'io.spring.dependency-management' version '1.0.6.RELEASE'
   id 'com.github.johnrengelman.shadow' version '4.0.0'
+  id 'com.google.cloud.tools.jib' version '0.10.0'
 }
 ```

- Setting up Jib for Maven:
```diff
     <plugins>
+      <plugin>
+        <groupId>com.google.cloud.tools</groupId>
+        <artifactId>jib-maven-plugin</artifactId>
+        <version>0.10.0</version>
+      </plugin>
     </plugins>
```

### Dev Workflow with Skaffold + Jib

1. Change source files
1. Access `http://localhost:<port>`

No need to use `kubectl`.

- Setting up Skaffold for the whole project:
```yaml
apiVersion: skaffold/v1beta1
kind: Config
build:
  artifacts:
  - image: gcr.io/chanseok-playground-new/java-frontend
    jibMaven: {}
    context: java-frontend
  - image: gcr.io/chanseok-playground-new/groovy-backend
    jibGradle: {}
    context: groovy-backend
  - image: gcr.io/chanseok-playground-new/nodejs-backend
    context: nodejs-backend
    sync:
      '*.js': .
```

### Demo App Structure

Mono repo with 3 microservices written in different languages and frameworks.

#### Node.js Backend
Returns "Greetings from Node.js!"

Uses Dockerfile.
```
nodejs-backend/
├── Dockerfile
├── index.js
└── package.json
```

#### Groovy Backend
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

#### Java Frontend
Accesses the two backends.

Uses Spark web framework + Maven + Jib.
```
java-frontend/
├── pom.xml
└── src/main
    ├── java/frontend/Frontend.java
    └── resources/static/index.html
```

#### Kubernetes YAML Files (Deployments and Services)

The usual YAML files you will have for Kubernetes deployement:
```
k8s/
├── nodejs-backend.yaml
├── groovy-backend.yaml
└── java-frontend.yaml
```

#### Skaffold Config
```
skaffold.yaml
```

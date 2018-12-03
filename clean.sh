#!/bin/sh

(cd java-frontend && ./mvnw clean)
(cd groovy-backend && ./gradlew clean)

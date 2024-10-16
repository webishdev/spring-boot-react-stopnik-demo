# Demo of: STOPnik + Spring Boot + React

This demo is related to https://stopnik.webish.dev/

This repository contains three folders

- `authorization-server` with a given **STOPnik** configuration for this demo
- `server` which implements a Spring Boot server using **STOPnik** as resource server (Java)
- `client` which implements a React Client using **STOPnik** (TypeScript)

## General usage

1. Start Authorization server
2. Start Spring Boot server
3. Start React client

## Authorization server

### Prerequisites

- Docker

### Usage

Start **STOPnik** with Docker

`docker run --rm -p 8082:8080 -v ${PWD}/config.yml:/config.yml -v ${PWD}/ecdsa521key.pem:/ecdsa521key.pem ghcr.io/webishdev/stopnik:latest`

or use the provided `start-docker.sh`

### Configuration

Two users exists
-  `foo`, with password `bar`, which is an normal user
-  `bar`, with password `foo`, which is an Admin user and can access the Admin endpoint

## Spring Boot server

### Prerequisites

- Java 21

### Usage

The Spring Boot server provides a simple Hello World API endpoint and an additional Admin endpoint, both are protected and only differ by the allowed role.

With a valid Bearer token in HTTP Authorization header the following endpoints can be accessed with GET

- http://localhost:8080/
- http://localhost:8080/admin

A simple GET request within a Browser will not allow to access that endpoints, because of missing Bearer token.

During testing a Bearer token can be acquired with tools like Postman.

The Spring Boot server can be started with the provided Maven wrapper.

`./mvnw spring-boot:run`

### Configuration

The Spring Boot server is configured to use an authorization server located at http://localhost:8082, and will check for a `roles` claim to map it into `GrantedAuthority` objects.


## React client

Not available right now
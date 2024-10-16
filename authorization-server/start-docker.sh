#!/bin/bash

docker run --rm -p 8082:8080 -v ${PWD}/config.yml:/config.yml -v ${PWD}/ecdsa521key.pem:/ecdsa521key.pem ghcr.io/webishdev/stopnik:latest
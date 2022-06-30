#!/usr/bin/env bash
docker build -t cr-backend .
docker build -t cr-frontend -f ./angularclient/Dockerfile ./angularclient

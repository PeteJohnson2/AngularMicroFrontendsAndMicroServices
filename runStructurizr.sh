#!/bin/sh
docker pull structurizr/lite
docker run -it --rm -p 8080:8080 -v ~/git/AngularPortfolioMgr/structurizr:/usr/local/structurizr structurizr/lite
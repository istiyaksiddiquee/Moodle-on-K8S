# Magnum Opus

[![Build Status](https://circleci.com/gh/istiyaksiddiquee/MagumOpus.svg?style=svg)](https://circleci.com/gh/istiyaksiddiquee/MagumOpus)
![stability-stable](https://img.shields.io/badge/stability-stable-green.svg)
![version](https://img.shields.io/badge/release-0.1.0-orange)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

** still under construction **

Magnum Opus is my "Magnum Opus". It is a project that demonstrates my experience and expertise on all the tech-stacks that I claim to know or to have worked with. So, the idea of the project is very simple. It's a simple Moodle replica, that my university uses for maintaining it's online presence among students. 

The whole project is designed using microservice architecture. REST, gRPC, GraphQL all three concepts were used in the backend and corresponding frontend were created to interface with them. A "no button click policy" was adapted to deploy the whole project to digital ocean meaning that to deploy the whole system, only a single sh command is required. It will then spin up the required resources on Digital Ocean, deploy Kubernetes, get and build the code, and deploy required services on Kubernetes cluster. And during this whole time, no button click is necessary.

Front-End:
- Two front-ends technologies were used in this project. One was built on Angular 9, another on React.

Back-End:
- BackEnd was built using five different frameworks
Spring REST
NodeJS (NestJS) - REST, gRPC, GraphQL
Python Django - REST

Database:
- Both relational (PostgreSQL) and non-relational DB (MongoDB) was used.

Testing
- The project was done using TDD (Test Driven Development) approach. Corresponding frameworks were used for unit and integration testing.

Logging
- Centralized logging provided by ELK was used to aggregate and monitor the log. FileBeat was used to get the logs from different services.

DevOps
- Jenkins Pipeline API was used to create a CI/CD pipeline to drive the whole project.

Deployment
- Kubernetes was used to deploy the whole project. Helm charts were developed to package it.

Monitoring
- Istio was used to monitor and regulate the traffic flow.

Infrastructure
- Terraform was used to spin up three droplets and a load balancer in DigitalOcean. Ansible was used to deploy a three-node Kubernetes cluster on these nodes. NagiOS was used to monitor the resources created by Terraform.

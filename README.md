# Moodle on K8S

[![Build Status](https://circleci.com/gh/istiyaksiddiquee/MagumOpus.svg?style=svg)](https://circleci.com/gh/istiyaksiddiquee/MagumOpus)
![stability-stable](https://img.shields.io/badge/stability-stable-green.svg)
![version](https://img.shields.io/badge/release-0.1.0-orange)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

** still under construction **

Moodle on K8S is a project that demonstrates my experience and expertise on all the tech-stacks that I claim to know or to have worked with. So, the idea of the project is very simple. It's a simple Moodle replica, that my university uses for maintaining it's online presence among students. 

Updates (so far): 
* BackEnd Microservices - Spring, NestJs, Go Gin-Gonic, Django 
* FrontEnd Microservices - Not implemented yet
* DB instances - PostgreSQL, MySQL, (Redis, MongoDB -> yet to be configured) 
* CI - Jenkins, CircleCI (configured for spring app)
* Jenkins - Pipeline As Code, extended base Jenkins image and implemented Infrastructure as Code
* Kubernetes - Dockerized and created Helm charts for everything 
* Istio - monitoring and controlling using Istio (Kiali, Grafana, Prometheus) implemented  
* Log Aggregation - ELK with Filebeat 
* Deployment Environment - local, cloud not configured yet
* Load Testing - Gatling scripts are added.


The whole project is designed using microservice architecture. REST, gRPC, GraphQL all three concepts were used in the backend and corresponding frontend were created to interface with them. A "no button click policy" was adapted to deploy the whole project to digital ocean meaning that to deploy the whole system, only a single sh command is required. It will then spin up the required resources on Digital Ocean, deploy Kubernetes, get and build the code, and deploy required services on Kubernetes cluster. And during this whole time, no button click is necessary.

Front-End:
- This project has two front-ends technologies. One is Angular 9, another is React.

Back-End:
- BackEnd has different frameworks
Spring REST
NodeJS (NestJS) - REST, gRPC, GraphQL
Python Django - REST
Golang Gin-Gonic - REST

Database:
- Both relational (PostgreSQL, MySQL) and non-relational DB (MongoDB) used. Also, a Key-Value store (Redis) is used here.

Testing
- Done using TDD (Test Driven Development) approach. Corresponding frameworks are used for unit and integration testing.

Logging
- Centralized logging provided by ELK is used to aggregate and monitor the log. FileBeat is used to get the logs from different services.

DevOps
- Jenkins Pipeline API is used to create a CI/CD pipeline to drive the whole project.

Deployment
- Used Kubernetes to deploy the whole project. Helm charts were developed for packaging. Helmfile (by rollboll) is used to drive Helm.

Monitoring
- Istio is used to monitor and regulate the traffic flow.

Infrastructure
- Terraform is used to spin up three droplets and a load balancer in DigitalOcean. Ansible is used to deploy a three-node Kubernetes cluster on these nodes. NagiOS is used to monitor the resources created by Terraform.

Load Testing
- Used Gatling scripts for load testing.

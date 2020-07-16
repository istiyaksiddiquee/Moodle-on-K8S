FROM jenkins/jenkins:lts

LABEL maintainer="Istiyak Siddiquee"

USER root

ARG JAVA_OPTS

ENV JENKINS_HOME /var/jenkins_home
ENV JAVA_OPTS "-Djenkins.install.runSetupWizard=false ${JAVA_OPTS:-}"

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common maven nodejs python3

COPY settings.xml ~/.m2

RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -

RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"

RUN apt-get update -qq && apt-get install docker-ce -y

RUN usermod -aG docker jenkins
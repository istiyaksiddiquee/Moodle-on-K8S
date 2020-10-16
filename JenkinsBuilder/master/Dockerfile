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

COPY settings.xml /etc/maven/

ENV KUBECTL_VERSION="v1.14.5"
ENV KUBECTL_SHA256="26681319de56820a8467c9407e9203d5b15fb010ffc75ac5b99c9945ad0bd28c"
RUN curl --retry 3 --retry-connrefused -LO "https://storage.googleapis.com/kubernetes-release/release/${KUBECTL_VERSION}/bin/linux/amd64/kubectl" && \
    sha256sum kubectl | grep ${KUBECTL_SHA256} && \
    chmod +x kubectl && \
    mv kubectl /usr/local/bin/kubectl

RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -

RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"

RUN apt-get update -qq && apt-get install docker-ce -y

RUN usermod -aG docker jenkins
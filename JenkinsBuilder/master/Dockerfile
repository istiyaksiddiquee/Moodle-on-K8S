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

ARG HELM_VERSION=v3.3.3
ARG HELM_LOCATION="https://get.helm.sh"
ARG HELM_FILENAME="helm-${HELM_VERSION}-linux-amd64.tar.gz"
ARG HELM_SHA256="246d58b6b353e63ae8627415a7340089015e3eb542ff7b5ce124b0b1409369cc"
RUN wget ${HELM_LOCATION}/${HELM_FILENAME} && \
    echo Verifying ${HELM_FILENAME}... && \
    sha256sum ${HELM_FILENAME} | grep -q "${HELM_SHA256}" && \
    echo Extracting ${HELM_FILENAME}... && \
    tar zxvf ${HELM_FILENAME} && mv /linux-amd64/helm /usr/local/bin/ && \
    rm ${HELM_FILENAME} && rm -r /linux-amd64

RUN helm plugin install https://github.com/databus23/helm-diff --version v3.1.3 && \
    helm plugin install https://github.com/futuresimple/helm-secrets && \
    helm plugin install https://github.com/hypnoglow/helm-s3.git && \
    helm plugin install https://github.com/aslafy-z/helm-git.git

RUN wget https://github.com/roboll/helmfile/releases/download/v0.131.0/helmfile_linux_amd64 && \
    chmod +x helmfile_linux_amd64 && \
    mv helmfile_linux_amd64 /usr/local/bin/helmfile
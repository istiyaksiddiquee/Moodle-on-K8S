build_no=$1
port_no=$2
# cd Project1
# docker build -t istiyaksiddiquee/usermanagement:$build_no -f Dockerfile . 
cd ./helm-deploy 
awk -v a=$build_no \
    -v b=$port_no \
    '{gsub("@@BUILD_NO@@", a) \
    gsub("@@test@@", b)}1' \
    ./values/spring-usermanagement-values-template.yaml \
    > ./values/spring-usermanagement-values.yaml
# helmfile apply
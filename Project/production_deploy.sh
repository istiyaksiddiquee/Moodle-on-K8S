build_no=$1
cd Project1
docker build -t istiyaksiddiquee/usermanagement:$build_no -f Dockerfile . 
cd ../helm-deploy 
awk -v a=$build_no \
    '{gsub("@@BUILD_NO@@", a)}1' \
    ./values/spring-usermanagement-values-template.yaml \
    > ./values/spring-usermanagement-values.yaml
helmfile apply
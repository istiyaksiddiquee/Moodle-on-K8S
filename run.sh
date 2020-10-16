commit_msg=$1
git add . && git commit -m "$commit_msg" 
curl localhost:8080/job/automated_build/build?token=testedToken
chrome http://localhost:8080/job/automated_build/lastBuild/console
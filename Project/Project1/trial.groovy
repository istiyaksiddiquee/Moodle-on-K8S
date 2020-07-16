import hudson.model.*
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User


cause = build.getCause(hudson.model.Cause.UserIdCause.class);
username = cause.getUserName()
User id = User.get(cause.getUserId())


println("user id :: "+ cause.getUserId())

println("user name :: "+ username)

println("email :: "+ id.getProperty(Mailer.UserProperty.class).getAddress())

println("API Token :: "+ id.getProperty(jenkins.security.ApiTokenProperty.class).getApiToken())
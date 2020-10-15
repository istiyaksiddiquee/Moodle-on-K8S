package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class AdvancedLoadTest extends Simulation {

  val httpConf = http.baseUrl("http://localhost/")    


  def checkSpringEndpoint() = {
    repeat(5) {
      exec(http("Checking Spring Endpoint")
        .get("spring/users/"))
    }
  }

  def checkGoEndpoint() = {
    repeat(5) {
      exec(http("Check Go endpoint")
        .get("go/api/v1/tasks/"))
    }
  }
  
  def checkNestEndpoint() = {
    repeat(5) {
      exec(http("Check Nest endpoint")
        .get("nest/api/course/"))
    }
  }

  val scn = scenario("Using Functions")
      .exec(checkSpringEndpoint())
      .pause(5)
      .exec(checkGoEndpoint())
      .pause(5)
      .exec(checkNestEndpoint())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
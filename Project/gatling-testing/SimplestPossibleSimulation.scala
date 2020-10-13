import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimplestPossibleSimulation extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("http://localhost:3000/api/v1/tasks/")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(baseHttpProtocol)
}
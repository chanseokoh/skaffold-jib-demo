package backend

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/")
class WebController {

  @Get("/")
  @Produces(MediaType.TEXT_PLAIN)
  def index() {
    "Greetings from Groovy with Micronaut!"
  }
}

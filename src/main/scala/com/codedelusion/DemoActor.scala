package com.codedelusion

import akka.actor.Actor
import spray.can.Http
import spray.http.{HttpMethods, HttpRequest, Uri, HttpResponse}
import HttpMethods._

/**
 * Created by danny on 22/03/14.
 */
class DemoActor extends Actor {

  def receive = {
    case _:Http.Connected => sender ! Http.Register(self)

    case HttpRequest(GET, Uri.Path("/ping"), _, _, _) =>
      sender ! HttpResponse(entity = "PONG")
  }

}

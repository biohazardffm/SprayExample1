package com.codedelusion

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import spray.can.Http

object Main extends App {

	implicit val system = ActorSystem("SprayExample1")

  val demoactor = system.actorOf(Props[DemoActor], "DempActor")

	IO(Http)(system) ! Http.Bind(demoactor, "0.0.0.0", port = 8080)

	readLine()
	println("Shutting down...")
	system.shutdown()
}

package application

import scopt.OParser

case class Menu(
    message: String = "hello world",
    N: Int = 5
)

object Menu {

  def apply(args: Array[String])(withMenu: Menu => Unit): Unit =
    // OParser.parse returns Option[Config]
    OParser.parse(parser1, args, Menu()) match {
      case Some(config) =>
        withMenu(config)
      case _ =>
      // arguments are bad, error message will have been displayed
    }

  import scopt.OParser
  val builder = OParser.builder[Menu]
  val parser1 = {
    import builder._
    OParser.sequence(
      programName("example"),
      opt[Int]('n', "N")
        .action((n, c) => c.copy(N = n))
        .text("how many times to print the message"),
      opt[String]('m', "message")
        .required()
        .valueName("<message>")
        .action((message, c) => c.copy(message = message))
        .text("what message to print"),
      help("help").text("""
                            |You can execute like this:
                            |example -n 5 --message Hello!
                            |""".stripMargin)
    )
  }

}

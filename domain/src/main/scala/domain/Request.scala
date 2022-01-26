package domain

object Request {
  object sintax {
    sealed trait Type
    object Type {
      case object OutcomeUpdate extends Type
      case object BetPlacement extends Type
    }
    sealed trait Payload
    sealed trait Request {
      val `type`: Type
      val payload: Payload
    }
  }

  object instances {
    object OutcomeUpdate {
      case class Id(id: String)
      sealed trait Status
      object Status {
        case object Active extends Status
        case object Suspended extends Status
      }
      sealed trait Result
      object Result {
        case object Return extends Result
        case object Pending extends Result
        case object Win extends Result
      }
      case class Payload(
          id: Id,
          odds: Double,
          status: Status,
          result: Result,
          version: BigInt
      ) extends sintax.Payload
      case class Request(
          `type`: sintax.Type,
          payload: Payload
      ) extends sintax.Request
    }

    object BetPlacement {
      case class PlayerId(id: String)
      case class Payload(
          outcomeId: OutcomeUpdate.Id,
          playerId: PlayerId,
          stake: Double,
          odds: Double
      ) extends sintax.Payload
      case class Request(
          `type`: sintax.Type,
          payload: Payload
      ) extends sintax.Request
    }
  }
}

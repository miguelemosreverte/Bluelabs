package automation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}

class ExampleSpec extends AnyFlatSpec {
  "true" should "remain true" in {
    true must be(true)
  }
}

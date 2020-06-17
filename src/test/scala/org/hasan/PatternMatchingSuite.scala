package org.hasan

import org.hasan.simpleclass.MarginType
import org.hasan.simpleclass.MarginType.Margin
import org.hasan.simpleclass.SimpleClass
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PatternMatchingSuite extends AnyFunSuite with Matchers {
  // Using case classes for pattern matching
  // Case classes don't need new keyword as an apply method is automatically added
  test("Pattern matching using deconstruction of case classes") {
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val hasanVoiceRecording =
      VoiceRecording("Hasan", "voicerecording.org/id/456")

    def showNotification(notification: Notification): String = {
      notification match {
        case Email(email, title, _) =>
          s"You got an email from $email with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording("Hasan", link) =>
          s"you received a Voice Recording you sent yourself! Click the link to hear it: $link"
        case VoiceRecording(name, link) =>
          s"you received a Voice Recording from $name! Click the link to hear it: $link"
        case _ => throw new IllegalArgumentException
      }
    }

    showNotification(someSms) should equal(
      "You got an SMS from 12345! Message: Are you there?"
    )
    showNotification(someVoiceRecording) should equal(
      "you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123"
    )
    showNotification(hasanVoiceRecording) should equal(
      "you received a Voice Recording you sent yourself! Click the link to hear it: voicerecording.org/id/456"
    )
  }

  test("Pattern matching using types") {
    def getType(obj: Object): String = {
      obj match {
        case a: String =>
          "Got String"
        case a: SimpleClass =>
          "Got SimpleClass"
        case _ => throw new IllegalArgumentException
      }
    }

    getType("abc") should equal("Got String")
    getType(new SimpleClass(1, 2)) should equal("Got SimpleClass")
  }

  // In order to use constant in match, it has to start with a capital. If "Yval" was changed to "yval" then incorrect
  // output would be given as Scala would bind x to yval
  test("Pattern matching using constants") {
    val Yval = 5

    def constantMatch(x: Int): String = {
      x match {
        case Yval =>
          "Five"
        case _ =>
          "Not five"
      }
    }

    constantMatch(5) should equal("Five")
    constantMatch(6) should equal("Not five")
  }

  test("Pattern matching for options") {
    def optionPattern(myOption: Option[Int]): String = {
      myOption match {
        case Some(i) => "Number inside option is " + i
        case None    => "None"
      }
    }

    optionPattern(Some(5)) should equal("Number inside option is 5")
    optionPattern(None) should equal("None")
  }

  test("Pattern matching with arbitrary expression") {
    def arbitraryPattern(myString: String): String = {
      myString match {
        case _ if (myString.startsWith("abc")) => "Starts with abc"
        case _                                 => "Doesn't start with abc"
      }
    }

    arbitraryPattern("abcd") should equal("Starts with abc")
    arbitraryPattern("def") should equal("Doesn't start with abc")
  }

  test("Pattern matching using enums") {
    def enumMatch(margin: Margin): String = {
      margin match {
        case MarginType.TOP =>
          "Top"
        case MarginType.BOTTOM =>
          "Bottom"
      }
    }

    enumMatch(MarginType.TOP) should equal("Top")
    enumMatch(MarginType.BOTTOM) should equal("Bottom")
  }

  test("Pattern matching multiple matches") {
    def multipleMatch(i: Int): String = {
      i match {
        case 1 | 3 | 5 => "odd"
        case 2 | 4 | 6 => "even"
      }
    }
    multipleMatch(1) should equal("odd")
    multipleMatch(2) should equal("even")
  }
}

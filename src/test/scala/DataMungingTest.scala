
import org.scalatest.{FunSuite, Matchers}

class DataMungingTest extends FunSuite with Matchers{

  import com.meetup.lagosscala.{One, FactoredOne, Two, FactoredTwo}
  import com.meetup.lagosscala.Common._

  trait TestData {
    val o1 = new FactoredOne
    val o2 = new FactoredTwo
  }

  test("readFile correctly reads 'weather.dat'") {
    val lines = readFile("/weather.dat")
    assert(!lines.isEmpty, "Lines iterator is non-empty")
    assert(lines.toList.size == 33, "File completely read")
  }

  test("readFile correctly reads 'football.dat'") {
    val lines = readFile("/football.dat")
    assert(!lines.isEmpty, "Lines iterator is non-empty")
    assert(lines.toList.size == 22, "File completely read")
  }

  test("One.parsedLines correctly parses lines in 'weather.dat'") {
    val lines = readFile("/weather.dat")
    val one = new One(lines)
    assert(!one.parsedLines.isEmpty, "ParsedLines is non-empty")
    assert(one.parsedLines.size == 31, "File completely parsed")
  }

  test("Two.parsedLines correctly parses lines in 'football.dat'") {
    val lines = readFile("/football.dat")
    val two = new Two(lines)
    assert(!two.parsedLines.isEmpty, "ParsedLines is non-empty")
    assert(two.parsedLines.size == 20, "File completely parsed")
  }

  test("FactoredOne.parsedLines correctly parses lines in 'weather.dat'") {
    new TestData {
      assert(!o1.parsedLines.isEmpty, "ParsedLines is non-empty")
      assert(o1.parsedLines.size == 31, "File completely parsed")
    }
  }

  test("FactoredTwo.parsedLines correctly parses lines in 'football.dat'") {
    new TestData {
      assert(!o2.parsedLines.isEmpty, "ParsedLines is non-empty")
      assert(o2.parsedLines.size == 20, "File completely parsed")
    }
  }

}



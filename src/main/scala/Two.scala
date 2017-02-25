
package com.meetup.lagosscala

case class Team(name: String, difference: Int)

class Two(val lines: Iterator[String]) {

    val re = "([0-9.]+|[A-Za-z]+)".r

    lazy val parsedLines: List[Team] = {
        // Skip header row; apply regex to parse row data:
        lines.drop(1).map(re.findAllIn(_).toList).filter(!_.isEmpty).map { cols => 
            Team(cols(1), cols(6).toInt - cols(7).toInt)
        }.toList
    }

    def getMinDifference: Team = parsedLines.minBy { _.difference }
}

class FactoredTwo extends Common {
    lazy val parsedLines = parseFile("/football.dat")(cs => Team(cs(1), cs(6).toInt - cs(7).toInt))

    def getMinDifference: Team = parsedLines.minBy { _.difference }
}

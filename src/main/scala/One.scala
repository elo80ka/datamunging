
package com.meetup.lagosscala

case class WeatherData(day: String, spread: Float)

class One(val lines: Iterator[String]) {

    val re = "([0-9.]+|[A-Za-z]+)".r

    lazy val parsedLines: List[WeatherData] = {
        // Skip header and blank rows; apply regex to parse row data:
        lines.drop(1).map(re.findAllIn(_).toList).filter(!_.isEmpty).map { cols =>
            WeatherData(cols(0), cols(1).toFloat - cols(2).toFloat)
        }.toList
    }
    
    def getMinSpread: WeatherData = parsedLines.minBy { _.spread }
}

class FactoredOne extends Common {
    lazy val parsedLines = parseFile("/weather.dat")(cs => WeatherData(cs(0), cs(1).toFloat - cs(2).toFloat))

    def getMinSpread: WeatherData = parsedLines.minBy { _.spread }
}

// loktional.com

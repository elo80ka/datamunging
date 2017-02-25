
package com.meetup.lagosscala

import scala.io.Source

trait Common {

    // A type alias, to make our code just a bit clearer:
    type Row = List[String]

    // Roughly match (decimal) numbers, and upper/lowercase text.
    // Every other character will be silently ignored:
    val re = "([0-9.]+|[A-Za-z]+)".r

    // Read a file, and return an iterator over lines in the file:
    def readFile(name: String): Iterator[String] = {
        Source.fromInputStream(getClass.getResourceAsStream(name)).getLines
    }

    // Parse an iterator of Strings (a file), and return a list of T.
    // Call the function `result` to convert each row to the returned type T:
    def parseLines[T](lines: Iterator[String])(result: Row => T): List[T] = {
        lines.drop(1).map(re.findAllIn(_).toList).filter(!_.isEmpty).map(result(_)).toList
    }

    // A more convenient way to parse an input file:
    def parseFile[T](name: String)(result: Row => T): List[T] = {
        parseLines(readFile(name))(result)
    }
}

// Define a companion object so helper functions on the `Common` trait can be
// called by others:
object Common extends Common

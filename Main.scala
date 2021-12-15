package tentaBot

import scala.io.Source
import scala.util.Random
import scala.io.StdIn.readLine
import java.util.Scanner
import java.util.NoSuchElementException

object Main:
    def main(args: Array[String]): Unit =
        println(App.menu)
        App.handlechoice
package tentaBot
import scala.io.Source
import scala.util.Random
import scala.io.StdIn.readLine
import java.util.Scanner
import java.util.NoSuchElementException

object Theory: 

    val instuderingsVector: Vector[String] = 
        val source: Vector[String] = scala.io.Source.fromFile("instud_b2_2013.txt").getLines.toVector
        val filteredSource: Vector[String] = source.filterNot(x => x == "")
        filteredSource

    def randomInstFråga: String = instuderingsVector(Random.nextInt(instuderingsVector.length))





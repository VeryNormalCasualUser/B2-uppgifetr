package tentaBot

import scala.io.Source
import scala.util.Random
import scala.io.StdIn.readLine
import java.util.Scanner
import java.util.NoSuchElementException
import scala.collection.mutable.Buffer

object Calculate:

    val kap6buf: Buffer[String] = scala.io.Source.fromFile("Uppgifter.htm").getLines.toBuffer
    val kap6: Vector[String] = kap6buf.toVector
    val kap11: Vector[String] = scala.io.Source.fromFile("Uppgifter6.htm").getLines.toVector
    val kap12: Vector[String] = scala.io.Source.fromFile("Uppgifter2.htm").getLines.toVector
    val kap13: Vector[String] = scala.io.Source.fromFile("Uppgifter3.htm").getLines.toVector
    val kap14: Vector[String] = scala.io.Source.fromFile("Uppgifter4.htm").getLines.toVector
    val kap15: Vector[String] = scala.io.Source.fromFile("Uppgifter5.htm").getLines.toVector
    
    val _tot: Buffer[String] = kap6buf ++ kap11 ++ kap12 ++ kap13 ++ kap14 ++ kap15
    val tot: Vector[String] = _tot.toVector
    val totMap: Map[Int, Vector[String]] = Map(6 -> kap6, 11 -> kap11, 12 -> kap12, 13 -> kap13, 14 -> kap14, 15 -> kap15)

    def randomAssignment: String = tot(Random.nextInt(tot.length))

    def randomizer[T](chapter: Seq[T]): T = chapter.toVector(Random.nextInt(chapter.length))

    def choose: Int = readLine("Tryck (1) för en uppgift, tryck (2) för att gå tillbaks till menyn: ").toInt

    def chapterLoop(kap: Vector[String]): Unit = 
        var _choice: Int = choose 
        while _choice != 2 do
            if _choice == 1 then println("\n" + randomizer(kap) + "\n")
            else println("\n" + "Ogiltig input, testa igen." + "\n")
            _choice = choose
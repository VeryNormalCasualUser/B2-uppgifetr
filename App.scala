package tentaBot

import scala.io.Source
import scala.util.Random
import scala.io.StdIn.readLine
import java.util.Scanner
import java.util.NoSuchElementException

object App:

    val menu: String = 
        "\n" + " ********************************** " + "\n"  +
        "Hej och välkommen till tentabot!" + "\n" +
        "Tryck (1) för en slumpmässig uppgift" + "\n" + 
        "Tryck (2) för en slumpmässig instuderingsfråga" + "\n" +
        "Tryck (3) för att välja ett kapitel" + "\n" +
        "Tryck (4) för att dra härifrån" + "\n" +
        "Tryck (5) för att få upp menyn igen" + "\n" +
        "\n" + " ********************************** " + "\n"

    
    def handlechoice: Unit = 

        var choice: Int = 0

        var quit: Boolean = true

        def case3Recursive: Unit = 

            var kap: Int = 0

            try
                kap = readLine("Ange ett kapitelnummer (6 eller 11 till 15): ").toInt
                if Calculate.totMap.keys.toVector.contains(kap) then {println("\n" + s"Du har valt kap.: $kap" + "\n"); Calculate.chapterLoop(Calculate.totMap(kap))}
                else {println("\n" + "Ogiltig input. Välj ett av följande kapitel: 6, 11, 12, 13, 14, 15." + "\n"); case3Recursive}
            catch 
                case e: java.lang.NumberFormatException => {println("\n" + "Ogiltig input, testa igen." + "\n"); case3Recursive}
                case e: java.util.NoSuchElementException => {println("\n" + "Ogiltig input, testa igen." + "\n"); case3Recursive}



        def cases: Unit =
 
            val cHoice: String = "Du har valt: "
            choice = readLine("Ange Val: ").toInt
            def iffer(x: Int): Matchable = 
                x match
                    case 1 => "en slumpmässig uppgift"
                    case 2 => "en slumpmässig instuderingsfråga"
                    case 3 => "att studera en specifik kapitel"
                    case 4 => "att dra härifrån"
                    case 5 => 

            def caseIntro: Unit = println(cHoice + iffer(choice))

            choice match 
                case 1 =>
                    caseIntro
                    println(Calculate.randomAssignment)
                    println("\n")
                case 2 => 
                    caseIntro
                    val splitted: Array[String] = Theory.randomInstFråga.split(Array('.', '?', '¨'))
                    println("Du har valt fråga nr.:")
                    splitted.foreach(x => println(x + "\n"))
                    println("\n")
                case 3 => 
                    caseIntro
                    case3Recursive
                    println(menu)
                case 4 =>
                    println("Lycka till på tentan!" + "\n")
                    quit = false
                case 5 =>
                    println(App.menu)
        while quit do 
        try {
            cases
        } catch {
            case e: java.lang.NumberFormatException => println("Ogiltig input, testa igen.")
            case e: java.util.NoSuchElementException => println("Ogiltig input, testa igen.")
            case e: scala.MatchError => println("Var snäll och väl ett tal mellan 1 och 5")
        }
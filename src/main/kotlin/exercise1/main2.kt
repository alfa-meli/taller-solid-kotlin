import java.io.File

fun main() {
    val inputFilename = "src/main/resources/input.txt"
    val outputFilename = "src/main/resources/output.txt"

    val content = File(inputFilename).readText()
    val words = content.split(" ")
    val numWords = words.size

    val outputContent = "Number of words: $numWords"
    File(outputFilename).writeText(outputContent)

    println("Number of words in $inputFilename: $numWords")
    println("Output written to $outputFilename")
}
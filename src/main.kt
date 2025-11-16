import java.awt.Desktop
import java.io.File
import java.net.URI
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

suspend fun greetPerson() = withContext(Dispatchers.Default){

    val page1 = this.async {
        delay(4.milliseconds)
    }

    println("Welcome: User")
    page1.await()

}

suspend fun printMessageToUser() {
    greetPerson()
}

suspend fun main() {

    printMessageToUser()

    val userCommand = CommandCreationUser()

    try {

        println("Do You Want to Save the URL To a File: ")
        val questionedUser = readln()

        userCommand.printValues("Enter YouTube Channel")
        val url = readln()

        if (questionedUser.contains("Y")) {

            val fileWriteQuestion = File("url.url")
            if (fileWriteQuestion.exists()) {
                println("Exists Already")
                fileWriteQuestion.writeText(url)

            }

        }

        val webURL = WebsiteURL(url)
        val fileData = FileOpener()
        fileData.createURL(url)
        withContext(Dispatchers.IO) {
            Desktop.getDesktop().browse(URI.create(url))
        }

        if (url.isEmpty()) {
            userCommand.printValues("Y | N For Opening Website By File: ")
            val choiceByUser = readln()
            if (choiceByUser.contentEquals("Y")) {

                val urlId = fileData.createURL(webURL.getURL())
                val opener = WebsitesOpener("url.url", urlId)

                val userChannelStart = readln()
                if (userChannelStart.contains(urlId[0])) {

                    opener.readFileBase()
                }

            }
        }
    } catch(e: Exception) {
        println(e.message)
    }

}

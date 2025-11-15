import java.awt.Desktop
import java.io.File
import java.net.URI

fun main() {
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
        Desktop.getDesktop().browse(URI.create(url))

        if (url.isEmpty()) {
            userCommand.printValues("Y | N For Opening Website By File: ")
            val choiceByUser = readln()
            if (choiceByUser.contentEquals("Y")) {

                val urlId = fileData.createURL(webURL.getURL())
                val opener = WebsitesOpener("url.url", urlId)

                opener.readFileBase()


                println("You Have Visit")
            }
        }
    } catch(e: Exception) {
        println(e.message)
    }

}

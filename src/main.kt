import java.awt.Desktop
import java.net.URI

fun main() {

    try {
        println("Enter YouTube Channel")
        val url = readln()
        val webURL = WebsiteURL(url)
        val fileData = FileOpener()
        fileData.createURL(url)
        Desktop.getDesktop().browse(URI.create(url))

        if (url.isEmpty()) {
            println("Y | N For Opening Website By File: ")
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

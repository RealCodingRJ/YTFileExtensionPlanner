import java.awt.Desktop
import java.io.File
import java.net.URI

class WebsitesOpener(name: String, data: String) {

    var siteName: String = ""
    var webData: String = ""

    init {
        siteName = name
        webData = data
    }

    fun getWebURLByName(): String {
        return siteName
    }


    fun readFileBase() {
        val readURL = File(getWebURLByName()).readLines()

        SongsPlayed(readURL.toString(), webData).PrintSongToFile("url.url")

        readURL.forEachIndexed { index, e ->

            if (e[index].code.toString().startsWith("0: ")) {

                Desktop.getDesktop().browse(URI.create(index.toString() + 1))

            } else if ((e[index].code.toString().startsWith("1: "))) {

                Desktop.getDesktop().browse(URI.create(index.toString() + 2))

            } else {

                Desktop.getDesktop().browse(URI.create(e))

            }
        }
    }
}
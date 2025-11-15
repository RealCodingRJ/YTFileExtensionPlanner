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

        readURL.forEach { e ->
            Desktop.getDesktop().browse(URI.create(e))
        }
    }
}
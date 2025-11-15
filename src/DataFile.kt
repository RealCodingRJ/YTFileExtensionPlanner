interface Types {

    fun createURL(url: String): String
}


class FileOpener : Types {

    override fun createURL(url: String): String {

        return "https://www.youtube.com/${url}"

    }
}

class WebsiteURL(url: String) {

    var mainURL: String = ""

    init {
        mainURL = url
    }
    fun getURL(): String {
        return mainURL
    }
}
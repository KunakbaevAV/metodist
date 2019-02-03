package prof_parser

import com.google.gson.Gson
import profsandart.AProfstandart
import java.io.File

/**
 * @autor Kunakbaev Artem
 */
class JsonReader {
    fun readJson(jsonFile: String): AProfstandart {
        val gson = Gson()
        val text = File(jsonFile).readText()
        return gson.fromJson<AProfstandart>(text, AProfstandart::class.java)
    }
}


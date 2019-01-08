package profstandart

import com.google.gson.Gson
import profsandartSplit.ProfstandartSplit
import java.io.File

/**
 * @autor Kunakbaev Artem
 */
class JsonReader {
    fun readJson(xmlFile: String): ProfstandartSplit {
        val gson = Gson()
        val text = File(xmlFile).readText()
        return gson.fromJson<ProfstandartSplit>(text, ProfstandartSplit::class.java)
    }
}


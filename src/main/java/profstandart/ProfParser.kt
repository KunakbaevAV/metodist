package profstandart

import profsandartSplit.ProfstandartSplit

class ProfParser {
    fun parsing(patch: String): ProfstandartSplit {
        val reader = JsonReader()
//        val filePatch = "C:\\Java\\metodist_3\\src\\main\\resources\\255 Оператор по добыче нефти, газа и газового конденсата.json"
        val profstandart: ProfstandartSplit = reader.readJson(patch)
        return profstandart
    }
}
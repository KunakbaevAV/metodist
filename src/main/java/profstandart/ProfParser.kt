package profstandart

import profsandartSplit.ProfstandartSplit

class ProfParser {
    fun parsing(patch: String): ProfstandartSplit {
        val reader = JsonReader()
        val profstandart: ProfstandartSplit = reader.readJson(patch)
        return profstandart
    }
}
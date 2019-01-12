package prof_parser

import profsandart.AProfstandart

class ProfParser {
    fun parsing(patch: String): AProfstandart {
        val reader = JsonReader()
        val AProfstandart: AProfstandart = reader.readJson(patch)
        return AProfstandart
    }
}
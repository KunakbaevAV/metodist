package prof_parser

import java.io.FileReader

class FileCorrector(patch: String) {
    var gsonText = FileReader(patch).readText()
    val correctionNames = listOf(
            "laborAction",
            "educationalRequirement")

    fun correction(correctionName: String): String {
        val index = gsonText.indexOf(correctionName)
        val uncheckedText = gsonText.substring(index + correctionName.length).trim()
        if (!uncheckedText.startsWith("[")) {
            return findBlock(uncheckedText)
        } else {
            return "good"
        }
    }

    fun findBlock(text: String): String {
        val stack = Stack(10)
        stack.push('{')
        for (i in 0 until text.length) {
            if (text[i] == '{') stack.push(text[i])
            if (text[i] == '}') stack.pop()
            if (stack.isEmpty()) return "[${text.substring(0, i)}]"
        }
        return "ошибка"
    }
}
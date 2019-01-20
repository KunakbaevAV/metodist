package prof_parser

import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileCorrector(patch: String) {
    val correctionIndex = 3
    var file = File(patch)
    var gsonText = FileReader(patch).readText()
    val checkList = listOf(
            "UnitOKZ")
    var checkedText = StringBuilder()
    var startInd = 0
    var endInd = 0
    var errors = 0

    fun updateFile() {
        val writer = FileWriter(file)
        writer.append(checkText())
        writer.close()

    }

    fun checkText(): String {
        for (i in 0 until checkList.size) {
            if (checkNoMass(checkList[i])) {
                checkedText.append(gsonText.substring(startInd, endInd))
                checkedText.append(correction())
                checkedText.append(gsonText.substring(startInd))
                startInd = 0
            }
        }
        return if (errors > 0) checkedText.toString() else gsonText
    }

    fun checkNoMass(text: String): Boolean {
        val ind = gsonText.indexOf(text) + text.length
        if (gsonText[(ind + correctionIndex)] == '[') {
            return false
        } else {
            endInd = ind + correctionIndex
            return true
        }
    }

    fun correction(): String {
        val uncheckedText = gsonText.substring(endInd).trim()
        return doMass(uncheckedText)
    }

    fun doMass(text: String): String {
        val stack = Stack(10)
        stack.push('{')
        for (i in 0 until text.length) {
            if (text[i] == '{') stack.push(text[i])
            if (text[i] == '}') stack.pop()
            if (stack.isEmpty()) {
                startInd += endInd + i
                errors++
                return "[${text.substring(0, i - 1)}]"
            }
        }
        return "ошибка"
    }
}
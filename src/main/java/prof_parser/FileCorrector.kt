package prof_parser

import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileCorrector(patch: String) {
    val correctionIndex = 2
    var file = File(patch)
    var gsonText = FileReader(patch).readText()
    val checkList = listOf(
//            "UnitOKZ\"",
//            "EducationalRequirement\"",
//            "GeneralizedWorkFunction\"",
//            "LaborAction\"",
//            "UnitEKS\"",
//            "UnitOKVED\"",
//            "UnitOKZ\"",
//            "ParticularWorkFunction\"",
//            "NecessaryKnowledge\"",
//            "OrganizationDeveloper\"",
            "PossibleJobTitle\"",
            "RequiredSkill\"",
            "RequirementsWorkExperience\"",
            "SpecialConditionForAdmissionToWork\"")
    var checkedText = StringBuilder()
    var uncheckedText = gsonText
    var uncheckedInd = 0
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
            while (checkNoMass(uncheckedText, checkList[i])) {
                checkedText.append(uncheckedText.substring(startInd, endInd))
                uncheckedText = gsonText.substring(uncheckedInd)
                checkedText.append(doMass(uncheckedText))
                uncheckedText = gsonText.substring(uncheckedInd)
//                checkedText.append(gsonText.substring(startInd))
                startInd = 0
            }
            gsonText = checkedText.toString()
            checkedText.clear()
            uncheckedInd = 0
        }
        return gsonText
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

    fun checkNoMass(uncheckedText: String, text: String): Boolean {
        val ind = uncheckedText.indexOf(text) + text.length
        if (ind == -1 || uncheckedText[(ind + correctionIndex)] == '[') {
            return false
        } else {
            endInd = ind + correctionIndex
            uncheckedInd += ind
            return true
        }
    }

    fun correction(uncheckedText: String): String {
//        val uncheckedText = gsonText.substring(endInd).trim()
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
                uncheckedInd += i
                errors++
                return "[${text.substring(0, i - 1)}]"
            }
        }
        return "ошибка"
    }
}
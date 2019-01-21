package prof_parser

import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileCorrector(patch: String) {
    val correctionIndex = 2
    var file = File(patch)
    var gsonText = FileReader(patch).readText()
    val sim = "\": "
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
            "PossibleJobTitle$sim",
            "RequiredSkill$sim",
            "RequirementsWorkExperience$sim",
            "SpecialConditionForAdmissionToWork$sim")
    var globalCheckedText = StringBuilder()
    var globalUncheckedText = ""
    var noMass = true
    var errorInd = 0
    var errors = 0

    fun updateFile() {
        val writer = FileWriter(file)
        writer.append(checkText())
        writer.close()

    }

    fun checkText(): String {
        for (i in 0 until checkList.size) {
            globalUncheckedText = gsonText //Подготовиться к проверке на следующее словосочетание
            while (checkNoMass(globalUncheckedText, checkList[i])) { //поиск словосочетания
                if (noMass) {//если отсутствуют []
                    doMass(globalUncheckedText)
                }
            }
            finishText()
        }
        return gsonText
    }

    fun checkNoMass(uncheckedText: String, text: String): Boolean {
        if (uncheckedText.length < text.length){
            finishText()
            return false
        }
        val ind = uncheckedText.indexOf(text) + text.length

        if (ind == -1) { //строка не найдена
            finishText()
            return false
        } else if (uncheckedText[(ind + correctionIndex)] == '[') { //массив уже обозначен
            updateText(ind, uncheckedText)
            noMass = false
            return true
        } else { //скобки отсутствуют
            updateText(ind, uncheckedText)
            noMass = true
            return true
        }
    }

    fun doMass(text: String) {
        val stack = Stack(100)
        stack.push('{')
        for (i in 0 until text.length) {
            if (text[i] == '{') stack.push(text[i])
            if (text[i] == '}') stack.pop()
            if (stack.isEmpty()) {
                globalCheckedText.append('[')
                globalCheckedText.append(text.substring(0, i))
                globalCheckedText.append(']')
                globalUncheckedText = text.substring(i)
                errors++
                break
            }
        }
    }

    fun updateText(index: Int, text: String){
        globalCheckedText.append(text.substring(0, index))
        globalUncheckedText = text.substring(index)
    }

    fun finishText(){
        globalCheckedText.append(globalUncheckedText)
        gsonText = globalCheckedText.toString()
        globalCheckedText.clear()
        globalUncheckedText = gsonText
    }
}
package prof_parser

import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileCorrector(val patch: String) {
    var file = File(patch)
    var newFile = File(patch)
    var jsonText = FileReader(patch).readText()
    val xmlAdapter = XMLadapter()
    val sim = "\": "
    val checkList = listOf(
            "UnitOKZ$sim",
            "EducationalRequirement$sim",
            "GeneralizedWorkFunction$sim",
            "LaborAction$sim",
            "UnitEKS$sim",
            "UnitOKVED$sim",
            "UnitOKZ$sim",
            "ParticularWorkFunction$sim",
            "NecessaryKnowledge$sim",
            "OrganizationDeveloper$sim",
            "PossibleJobTitle$sim",
            "RequiredSkill$sim",
            "RequirementsWorkExperience$sim",
            "SpecialConditionForAdmissionToWork$sim"
    )
    var globalCheckedText = StringBuilder()
    var globalUncheckedText = StringBuilder().append(jsonText)
    var noMass = false
    var search = true
    var errors = 0

    fun updateFile() {
        checkIfXml()
        val writer = FileWriter(newFile)
        writer.append(checkText())

        writer.close()
    }

    fun checkIfXml() {
        if (patch.endsWith(".xml")) {
            jsonText = xmlAdapter.readXML(patch)
            globalUncheckedText.clear()
            globalUncheckedText.append(jsonText)

            val prePatch = patch.substringBeforeLast("/")
            val fileName = findNameProf(jsonText)
            newFile = File(prePatch + "/" + fileName + ".json")

            file.delete()
        }
    }

    fun findNameProf(text: String): String {
        val nameProf = text.substringAfter("NameProfessionalStandart\": \"")
        return nameProf.substringBefore("\"")
    }

    fun checkText(): String {
        var searshIndex: Int
        for (i in 0 until checkList.size) {
            while (true) {
                searshIndex = findIndex(checkList[i])
                if (searshIndex == -1) {
                    break
                } else {
                    updateText(searshIndex + checkList[i].length)
                }

                if (checkNoMass(checkList[i])) {
                    if (noMass) {
                        doMass()
                    }
                }
            }
            finishText()
        }
        return jsonText
    }

    fun findIndex(word: String): Int {
        return globalUncheckedText.indexOf(word)
    }

    fun checkNoMass(word: String): Boolean {
        if (globalUncheckedText.length < word.length) {
            finishText()
            search = false
            return false
        }

        if (globalUncheckedText.trim().startsWith('[')) { //массив уже обозначен
            noMass = false
            search = true
            return true
        } else {
            noMass = true
            search = true
            return true
        }

    }

    fun doMass() {
        val stack = Stack(100)
        stack.push('{')
        for (i in 0 until globalUncheckedText.length) {
            if (globalUncheckedText[i] == '{') stack.push('{')
            if (globalUncheckedText[i] == '}') stack.pop()
            if (stack.isEmpty()) {
                globalCheckedText.append('[')
                globalCheckedText.append(globalUncheckedText.substring(0, i))
                globalCheckedText.append(']')
                globalUncheckedText = globalUncheckedText.delete(0, i)
                errors++
                break
            }
        }
    }

    fun updateText(index: Int) {
        globalCheckedText.append(globalUncheckedText.substring(0, index))
        globalUncheckedText.delete(0, index)
    }

    fun finishText() {
        globalCheckedText.append(globalUncheckedText)
        jsonText = globalCheckedText.toString()
        globalCheckedText.clear()
        globalUncheckedText.clear()
        globalUncheckedText.append(jsonText)
    }
}
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.*
import prof_parser.Copy
import prof_parser.FileCorrector
import prof_parser.ProfParser
import profsandart.AProfstandart
import profsandart.GeneralizedWorkFunction
import profsandart.ParticularWorkFunction
import java.io.File
import java.net.URLDecoder

/**
 * @autor Kunakbaev Artem
 */
class Controller {
    val profFolder = "профстандарты/"
    val defaultLog = "©АртМил"
    val appName = "Атлас профстандартов"
    var patchProfstandart = ""
    val copy = Copy()

    val arrayChoiceBox = arrayListOf(
            "Действия",
            "Навыки",
            "Знания",
            "Доступные профессии"
    )

    var details = Details.ACTIONS

    var AProfstandart: AProfstandart? = null
    var generalizedWorkFunction: GeneralizedWorkFunction? = null
    var workFunction: ParticularWorkFunction? = null

    @FXML
    val buttonProf = Button()

    @FXML
    var profName = TextField()

    @FXML
    var textAreaDetails = TextArea()

    @FXML
    var purposeKindProfessionalActivity = TextArea()

    @FXML
    var listViewGWF = ListView<GeneralizedWorkFunction>()

    @FXML
    var listViewWF = ListView<ParticularWorkFunction>()

    @FXML
    var listProfsandarts = ListView<String>()

    @FXML
    var choiceBox = ChoiceBox<String>()

    @FXML
    var logPanel = Label()

    @FXML
    val myButton = Button()

    fun initListViewProfstandarts() {
        val profList = ArrayList<String>()
        profList.addAll(getArrayProfst())
        val observableList: ObservableList<String> =
                FXCollections.observableArrayList(profList)
        listProfsandarts.items = observableList
        listProfsandarts.setOnMouseClicked {
            readProfstandart(listProfsandarts.selectionModel.selectedItem)
            generalizedWorkFunction = null
            workFunction = null
            listViewWF.items = null
            showDetals()
        }
        initChoiceBox()
    }

    fun readProfstandart(thisProfName: String) {
        val patch = getProfstFolder() + thisProfName
        patchProfstandart = patch
        try {
            AProfstandart = ProfParser().parsing(patch)
        } catch (e: java.lang.Exception) {
            logPanel.text = e.toString()
        }

        profName.text = AProfstandart!!.xMLCardInfo!!.professionalStandarts!!
                .professionalStandart!!.nameProfessionalStandart
        purposeKindProfessionalActivity.text = AProfstandart!!.xMLCardInfo!!.professionalStandarts!!
                .professionalStandart!!.firstSection!!.purposeKindProfessionalActivity
        initListViewGeneralizedWorkFunctions()
        initListViewWorkFunctions()
    }

    fun readWF() {
        val observableListTF: ObservableList<ParticularWorkFunction?>? =
                FXCollections.observableArrayList(generalizedWorkFunction!!
                        .particularWorkFunctions!!.particularWorkFunction)
        listViewWF.items = observableListTF
    }

    private fun initChoiceBox() {
        val observableList: ObservableList<String> = FXCollections.observableArrayList(arrayChoiceBox)
        choiceBox.items = observableList
        choiceBox.setOnAction {
            when (choiceBox.selectionModel.selectedItem!!) {
                arrayChoiceBox[0] -> {
                    details = Details.ACTIONS
                    showDetals()
                }
                arrayChoiceBox[1] -> {
                    details = Details.KNOWLEDGES
                    showDetals()
                }
                arrayChoiceBox[2] -> {
                    details = Details.SKILLS
                    showDetals()
                }
                arrayChoiceBox[3] -> {
                    details = Details.PROFESSIONS
                    showDetals()
                }
            }
        }
    }

    private fun initListViewWorkFunctions() {
        listViewWF.setOnMouseClicked {
            workFunction = listViewWF.selectionModel.selectedItem
            copy.doCopy(workFunction.toString().substringAfter(" "))
            showDetals()
        }
    }

    private fun showDetals() {

        if (workFunction == null) {
            textAreaDetails.text = "Не выбрана трудовая функция"
        } else {
            when (details) {
                Details.ACTIONS -> textAreaDetails.text = workFunction!!.laborActions.toString()
                Details.SKILLS -> textAreaDetails.text = workFunction!!.requiredSkills.toString()
                Details.KNOWLEDGES -> textAreaDetails.text = workFunction!!.necessaryKnowledges.toString()
                Details.PROFESSIONS -> textAreaDetails.text = generalizedWorkFunction!!.possibleJobTitles!!.toString()
            }
        }

    }

    private fun initListViewGeneralizedWorkFunctions() {
        //создаю ObservableList из листа названий обобщенных ТФ
        val observableListGTF: ObservableList<GeneralizedWorkFunction> = FXCollections.observableArrayList(AProfstandart!!
                .xMLCardInfo!!
                .professionalStandarts!!
                .professionalStandart!!
                .thirdSection!!
                .workFunctions!!
                .generalizedWorkFunctions!!
                .generalizedWorkFunction)

        //запускаю список обобщенных ТФ на экран
        listViewGWF.items = observableListGTF
        listViewGWF.setOnMouseClicked {
            generalizedWorkFunction = listViewGWF.selectionModel.selectedItem
            copy.doCopy(generalizedWorkFunction.toString().substringAfter(" "))
            workFunction = null
            showDetals()
            readWF()
        }
    }

    private fun getProfstFolder(): String? {
        val appPatch = javaClass.protectionDomain.codeSource.location.path
        val decoderAppPatch = URLDecoder.decode(appPatch, "UTF-8")
        val dirtyPatch = decoderAppPatch + profFolder
        val cleanPatch = dirtyPatch.replace("$appName.jar", "")
        return cleanPatch.substring(1)
    }

    private fun getArrayProfst(): Array<String> {
        val folder = File(getProfstFolder())
        val listOfFiles = folder.listFiles()
        val arrayProfst = Array(listOfFiles.size) { "" }
        for (i in 0 until listOfFiles.size) {
            if (listOfFiles[i].isFile) arrayProfst[i] = listOfFiles[i].name
        }
        return arrayProfst
    }

    fun pressButton() {
        readFile()
    }

    private fun readFile() {
        val corrector = FileCorrector(patchProfstandart)
        corrector.updateFile()
        logPanel.text = "Исправлено ошибок: " + corrector.errors.toString()
    }
}

enum class Details {
    ACTIONS,
    SKILLS,
    KNOWLEDGES,
    PROFESSIONS
}
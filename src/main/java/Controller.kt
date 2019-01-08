import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.*
import profsandartSplit.GeneralizedWorkFunction
import profsandartSplit.ParticularWorkFunction
import profsandartSplit.ProfstandartSplit
import profstandart.ProfParser

/**
 * @autor Kunakbaev Artem
 */
class Controller {
    val arrayProfstandarts = arrayListOf(
            "255 Оператор по добыче нефти, газа и газового конденсата",
            "821 Работник по эксплуатации оборудования по добыче нефти, газа и газового конденсата",
            "1005 Работник по эксплуатации оборудования подземных хранилищ газа",
            "414 Бурильщик капитального ремонта скважин",
            "1195 Работник по исследованию скважин"
//            "509 Педагог-психолог (психолог в сфере образования)"
    )

    val arrayChoiceBox = arrayListOf(
            "Действия",
            "Навыки",
            "Знания",
            "Доступные профессии"
    )

    var details = Details.ACTIONS

    var profstandart: ProfstandartSplit? = null
    var generalizedWorkFunction: GeneralizedWorkFunction? = null
    var workFunction: ParticularWorkFunction? = null

    @FXML
    val buttonDownload = Button()

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

    fun initListViewProfstandarts() {
        val observableList: ObservableList<String> =
                FXCollections.observableArrayList(arrayProfstandarts)
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
        profstandart = ProfParser().parsing(
                "src/main/resources/$thisProfName.json")
        profName.text = profstandart!!.xMLCardInfo!!.professionalStandarts!!
                .professionalStandart!!.nameProfessionalStandart
        purposeKindProfessionalActivity.text = profstandart!!.xMLCardInfo!!.professionalStandarts!!
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
            when (choiceBox.selectionModel.selectedItem!!){
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
            showDetals()
        }
    }

    private fun showDetals() {

        if (workFunction == null){
            textAreaDetails.text = "Не выбрана трудовая функция"
        }else{
            when(details){
                Details.ACTIONS -> textAreaDetails.text = workFunction!!.laborActions.toString()
                Details.SKILLS -> textAreaDetails.text = workFunction!!.requiredSkills.toString()
                Details.KNOWLEDGES -> textAreaDetails.text = workFunction!!.necessaryKnowledges.toString()
                Details.PROFESSIONS -> textAreaDetails.text = generalizedWorkFunction!!.possibleJobTitles!!.toString()
            }
        }

    }

    private fun initListViewGeneralizedWorkFunctions() {
        //создаю ObservableList из листа названий обобщенных ТФ
        val observableListGTF: ObservableList<GeneralizedWorkFunction> = FXCollections.observableArrayList(profstandart!!
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
            workFunction = null
            showDetals()
            readWF()
        }
    }
}

enum class Details {
    ACTIONS,
    SKILLS,
    KNOWLEDGES,
    PROFESSIONS
}
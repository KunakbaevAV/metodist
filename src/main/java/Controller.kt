import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import profsandartSplit.GeneralizedWorkFunction
import profsandartSplit.ParticularWorkFunction
import profsandartSplit.ProfstandartSplit
import profstandart.ProfParser

/**
 * @autor Kunakbaev Artem
 */
class Controller {
    val arrayProfstandarts = arrayListOf<String>(
            "ps_255",
            "ps_821",
            "ps_1005"
    )

    var profstandart: ProfstandartSplit? = null

    @FXML
    val buttonDownload = Button()

    @FXML
    val buttonProf = Button()

    @FXML
    var profName = TextField()

    @FXML
    var detals = TextArea()

    @FXML
    var purposeKindProfessionalActivity = TextArea()

    @FXML
    var listViewGWF = ListView<GeneralizedWorkFunction>()

    @FXML
    var listViewWF = ListView<ParticularWorkFunction>()

    @FXML
    var listProfsandarts = ListView<String>()

    fun readProfstandart() {
        profstandart = ProfParser().parsing(
                "src/main/resources/" +
                        listProfsandarts.selectionModel.selectedItem)
        profName.text = profstandart!!.xMLCardInfo!!.professionalStandarts!!.professionalStandart!!.nameProfessionalStandart
        purposeKindProfessionalActivity.text = profstandart!!.xMLCardInfo!!.professionalStandarts!!
                .professionalStandart!!
                .firstSection!!
                .purposeKindProfessionalActivity
        initListViewGeneralizedWorkFunctions()
        initListViewWorkFunctions()
    }

    fun initListViewProfstandarts() {
        val observableList: ObservableList<String> =
                FXCollections.observableArrayList(arrayProfstandarts)
        listProfsandarts.items = observableList
    }

    private fun initListViewWorkFunctions() {
        listViewWF.setOnMouseClicked {
            val workFunction = listViewWF.selectionModel.selectedItem
            detals.text = workFunction.laborActions.toString()
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
            val generalizedWorkFunction = listViewGWF.selectionModel.selectedItem
            readWF(generalizedWorkFunction)
        }
    }

    fun readWF(generalizedWorkFunction: GeneralizedWorkFunction) {
        val observableListTF: ObservableList<ParticularWorkFunction?>? = FXCollections.observableArrayList(generalizedWorkFunction
                .particularWorkFunctions!!
                .particularWorkFunction)
        listViewWF.items = observableListTF
    }

}

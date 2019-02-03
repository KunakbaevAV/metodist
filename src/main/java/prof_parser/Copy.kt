package prof_parser

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class Copy {
    var stringSelection = StringSelection("")
    var clipBoard = Toolkit.getDefaultToolkit().systemClipboard

    fun doCopy(text: String) {
        stringSelection = StringSelection(text)
        clipBoard.setContents(stringSelection, null)
    }
}
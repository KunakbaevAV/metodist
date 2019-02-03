package prof_parser

import org.json.XML
import java.io.File
import java.io.PrintWriter

class XMLadapter() {
    fun readXML(patch: String) {
        val jsonObj = XML.toJSONObject(File(patch).readText())
        val out = PrintWriter(patch, "UTF-8")
        out.write(jsonObj.toString(4))
        out.close()
    }
}
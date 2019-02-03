package prof_parser

import org.json.XML
import java.io.File

class XMLadapter() {
    val stack = Stack(200)

    fun readXML(patch: String): String {
        val jsonObj = XML.toJSONObject(File(patch).readText())
//        println(jsonObj.toString(6))
        return jsonObj.toString(4)

    }

//    fun doTransfers(text: String): String{
//        var builder = StringBuilder()
//        for(i in 0 until text.length){
//            builder.append(text[i])
//            when (text[i]){
//                '{' -> builder.append("\n")
//                '[' -> builder.append("\n")
//                ',' -> builder.append("\n")
//            }
//        }
//    }
}
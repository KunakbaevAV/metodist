package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneralizedWorkFunctions(
        @SerializedName("GeneralizedWorkFunction")
        @Expose
        val generalizedWorkFunction: List<GeneralizedWorkFunction?>?
) {
    fun getSize(): Int = generalizedWorkFunction!!.size

    fun getNamesGWF(): ArrayList<String> {
        val listName = ArrayList<String>()
        for (i in 0 until getSize()) listName.add(generalizedWorkFunction!![i].toString())
        return listName
    }
}


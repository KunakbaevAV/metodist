package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ParticularWorkFunctions(
        @SerializedName("ParticularWorkFunction")
        @Expose
        val particularWorkFunction: List<ParticularWorkFunction?>?
) {
    fun getSize(): Int = particularWorkFunction!!.size

    fun getNamesWF(): ArrayList<String> {
        val listName = ArrayList<String>()
        for (i in 0 until getSize()) listName.add(particularWorkFunction!![i].toString())
        return listName
    }
}
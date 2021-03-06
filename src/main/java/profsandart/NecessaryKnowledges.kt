package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NecessaryKnowledges(
        @SerializedName("NecessaryKnowledge")
        @Expose
        val necessaryKnowledge: List<String?>?
){
        override fun toString(): String {
                return necessaryKnowledge!!.joinToString(separator = "\n")
        }
}
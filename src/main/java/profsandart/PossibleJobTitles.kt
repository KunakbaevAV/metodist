package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PossibleJobTitles(
        @SerializedName("PossibleJobTitle")
        @Expose
        val possibleJobTitle: List<String?>?
) {
    override fun toString(): String {
        return possibleJobTitle!!.joinToString(separator = "\n")
    }
}
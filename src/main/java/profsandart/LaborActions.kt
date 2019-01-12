package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LaborActions(
        @SerializedName("LaborAction")
        @Expose
        val laborAction: List<String?>?
) {
    override fun toString(): String {
        return laborAction!!.joinToString(separator = "\n")
    }
}
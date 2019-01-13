package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequiredSkills(
        @SerializedName("RequiredSkill")
        @Expose
        val requiredSkill: List<String?>?
){
        override fun toString(): String {
                return requiredSkill!!.joinToString(separator = "\n")
        }
}
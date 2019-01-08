package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequiredSkills(
        @SerializedName("RequiredSkill")
        @Expose
        val requiredSkill: List<String?>?
)
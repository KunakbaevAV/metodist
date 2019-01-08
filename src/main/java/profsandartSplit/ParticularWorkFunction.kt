package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ParticularWorkFunction(
        @SerializedName("CodeTF")
        @Expose
        val codeTF: String?,
        @SerializedName("LaborActions")
        @Expose
        val laborActions: LaborActions?,
        @SerializedName("")
        @Expose
        val listFootnes: Any?,
        @SerializedName("NameTF")
        @Expose
        val nameTF: String?,
        @SerializedName("NecessaryKnowledges")
        @Expose
        val necessaryKnowledges: NecessaryKnowledges?,
        @SerializedName("OtherCharacteristics")
        @Expose
        val otherCharacteristics: Any?,
        @SerializedName("RequiredSkills")
        @Expose
        val requiredSkills: RequiredSkills?,
        @SerializedName("SubQualification")
        @Expose
        val subQualification: String?
) {
    override fun toString(): String {
        return "$codeTF $nameTF"
    }
}
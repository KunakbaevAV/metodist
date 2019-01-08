package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneralizedWorkFunction(
        @SerializedName("CodeOTF")
        @Expose
        val codeOTF: String?,
        @SerializedName("EducationalRequirements")
        @Expose
        val educationalRequirements: EducationalRequirements?,
        @SerializedName("LevelOfQualification")
        @Expose
        val levelOfQualification: String?,
        @SerializedName("NameOTF")
        @Expose
        val nameOTF: String?,
        @SerializedName("OtherCharacteristicPlus")
        @Expose
        val otherCharacteristicPlus: OtherCharacteristicPlus?,
        @SerializedName("OtherCharacteristics")
        @Expose
        val otherCharacteristics: Any?,
        @SerializedName("ParticularWorkFunctions")
        @Expose
        val particularWorkFunctions: ParticularWorkFunctions?,
        @SerializedName("PossibleJobTitles")
        @Expose
        val possibleJobTitles: PossibleJobTitles?,
        @SerializedName("RequirementsWorkExperiences")
        @Expose
        val requirementsWorkExperiences: RequirementsWorkExperiences?,
        @SerializedName("SpecialConditionsForAdmissionToWork")
        @Expose
        val specialConditionsForAdmissionToWork: SpecialConditionsForAdmissionToWork?
) {
    override fun toString(): String {
        return "$codeOTF$levelOfQualification. $nameOTF)"
    }
}

package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SpecialConditionsForAdmissionToWork(
        @SerializedName("SpecialConditionForAdmissionToWork")
        @Expose
        val specialConditionForAdmissionToWork: List<String?>?
)
package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfessionalStandarts(
        @SerializedName("ProfessionalStandart")
        @Expose
        val professionalStandart: ProfessionalStandart?
)
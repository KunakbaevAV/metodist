package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class XMLCardInfo(
        @SerializedName("Xmlnsxsd")
        @Expose
        val xmlnsxsd: String?,
        @SerializedName("Xmlnsxsi")
        @Expose
        val xmlnsxsi: String?,
        @SerializedName("ProfessionalStandarts")
        @Expose
        val professionalStandarts: ProfessionalStandarts?
)
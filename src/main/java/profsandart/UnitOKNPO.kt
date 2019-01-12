package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitOKNPO(
        @SerializedName("CodeOKNPO")
        @Expose
        val codeOKNPO: String?,
        @SerializedName("NameOKNPO")
        @Expose
        val nameOKNPO: String?
)
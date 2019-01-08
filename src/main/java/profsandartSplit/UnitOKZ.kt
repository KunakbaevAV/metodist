package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitOKZ(
        @SerializedName("CodeOKZ")
        @Expose
        val codeOKZ: String?,
        @SerializedName("NameOKZ")
        @Expose
        val nameOKZ: String?
)
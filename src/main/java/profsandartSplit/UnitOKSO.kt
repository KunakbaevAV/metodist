package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitOKSO(
        @SerializedName("CodeOKSO")
        @Expose
        val codeOKSO: String?,
        @SerializedName("NameOKSO")
        @Expose
        val nameOKSO: String?
)
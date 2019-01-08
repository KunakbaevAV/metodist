package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitEKS(
        @SerializedName("CodeEKS")
        @Expose
        val codeEKS: String?,
        @SerializedName("NameEKS")
        @Expose
        val nameEKS: String?
)
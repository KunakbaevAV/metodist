package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitOKVED(
        @SerializedName("CodeOKVED")
        @Expose
        val codeOKVED: String?,
        @SerializedName("NameOKVED")
        @Expose
        val nameOKVED: String?
)
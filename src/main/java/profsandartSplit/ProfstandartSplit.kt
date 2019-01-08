package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfstandartSplit(
        @SerializedName("XMLCardInfo")
        @Expose
        val xMLCardInfo: XMLCardInfo?
)
package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AProfstandart(
        @SerializedName("XMLCardInfo")
        @Expose
        val xMLCardInfo: XMLCardInfo?
)
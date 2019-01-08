package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ThirdSection(
        @SerializedName("WorkFunctions")
        @Expose
        val workFunctions: WorkFunctions?
)
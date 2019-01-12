package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WorkFunctions(
        @SerializedName("GeneralizedWorkFunctions")
        @Expose
        val generalizedWorkFunctions: GeneralizedWorkFunctions?
)
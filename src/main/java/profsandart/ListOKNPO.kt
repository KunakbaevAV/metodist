package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOKNPO(
        @SerializedName("UnitOKNPO")
        @Expose
        val unitOKNPO: UnitOKNPO?
)
package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOKSO(
        @SerializedName("UnitOKSO")
        @Expose
        val unitOKSO: UnitOKSO?
)
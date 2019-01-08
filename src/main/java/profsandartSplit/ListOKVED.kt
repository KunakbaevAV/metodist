package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOKVED (
        @SerializedName("UnitOKVED")
        @Expose
        val unitOKVED: List<UnitOKVED?>?
)



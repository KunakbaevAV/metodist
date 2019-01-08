package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EmploymentGroup(
        @SerializedName("ListOKVED")
        @Expose
        val listOKVED: ListOKVED?,
        @SerializedName("ListOKZ")
        @Expose
        val listOKZ: ListOKZ?
)
package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OtherCharacteristicPlus(
        @SerializedName("ListEKS")
        @Expose
        val listEKS: ListEKS?,
        @SerializedName("ListOKNPO")
        @Expose
        val listOKNPO: ListOKNPO?,
        @SerializedName("ListOKSO")
        @Expose
        val listOKSO: ListOKSO?,
        @SerializedName("ListOKZ")
        @Expose
        val listOKZ: ListOKZ?
)
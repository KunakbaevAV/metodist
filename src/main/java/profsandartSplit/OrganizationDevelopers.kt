package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrganizationDevelopers(
        @SerializedName("OrganizationDeveloper")
        @Expose
        val organizationDeveloper: List<String?>?
)
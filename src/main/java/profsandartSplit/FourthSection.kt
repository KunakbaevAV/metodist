package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FourthSection(
        @SerializedName("OrganizationDevelopers")
        @Expose
        val organizationDevelopers: OrganizationDevelopers?,
        @SerializedName("ResponsibleDeveloper")
        @Expose
        val responsibleDeveloper: ResponsibleDeveloper?
)
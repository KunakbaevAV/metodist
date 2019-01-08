package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FirstSection(
        @SerializedName("CodeKindProfessionalActivity")
        @Expose
        val codeKindProfessionalActivity: String?,
        @SerializedName("EmploymentGroup")
        @Expose
        val employmentGroup: EmploymentGroup?,
        @SerializedName("KindProfessionalActivity")
        @Expose
        val kindProfessionalActivity: String?,
        @SerializedName("PurposeKindProfessionalActivity")
        @Expose
        val purposeKindProfessionalActivity: String?
)
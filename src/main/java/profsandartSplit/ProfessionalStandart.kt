package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfessionalStandart(
        @SerializedName("DateOfApproval")
        @Expose
        val dateOfApproval: String?,
        @SerializedName("FirstSection")
        @Expose
        val firstSection: FirstSection?,
        @SerializedName("FourthSection")
        @Expose
        val fourthSection: FourthSection?,
        @SerializedName("NameProfessionalStandart")
        @Expose
        val nameProfessionalStandart: String?,
        @SerializedName("OrderNumber")
        @Expose
        val orderNumber: String?,
        @SerializedName("RegistrationNumber")
        @Expose
        val registrationNumber: String?,
        @SerializedName("ThirdSection")
        @Expose
        val thirdSection: ThirdSection?
)
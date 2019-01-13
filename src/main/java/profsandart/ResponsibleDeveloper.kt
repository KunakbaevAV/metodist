package profsandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponsibleDeveloper(
        @SerializedName("ResponsibleDeveloper")
        @Expose
        val responsibleDeveloper: String?,
        @SerializedName("TheFullNameOfTheHead")
        @Expose
        val theFullNameOfTheHead: String?,
        @SerializedName("ThePositionOfHead")
        @Expose
        val thePositionOfHead: String?
)
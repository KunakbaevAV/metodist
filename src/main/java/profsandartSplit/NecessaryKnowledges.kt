package profsandartSplit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NecessaryKnowledges(
        @SerializedName("NecessaryKnowledge")
        @Expose
        val necessaryKnowledge: List<String?>?
)
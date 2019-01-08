package profsandartSplit

data class RequirementsWorkExperiences(
//        @SerializedName("RequirementsWorkExperience")
//        @Expose
        val requirementsWorkExperience: List<String?>?
){
    override fun toString(): String {
        return requirementsWorkExperience!!.joinToString(separator = "\n")
    }
}
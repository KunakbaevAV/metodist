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

/*class RequirementsWorkExperiences{
    @SerializedName("RequirementsWorkExperience")
    @Expose
    var requirementsWorkExperience: List<String?>? = null

    constructor(requirementsWorkExperience: List<String?>?){
        this.requirementsWorkExperience = requirementsWorkExperience
    }

    constructor(string: String){
        this.requirementsWorkExperience = listOf(string)
    }
}*/

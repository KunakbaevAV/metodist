/*
package profstandart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Profstandart(
        @SerializedName("XMLCardInfo")
        @Expose
        val xMLCardInfo: XMLCardInfo?
) {
    data class XMLCardInfo(
            val xmlnsxsi: String?,
            val xmlnsxsd: String?,
            @SerializedName("ProfessionalStandarts")
            @Expose
            val professionalStandarts: ProfessionalStandarts?
    ) {
        data class ProfessionalStandarts(
                @SerializedName("ProfessionalStandart")
                @Expose
                val professionalStandart: ProfessionalStandart?
        ) {
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
            ) {
                data class ThirdSection(
                        @SerializedName("WorkFunctions")
                        @Expose
                        val workFunctions: WorkFunctions?
                ) {
                    data class WorkFunctions(
                            @SerializedName("GeneralizedWorkFunctions")
                            @Expose
                            val generalizedWorkFunctions: GeneralizedWorkFunctions?
                    ) {
                        data class GeneralizedWorkFunctions(
                                @SerializedName("GeneralizedWorkFunction")
                                @Expose
                                val generalizedWorkFunction: List<GeneralizedWorkFunction?>?
                        ) {
                            data class GeneralizedWorkFunction(
                                    @SerializedName("CodeOTF")
                                    @Expose
                                    val codeOTF: String?,
                                    @SerializedName("EducationalRequirements")
                                    @Expose
                                    val educationalRequirements: EducationalRequirements?,
                                    @SerializedName("LevelOfQualification")
                                    @Expose
                                    val levelOfQualification: String?,
                                    @SerializedName("NameOTF")
                                    @Expose
                                    val nameOTF: String?,
                                    @SerializedName("OtherCharacteristicPlus")
                                    @Expose
                                    val otherCharacteristicPlus: OtherCharacteristicPlus?,
                                    @SerializedName("OtherCharacteristics")
                                    @Expose
                                    val otherCharacteristics: Any?,
                                    @SerializedName("ParticularWorkFunctions")
                                    @Expose
                                    val particularWorkFunctions: ParticularWorkFunctions?,
                                    @SerializedName("PossibleJobTitles")
                                    @Expose
                                    val possibleJobTitles: PossibleJobTitles?,
                                    @SerializedName("RequirementsWorkExperiences")
                                    @Expose
                                    val requirementsWorkExperiences: RequirementsWorkExperiences?,
                                    @SerializedName("SpecialConditionsForAdmissionToWork")
                                    @Expose
                                    val specialConditionsForAdmissionToWork: SpecialConditionsForAdmissionToWork?

                            ) {
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
                                ) {
                                    data class ListOKNPO(
                                            @SerializedName("UnitOKNPO")
                                            @Expose
                                            val unitOKNPO: UnitOKNPO?
                                    ) {
                                        data class UnitOKNPO(
                                                @SerializedName("CodeOKNPO")
                                                @Expose
                                                val codeOKNPO: String?,
                                                @SerializedName("NameOKNPO")
                                                @Expose
                                                val nameOKNPO: String?
                                        )
                                    }

                                    data class ListEKS(
                                            @SerializedName("UnitEKS")
                                            @Expose
                                            val unitEKS: List<UnitEKS?>?
                                    ) {
                                        data class UnitEKS(
                                                @SerializedName("CodeEKS")
                                                @Expose
                                                val codeEKS: String?,
                                                @SerializedName("NameEKS")
                                                @Expose
                                                val nameEKS: String?
                                        )
                                    }

                                    data class ListOKSO(
                                            @SerializedName("UnitOKSO")
                                            @Expose
                                            val unitOKSO: UnitOKSO?
                                    ) {
                                        data class UnitOKSO(
                                                @SerializedName("CodeOKSO")
                                                @Expose
                                                val codeOKSO: String?,
                                                @SerializedName("NameOKSO")
                                                @Expose
                                                val nameOKSO: String?
                                        )
                                    }

                                    data class ListOKZ(
                                            @SerializedName("UnitOKZ")
                                            @Expose
                                            val unitOKZ: List<UnitOKZ?>?
                                    ) {
                                        data class UnitOKZ(
                                                @SerializedName("CodeOKZ")
                                                @Expose
                                                val codeOKZ: String?,
                                                @SerializedName("NameOKZ")
                                                @Expose
                                                val nameOKZ: String?
                                        )
                                    }
                                }

                                data class RequirementsWorkExperiences(
                                        @SerializedName("RequirementsWorkExperience")
                                        @Expose
                                        val requirementsWorkExperience: List<String?>?
                                )

                                data class ParticularWorkFunctions(
                                        @SerializedName("ParticularWorkFunction")
                                        @Expose
                                        val particularWorkFunction: List<ParticularWorkFunction?>?
                                ) {
                                    data class ParticularWorkFunction(
                                            @SerializedName("CodeTF")
                                            @Expose
                                            val codeTF: String?,
                                            @SerializedName("LaborActions")
                                            @Expose
                                            val laborActions: LaborActions?,
                                            @SerializedName("ListFootnes")
                                            @Expose
                                            val listFootnes: Any?,
                                            @SerializedName("NameTF")
                                            @Expose
                                            val nameTF: String?,
                                            @SerializedName("NecessaryKnowledges")
                                            @Expose
                                            val necessaryKnowledges: NecessaryKnowledges?,
                                            @SerializedName("OtherCharacteristics")
                                            @Expose
                                            val otherCharacteristics: Any?,
                                            @SerializedName("RequiredSkills")
                                            @Expose
                                            val requiredSkills: RequiredSkills?,
                                            @SerializedName("SubQualification")
                                            @Expose
                                            val subQualification: String?
                                    ) {
                                        data class LaborActions(
                                                @SerializedName("LaborAction")
                                                @Expose
                                                val laborAction: List<String?>?
                                        )

                                        data class NecessaryKnowledges(
                                                @SerializedName("NecessaryKnowledge")
                                                @Expose
                                                val necessaryKnowledge: List<String?>?
                                        )

                                        data class RequiredSkills(
                                                @SerializedName("RequiredSkill")
                                                @Expose
                                                val requiredSkill: List<String?>?
                                        )
                                    }
                                }

                                data class PossibleJobTitles(
                                        @SerializedName("PossibleJobTitle")
                                        @Expose
                                        val possibleJobTitle: List<String?>?
                                )

                                data class EducationalRequirements(
                                        @SerializedName("EducationalRequirement")
                                        @Expose
                                        val educationalRequirement: List<String?>?
                                )

                                data class SpecialConditionsForAdmissionToWork(
                                        @SerializedName("SpecialConditionForAdmissionToWork")
                                        @Expose
                                        val specialConditionForAdmissionToWork: List<String?>?
                                )

                                override fun toString(): String {
                                    return "$codeOTF$levelOfQualification. $nameOTF)"
                                }
                            }
                        }
                    }
                }

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
                ) {
                    data class EmploymentGroup(
                            @SerializedName("ListOKVED")
                            @Expose
                            val listOKVED: ListOKVED?,
                            @SerializedName("ListOKZ")
                            @Expose
                            val listOKZ: ListOKZ?
                    ) {
                        data class ListOKVED(
                                @SerializedName("UnitOKVED")
                                @Expose
                                val unitOKVED: UnitOKVED?
                        ) {
                            data class UnitOKVED(
                                    @SerializedName("CodeOKVED")
                                    @Expose
                                    val codeOKVED: String?,
                                    @SerializedName("NameOKVED")
                                    @Expose
                                    val nameOKVED: String?
                            )
                        }

                        data class ListOKZ(
                                @SerializedName("UnitOKZ")
                                @Expose
                                val unitOKZ: List<UnitOKZ?>?
                        ) {
                            data class UnitOKZ(
                                    @SerializedName("CodeOKZ")
                                    @Expose
                                    val codeOKZ: String?,
                                    @SerializedName("NameOKZ")
                                    @Expose
                                    val nameOKZ: String?
                            )
                        }
                    }
                }

                data class FourthSection(
                        @SerializedName("OrganizationDevelopers")
                        @Expose
                        val organizationDevelopers: OrganizationDevelopers?,
                        @SerializedName("ResponsibleDeveloper")
                        @Expose
                        val responsibleDeveloper: ResponsibleDeveloper?
                ) {
                    data class OrganizationDevelopers(
                            @SerializedName("OrganizationDeveloper")
                            @Expose
                            val organizationDeveloper: List<String?>?
                    )

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
                }
            }
        }
    }
}

*/

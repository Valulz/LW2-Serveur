package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cv")
public class CVEntry {

    public enum Gender{
        MR,
        MRS
    }

    private String id;
    private Gender gender;
    private Name name;
    private String firstName;
    private String objective;
        private String skill;
        private List<Experience> experiences;
        private List<School> schools;
        private List<Language> languages;
        private List<ComputerScienceSkill> skills;

        public CVEntry() {}

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }
    @XmlElement
    public void setName(Name name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getObjective() {
        return objective;
    }
    @XmlElement
    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }
    @XmlElement
    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<School> getSchools() {
        return schools;
    }
    @XmlElement
    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public List<Language> getLanguages() {
        return languages;
    }
    @XmlElement
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<ComputerScienceSkill> getSkills() {
        return skills;
    }
    @XmlElement
    public void setSkills(List<ComputerScienceSkill> skills) {
        this.skills = skills;
    }

    public String getSkill() {
        return skill;
    }
    @XmlElement
    public void setSkill(String skill) {
        this.skill = skill;
    }
}

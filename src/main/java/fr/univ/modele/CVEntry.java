package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.rmi.server.UID;
import java.util.List;

@XmlRootElement(name="cv")
public class CVEntry {

    public enum Gender{
        MR,
        MRS
    }

    private int id;
    private Gender gender;
    private String name;
    private String firstName;
    private String ojective;
    private List<Experience> experiences;
    private List<School> schools;
    private List<Language> languages;
    private List<ComputerScienceSkill> skills;

    public CVEntry() {}

    public CVEntry(int id, Gender gender, String name, String firstName, String ojective, List<Experience> experiences,
                   List<School> schools, List<Language> languages, List<ComputerScienceSkill> skills) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.ojective = ojective;
        this.experiences = experiences;
        this.schools = schools;
        this.languages = languages;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOjective() {
        return ojective;
    }
    @XmlElement
    public void setOjective(String ojective) {
        this.ojective = ojective;
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
}

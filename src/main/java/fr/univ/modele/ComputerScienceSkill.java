package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "computer_science_skill")
public class ComputerScienceSkill {

    private String name;
    private int level;

    public ComputerScienceSkill() {
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    @XmlElement
    public void setLevel(int level) {
        this.level = level;
    }
}

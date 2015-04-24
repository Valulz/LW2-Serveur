package fr.univ.modele;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "language")
public class Language {

    private String name;
    private int level;
    private String description;

    public Language() { }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    @XmlAttribute
    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }
}

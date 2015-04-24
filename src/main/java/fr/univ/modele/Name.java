package fr.univ.modele;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "name")
public class Name {

    private String name;
    private boolean maidenName;


    public Name() {
    }

    public Name(String name, boolean maidenName) {
        this.name = name;
        this.maidenName = maidenName;
    }

    public String getName() {
        return name;
    }

    @XmlValue
    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaidenName() {
        return maidenName;
    }

    @XmlAttribute
    public void setMaidenName(boolean maidenName) {
        this.maidenName = maidenName;
    }
}

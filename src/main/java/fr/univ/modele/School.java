package fr.univ.modele;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.Date;

@XmlRootElement(name = "school")
public class School {

    private Date begin;
    private Date end;
    private String name;

    public School() {}

    public Date getBegin() {
        return begin;
    }

    @XmlAttribute
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    @XmlAttribute
    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    @XmlValue
    public void setName(String name) {
        this.name = name;
    }

}

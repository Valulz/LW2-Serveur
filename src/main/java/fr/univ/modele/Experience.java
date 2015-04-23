package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name="experience")
public class Experience {
    private Date begin;
    private Date end;
    private String name;

    public Experience() { }

    public Date getBegin() {
        return begin;
    }

    @XmlElement
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    @XmlElement
    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}

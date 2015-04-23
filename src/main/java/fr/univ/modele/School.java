package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

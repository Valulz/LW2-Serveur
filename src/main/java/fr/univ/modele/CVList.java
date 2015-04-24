package fr.univ.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.rmi.server.UID;
import java.util.*;

@XmlRootElement(name = "cvs")
public class CVList {

    private List<CVEntry> cvEntries;

    public CVList() {
        this.cvEntries = new ArrayList<CVEntry>();
    }

    public List<CVEntry> getCvEntries() {
        return cvEntries;
    }

    public CVEntry getCV(int position){
        return cvEntries.get(position);
    }

    @XmlElement
    public void setCvEntries(List<CVEntry> cvEntries) {
        this.cvEntries = cvEntries;
    }

    public void addCV(CVEntry cv){
        this.cvEntries.add(cv);
    }

}

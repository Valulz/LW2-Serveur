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

        CVEntry cv = new CVEntry();
        cv.setId(0);
        cv.setGender(CVEntry.Gender.MR);
        cv.setName("LOL");
        cv.setFirstName("XD");
        cv.setOjective("Devenir le maitre du monde");

        Experience exp = new Experience();
        exp.setBegin(new Date());
        exp.setName("Travail");
        List<Experience> l = new ArrayList<Experience>();
        l.add(exp);
        l.add(exp);
        cv.setExperiences(l);

        School sc = new School();
        sc.setBegin(new Date());
        sc.setName("Univ");
        List<School> ls = new ArrayList<School>();
        ls.add(sc);
        ls.add(sc);
        cv.setSchools(ls);

        Language lang = new Language();
        lang.setName("Anglais");
        lang.setLevel(20);
        lang.setDescription("Lu parlé écrit");
        List<Language> lg = new ArrayList<Language>();
        lg.add(lang);
        lg.add(lang);
        cv.setLanguages(lg);

        ComputerScienceSkill css = new ComputerScienceSkill();
        css.setLevel(20);
        css.setName("Java");
        List<ComputerScienceSkill> lcss = new ArrayList<ComputerScienceSkill>();
        lcss.add(css);
        lcss.add(css);
        cv.setSkills(lcss);

        cvEntries.add(cv);
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

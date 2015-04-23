package fr.univ.controller;

import fr.univ.modele.CVEntry;
import fr.univ.modele.CVList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/resume")
public class CVController {

    private CVList list = new CVList();

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody CVEntry getCVInXML(@PathVariable long id){
        CVEntry cv = new CVEntry();
        for(CVEntry tmp : list.getCvEntries()){
            if(tmp.getId() == id){
                cv = tmp;
                break;
            }
        }

        return cv;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody CVList getCVInXML(){
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody CVEntry addCv(@RequestBody CVEntry cvEntry){

        list.addCV(cvEntry);

        return cvEntry;
    }

}

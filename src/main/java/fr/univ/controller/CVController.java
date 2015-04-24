package fr.univ.controller;

import fr.univ.modele.CVEntry;
import fr.univ.modele.CVList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

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
    public @ResponseBody CVList getCVInXML() throws UnknownHostException {
        //DBCollection coll = getDatabase();

        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody CVEntry addCv(@RequestBody CVEntry cvEntry){

        list.addCV(cvEntry);

        return cvEntry;
    }

    /**
     * Connect to the MongoDB database for the cv
     * @return the collection of cv
     * @throws UnknownHostException if the database can't be found
     */
    private DBCollection getDatabase() throws UnknownHostException {
        final String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        final String port = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
        final String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
        final String pass = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
        final String dbName = "lw2";
        final String collection = "cv";

        MongoCredential credential = MongoCredential.createCredential(user, dbName, pass.toCharArray());

        MongoClient mongoClient = new MongoClient(
                new ServerAddress(host, Integer.parseInt(port)),
                Arrays.asList(credential)
        );

        DB db = mongoClient.getDB(dbName);
        db.createCollection(collection, null);

        return db.getCollection(collection);
    }




}

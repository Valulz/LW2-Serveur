package fr.univ.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import com.mongodb.util.JSON;
import fr.univ.modele.CVEntry;
import fr.univ.modele.CVList;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/resume")
public class CVController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    CVEntry getCVInXML(@PathVariable String id) throws UnknownHostException {
        DBCollection collection = getDatabase();
        DBCursor cursor = collection.find();

        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            CVEntry entry = new Gson().fromJson(obj.toString(), CVEntry.class);
            entry.setId( ((ObjectId) obj.get("_id")).toString()) ;

            if (entry.getId().equalsIgnoreCase(id)) {
                cursor.close();
                return entry;
            }
        }
        cursor.close();

        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    CVList getCVInXML() throws UnknownHostException {
        DBCollection collection = getDatabase();
        List<CVEntry> entries = new ArrayList<CVEntry>();

        DBCursor cursor = collection.find();

        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            CVEntry entry = new Gson().fromJson(obj.toString(), CVEntry.class);
            entry.setId( ((ObjectId) obj.get("_id")).toString()) ;
            entries.add(entry);
        }

        CVList list = new CVList();
        list.setCvEntries(entries);
        return list;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    CVEntry addCv(@RequestBody CVEntry cvEntry) throws UnknownHostException {
        DBCollection collection = getDatabase();

        DBObject dbObject = (DBObject) JSON.parse(new Gson().toJson(cvEntry));
        collection.insert(dbObject);
        cvEntry.setId(dbObject.get("_id").toString());
        return cvEntry;
    }

    /**
     * Connect to the MongoDB database for the cv
     *
     * @return the collection of cv
     * @throws UnknownHostException if the database can't be found
     */
    private DBCollection getDatabase() throws UnknownHostException {
        final String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        String port = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
        final String user = "admin";
        final String pass = "A64RgrVU1IBR";
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

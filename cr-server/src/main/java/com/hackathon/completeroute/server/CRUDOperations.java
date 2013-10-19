package com.hackathon.completeroute.server;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.*;

/**
 * @author Michal Dojcar
 */
public class CRUDOperations {

    private static DBCollection collection;

    public void init() throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("completeroute");
        collection = courseDB.getCollection("test");
        collection.drop();

//        testInsert();
//        testFind();
//        testUpdateAndRemove();
//        testFindAndModify();
    }

    public void testInsert() {
        DBObject doc = new BasicDBObject();
        doc.put("userName", "mdojcar");
        doc.put("birthday", new Date(234832423));
        doc.put("programmer", true);
        doc.put("age", 27);
        doc.put("languages", Arrays.asList("Java", "Javascript", "Scala"));
        doc.put("address", new BasicDBObject("street", "Duhova")
                .append("city", "Prachatice"));

        DBObject doc2 = new BasicDBObject("_id", new ObjectId()).append("x", -1);

        System.out.println("Insert: " + doc);
        collection.insert(Arrays.asList(doc, doc2));
        System.out.println("Inserted: " + doc);
        collection.drop();
    }

    public void testFind() {
        for (int i=0; i<100; i++) {
            Random random = new Random();
            collection.insert(new BasicDBObject("_id", i)
                    .append("x", random.nextInt(2))
                    .append("y", random.nextInt(100))
                    .append("z", new BasicDBObject("a", random.nextInt(90)+10).append("b", random.nextInt(90)+10)));
        }

        DBObject one = collection.findOne();
        System.out.println("FindOne: "+one);

        System.out.println("Find:");
        QueryBuilder builder = QueryBuilder.start("x").is(0)
                .and("y").greaterThan(20).lessThan(80)
                .and("z.a").greaterThan(20);
        DBObject query = builder.get();
        DBObject projection = new BasicDBObject("_id", false);
        DBCursor cursor = collection.find(query, projection)
                .sort(new BasicDBObject("z.b", -1))
                .skip(2)
                .limit(5);
        try {
            while(cursor.hasNext()) {
                DBObject doc = cursor.next();
                System.out.println(doc);
            }
        } finally {
            cursor.close();
        }

        long count = collection.count();
        System.out.println("Count: "+count);
        collection.drop();
    }

    public void testUpdateAndRemove() {
        List<String> names = Arrays.asList("alice", "bobby", "cathy", "david", "ethan");
        for (String name : names)
            collection.insert(new BasicDBObject("_id", name));

        System.out.println("Update:");
        collection.update(new BasicDBObject("_id", "alice"), new BasicDBObject("age", 24));
        collection.update(new BasicDBObject("_id", "alice")
                , new BasicDBObject("$set",new BasicDBObject("gender", "F")));
        collection.update(new BasicDBObject("_id", "frank")
                , new BasicDBObject("$set",new BasicDBObject("gender", "M")), true, false);
        collection.update(new BasicDBObject()
                , new BasicDBObject("$set",new BasicDBObject("title", "Dr.")), true, true);
        printCollection();

        System.out.println("Remove:");
        collection.remove(new BasicDBObject("_id", "david"));
        printCollection();

        collection.drop();
    }

    public void testFindAndModify() {
        System.out.println("FindAndModify:");
        String counterId = "abc";
        int first;
        int numNeeded;

        numNeeded = 2;
        first = getRange(counterId, numNeeded);
        System.out.println("range "+first+"-"+(first+numNeeded-1));
        numNeeded = 3;
        first = getRange(counterId, numNeeded);
        System.out.println("range "+first+"-"+(first+numNeeded-1));
        numNeeded = 10;
        first = getRange(counterId, numNeeded);
        System.out.println("range "+first+"-"+(first+numNeeded-1));
    }

    private int getRange(String counterId, int numNeeded) {
        DBObject doc = collection.findAndModify(new BasicDBObject("_id", counterId), null, null, false
                , new BasicDBObject("$inc", new BasicDBObject("counter", numNeeded)), true, true);
        return (Integer) doc.get("counter") - numNeeded + 1;
    }


    private void printCollection() {
        DBCursor cursor = collection.find();
        try {
            while(cursor.hasNext()) {
                DBObject doc = cursor.next();
                System.out.println(doc);
            }
        } finally {
            cursor.close();
        }
    }
}

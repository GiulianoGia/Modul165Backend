package ch.gianola.quizApplication.Connector;

import ch.gianola.quizApplication.Models.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MongoDBConnector {
    public MongoCollection<Document> getDocument(String documentId) {
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder().applyConnectionString(new ConnectionString("mongodb://root:root@localhost")).build()
        );
        MongoDatabase database = mongoClient.getDatabase("Quiz");
        try {
            MongoCollection<Document> docs = database.getCollection(documentId);
            return docs;
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
        return null;
    }

    public AggregateIterable<Document> getAllQuestions(MongoCollection<Document> mongoCollection) {
        AggregateIterable<Document> documentAggregateIterable = mongoCollection.aggregate(Arrays.asList(new Document("$match",
                new Document())));
        return documentAggregateIterable;
    }

    public AggregateIterable<Document> getQuestionByName(MongoCollection<Document> mongoCollection, String questionName) {
        AggregateIterable<Document> documentAggregateIterable = mongoCollection.aggregate(Arrays.asList(new Document("$match",
                new Document("question", questionName))));
        return  documentAggregateIterable;
    }

    public List<Question> mapQuestionDocumentasList(AggregateIterable<Document> documentAggregateIterable) {
        List<Question> resultQuestion = new ArrayList<>();
        try {
            Iterator<Document> itQuestion = documentAggregateIterable.iterator();
            Gson gson = new GsonBuilder().create();
            while (itQuestion.hasNext()) {
                Document docQuestion = itQuestion.next();
                Question question = gson.fromJson(docQuestion.toJson(), Question.class);
                resultQuestion.add(question);
            }
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
        return resultQuestion;
    }
    public Question mapQuestionDocument(AggregateIterable<Document> documentAggregateIterable) {
        Question question = new Question();
        try {
            Iterator<Document> itQuestion = documentAggregateIterable.iterator();
            Gson gson = new GsonBuilder().create();
            while (itQuestion.hasNext()) {
                Document docQuestion = itQuestion.next();
                question = gson.fromJson(docQuestion.toJson(), Question.class);
            }
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
        return question;
    }
}

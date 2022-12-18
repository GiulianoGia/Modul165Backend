package ch.gianola.quizApplication.Connector;


import ch.gianola.quizApplication.Models.Question;
import ch.gianola.quizApplication.Models.Quiz;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MongoDBQuizConnector {

    public AggregateIterable<Document> getAllQuiz(MongoCollection<Document> mongoCollection) {
        AggregateIterable<Document> documentAggregateIterable = mongoCollection.aggregate(Arrays.asList(new Document("$match",
                new Document())));
        return documentAggregateIterable;
    }

    public List<Quiz> mapQuizDocumentasList(AggregateIterable<Document> documentAggregateIterable) {
        List<Quiz> resultQuestion = new ArrayList<>();
        try {
            Iterator<Document> itQuiz = documentAggregateIterable.iterator();
            Gson gson = new GsonBuilder().create();
            while (itQuiz.hasNext()) {
                Document docQuestion = itQuiz.next();
                Quiz quiz = gson.fromJson(docQuestion.toJson(), Quiz.class);
                resultQuestion.add(quiz);
            }
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
        return resultQuestion;
    }

    public void insertDocument(MongoCollection mongoCollection, Quiz quiz) {
        Gson gson = new GsonBuilder().create();
        Document document = Document.parse(gson.toJson(quiz));
        mongoCollection.insertOne(document);
    }

}

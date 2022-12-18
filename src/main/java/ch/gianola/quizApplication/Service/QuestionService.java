package ch.gianola.quizApplication.Service;

import ch.gianola.quizApplication.Connector.MongoDBConnector;
import ch.gianola.quizApplication.Models.Question;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {

    MongoDBConnector mongoDBConnector = new MongoDBConnector();
    MongoCollection<Document> questionMongoCollection = mongoDBConnector.getDocument("Question");

    public List<Question> getALlQuestions() {
        AggregateIterable<Document> aggregateIterable = mongoDBConnector.getAllQuestions(questionMongoCollection);
        List<Question> questionList = mongoDBConnector.mapQuestionDocumentasList(aggregateIterable);
        return questionList;
    }

    public Question getQuestionByName(String questionName) {
        AggregateIterable<Document> aggregateIterable = mongoDBConnector.getQuestionByName(questionMongoCollection, questionName);
        Question question = mongoDBConnector.mapQuestionDocument(aggregateIterable);
        return question;
    }
}

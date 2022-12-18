package ch.gianola.quizApplication.Service;

import ch.gianola.quizApplication.Connector.MongoDBConnector;
import ch.gianola.quizApplication.Connector.MongoDBQuizConnector;
import ch.gianola.quizApplication.Models.Question;
import ch.gianola.quizApplication.Models.Quiz;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    MongoDBQuizConnector mongoDBQuizConnector = new MongoDBQuizConnector();
    MongoDBConnector mongoDBConnector = new MongoDBConnector();
    MongoCollection<Document> quizMongoCollection = mongoDBConnector.getDocument("Quiz");

    public List<Quiz> getAllQuiz() {
        AggregateIterable<Document> documentAggregateIterable = mongoDBQuizConnector.getAllQuiz(quizMongoCollection);
        List<Quiz> quizList = mongoDBQuizConnector.mapQuizDocumentasList(documentAggregateIterable);
        return quizList;
    }

    public void setQuiz(Quiz quiz) {
        mongoDBQuizConnector.insertDocument(quizMongoCollection, quiz);
    }
}

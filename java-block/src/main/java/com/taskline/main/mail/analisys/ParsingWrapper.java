package com.taskline.main.mail.analisys;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParsingWrapper {
    private IndexReader reader;

    public List<ScoreDoc> search(String title, String body, String query) throws IOException, ParseException {
        List<Document> teaserDocsList = new ArrayList<>();
//        teaserDocsList.add(MessageToDocument.createWith("Отправить отчет №03/12-01 в Министерство Транспорта", "Необходимо отправить комплексный отчет о выполнении работы на строительном объем Саларьево."));
//        teaserDocsList.add(MessageToDocument.createWith("Принять поставщиков в администрации Восточного Округа", "Аркадий, необходимо до 13 числа оформить все документы для вывода нашего подрядчика на объект по адресу"));
//        teaserDocsList.add(MessageToDocument.createWith("Решение вопроса разрыва нефетпровода в Капотне", "При принятии поставщикох с данными с сайта гос. услуг, чтобы принимать дополнительные условия. При наличии ошибок в документе стоит обратиться к главе управы."));
//        teaserDocsList.add(MessageToDocument.createWith("Праздник в честь дня города", "При решение вопроса нужно обращать внимание на экологию и журналистов."));
//        teaserDocsList.add(MessageToDocument.createWith("Распределение бюджета", "Необходимо макмально пупуляризировать данное меропритие среди местных жителей. Оценка результатов будет происходить по количеству посетителей."));
//        teaserDocsList.add(MessageToDocument.createWith("Заключение сделки с Подрядчиком по строительству участка железной дороги", "Новый бюджет должен быть социально направленным, по просьбе граждан до 15% должно уходить на дпоолнительные пособия и стипендии."));
//        teaserDocsList.add(MessageToDocument.createWith("Разместить информационный блок о кружках города на сайте", "На мероприятии в обязательном порядке должен пристутсовать Алексей Алексеевич."));
//        teaserDocsList.add(MessageToDocument.createWith("Замена крыши на здании министерства", "Крышу нужно перекрыть косметически, используя руберойд."));
//        teaserDocsList.add(MessageToDocument.createWith("Речь префекта", "При решение вопросов обращаться к тех. специалисту Какули Егоровичу"));
//        teaserDocsList.add(MessageToDocument.createWith("Провести новый год в Министерестве", "В срочном порядке нужно подготовить речь префекта на открытие монумента на главной площади"));
//        teaserDocsList.add(MessageToDocument.createWith("Отправить отчет №03/12-01 в Министерство Транспорта", "Необходимо отправить комплексный отчет о выполнении работы на строительном объем Саларьево."));
        teaserDocsList.add(MessageToDocument.createWith(title, body));



        final MessageIndexer indexer = new MessageIndexer("/tmp/teaser_index");
        indexer.index(true, teaserDocsList);

        reader = indexer.readIndex();

        List<ScoreDoc> docListBody = Stream.of(fuzzySearch(query, "body", 10)).collect(Collectors.toList());
        docListBody.addAll(Arrays.asList(fuzzySearch(query, "title", 10)));
        return docListBody;
    }


    public ScoreDoc[] fuzzySearch(final String toSearch, final String searchField, final int limit) throws IOException, ParseException {
        final IndexSearcher indexSearcher = new IndexSearcher(reader);

        final Term term = new Term(searchField, toSearch);

        final int maxEdits = 2; // This is very important variable. It regulates fuzziness of the query
        final Query query = new FuzzyQuery(term, maxEdits);
        final TopDocs search = indexSearcher.search(query, limit);
        final ScoreDoc[] hits = search.scoreDocs;
        System.out.println("for " + toSearch + " | " + searchField + " score " + hits.length);
        return hits;
    }

    private void showHits(final ScoreDoc[] hits) throws IOException {
        if (hits.length == 0) {
            System.out.println("\n\tНичего не найдено");
            return;
        }
        System.out.println("\n\tРезультаты поиска:");
        for (ScoreDoc hit : hits) {
            final String title = reader.document(hit.doc).get("title");
            final String body = reader.document(hit.doc).get("body");
            System.out.println("\n\tDocument Id = " + hit.doc + "\n\ttitle = " + title + "\n\tbody = " + body);
        }
    }

}

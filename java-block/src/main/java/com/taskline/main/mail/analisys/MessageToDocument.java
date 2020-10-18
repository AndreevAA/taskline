package com.taskline.main.mail.analisys;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexOptions;


public class MessageToDocument {


    public static Document createWith(final String titleStr, final String bodyStr) {
        final Document document = new Document();

        final FieldType textIndexedType = new FieldType();
        textIndexedType.setStored(true);
        textIndexedType.setIndexOptions(IndexOptions.DOCS);
        textIndexedType.setTokenized(true);

        //index title
        Field title = new Field("title", titleStr, textIndexedType);
        //index body
        Field body = new Field("body", bodyStr, textIndexedType);

        document.add(title);
        document.add(body);
        return document;
    }
}


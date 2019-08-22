package com.cookie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVAdapterImpl<A> extends CSVAdapter<A> {
    //Объявляем конструктов
    public CSVAdapterImpl(Class<Author> authorClass, FileReader fileReader, FileWriter fileWriter) throws IOException {
        this.authorClass = authorClass;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }
}

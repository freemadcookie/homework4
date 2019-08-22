package com.cookie;
import java.io.*;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        
        //указываем путь к файлу
        File inputFile = Paths.get(".")
                .resolve("inputAuthors.csv")
                .toFile();

        FileReader fileReader = new FileReader(inputFile);
        FileWriter fileWriter = new FileWriter(inputFile, true);


        CSVAdapter<Author> authorCsvAdapter =
                new CSVAdapterImpl<Author>(Author.class,fileReader,fileWriter);

        Author author = authorCsvAdapter.read(0);

        Author authorNew = new Author();
        authorNew.setName("Некоторый Автор");
        authorNew.setAddress("Некоторый Город");

        int rowIndex = authorCsvAdapter.append(authorNew);
        Author authorNewOpened = authorCsvAdapter.read(rowIndex);

    }
}

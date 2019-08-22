package com.cookie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVAdapter<A> {
    FileReader fileReader;
    FileWriter fileWriter;
    Class authorClass;

    //Метод чтения из файла
    public Author read(int i) throws IOException {
        Author author = new Author();

        //Создаем массив строк, для быстрого доступа по индексу
        BufferedReader bReader = new BufferedReader(fileReader);
        String oneLine;
        List<String> allLines = new ArrayList<>();

        while ((oneLine = bReader.readLine()) != null) {
            allLines.add(oneLine);
        }

        author.setName(allLines.get(i).split(";")[0]);
        author.setAddress(allLines.get(i).split(";")[1]);

        return author;
    }
    //Добавление новой строки в конец файла
    public int append(Author author) throws IOException
    {
        int index = 0;
        BufferedReader bReader = new BufferedReader(fileReader);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("\n" + author.getName() + ";" + author.getAddress());
        bWriter.close();

        while (bReader.readLine() != null) index++;

        return index-1;
    }

}

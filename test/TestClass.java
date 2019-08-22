import com.cookie.Author;
import com.cookie.CSVAdapter;
import com.cookie.CSVAdapterImpl;

import java.io.*;
import java.nio.file.Paths;

import org.junit.Test;
import static org.junit.Assert.*;



public class TestClass{
    private File inputFile = Paths.get(".")
            .resolve("inputAuthors.csv")
            .toFile();

    private FileReader fileReader = new FileReader(inputFile);
    private FileWriter fileWriter = new FileWriter(inputFile, true);

    private CSVAdapter<Author> authorCsvAdapter =
            new CSVAdapterImpl<Author>(Author.class,fileReader,fileWriter);

    private Author author = authorCsvAdapter.read(0);


    public TestClass() throws IOException {
    }

    @Test public void testRead() {
        assertEquals("Лев Николаевич Толстой", author.getName());
        assertEquals("Ясная Поляна", author.getAddress());
    }

    @Test public void testAppend() throws IOException {
        Author authorNew = new Author();
        authorNew.setName("Некоторый Автор");
        authorNew.setAddress("Некоторый Город");

        int rowIndex = authorCsvAdapter.append(authorNew);
        Author authorNewOpened = authorCsvAdapter.read(rowIndex);
        assertEquals("Некоторый Автор", authorNewOpened.getName());
        assertEquals("Некоторый Город", authorNewOpened.getAddress());
        fileWriter.close();
    }

}


package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.collections.ContainExactTextsCaseSensitive;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.open;


/*public class SelenideFilesTest {
    ClassLoader classLoader = getClass().getClassLoader();
    ClassLoader cl = SelenideFilesTest.class.getClassLoader();


    @Test
    void zipPdf() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("resources/PdfTest.pdf.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isEqualTo(12);

            }
        }
    }

    @Test
    void parseCsvTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("resources/CSVTest.csv.zip");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)).contains("Series_reference", "Period", "Data_value", "Suppressed", "STATUS",
                    "UNITS", "Magnitude", "Subject", "Group", "Series_title_1", "Series_title_2", "Series_title_3",
                    "Series_title_4", "Series_title_5");
        }

    }


   @Test
    void exelTest() throws Exception{
        try (InputStream is = classLoader.getResourceAsStream("resources/ExelTest.xls.zip");
             XLS xls = new XLS(is)) {
             assertThat(xls.excel
                     .getSheet(0)
                     .getRow(1)
                     .getCell(1)
                     .getStringCellValue()).contains("так");

    }
}
}
*/

public class SelenideFilesTest {
    ClassLoader classLoader = getClass().getClassLoader();
    ClassLoader slob = SelenideFilesTest.class.getClassLoader();
    ClassLoader cl = SelenideFilesTest.class.getClassLoader();


    @Test
    void testPdfFiles() throws Exception {
        InputStream stream = slob.getResourceAsStream("PdfTest.pdf");
        PDF pdf = new PDF(stream);
        Assertions.assertEquals(2, pdf.numberOfPages);

    }


    @Test
    void csvParsingTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("CSVTest.csv.zip");
             CSVReader reader = new CSVReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            List<String[]> content = reader.readAll();
            org.assertj.core.api.Assertions.assertThat(content).contains(
            assertThat(content.get(0)).contains("Series_reference", "Period", "Data_value", "Suppressed", "STATUS",
                    "UNITS", "Magnitude", "Subject", "Group", "Series_title_1", "Series_title_2", "Series_title_3",
                    "Series_title_4", "Series_title_5");
        }
    }
}





















package artoria.file;

import artoria.beans.BeanUtils;
import artoria.entity.Student;
import artoria.logging.Logger;
import artoria.logging.LoggerFactory;
import artoria.random.RandomUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static artoria.common.Constants.*;

public class CsvTest {
    private static Logger log = LoggerFactory.getLogger(CsvTest.class);
    private static Map<String, String> headerMappings = new LinkedHashMap<String, String>();
    private static File testGenerated = new File("target\\test-classes\\test_generated.csv");
    private static File testRead = new File("src\\test\\resources\\test_read.csv");
    private static List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
    private static List<Student> beanList = new ArrayList<Student>();

    static {
        for (int i = ZERO; i < TEN; i++) {
            Student student = RandomUtils.nextObject(Student.class);
            beanList.add(student);
        }
        mapList.addAll(BeanUtils.beanToMapInList(beanList));
        headerMappings.put("Name", "name");
        headerMappings.put("Sex", "sex");
        headerMappings.put("Age", "age");
        headerMappings.put("Height", "height");
        headerMappings.put("Weight", "weight");
        headerMappings.put("School Name", "schoolName");
        headerMappings.put("Student Id", "studentId");
        headerMappings.put("Graduated", "graduated");
    }

    @Test
    public void test1() throws IOException {
        Csv csv = new Csv();
        csv.readFromFile(testRead);
        log.info(NEWLINE + csv.writeToString());
        csv.setCellContent(TWO, ONE, "TEST");
        csv.setRowContent(csv.getLastRowNumber() + ONE
                , Arrays.asList("TEST1", "TEST2", "TEST3", "TEST4"));
        log.info(NEWLINE + csv.writeToString());
        log.info("RowContent: {}", csv.getRowContent(ONE));
        log.info("CellContent: {}", csv.getCellContent(TWO, ONE));
    }

    @Test
    public void test2() throws IOException {
        Csv csv = new Csv();
        csv.readFromFile(testRead);
        csv.writeToFile(testGenerated);
        log.info("Csv toString: {}{}", NEWLINE, csv);
    }

    @Test
    public void test3() throws IOException {
        Csv csv = new Csv();
        csv.setRowStartNumber(FOUR);
        csv.setColumnStartNumber(FOUR);
        csv.addHeaders(headerMappings);
        csv.fromBeanList(beanList);
        log.info(NEWLINE + csv.writeToString());
        csv.fromMapList(mapList);
        log.info(NEWLINE + csv.writeToString());
        csv.writeToFile(testGenerated);
    }

    @Test
    public void test4() throws IOException {
        Csv csv = new Csv();
        csv.setRowStartNumber(FOUR);
        csv.setColumnStartNumber(FOUR);
        csv.addHeaders(headerMappings);
        csv.readFromFile(testGenerated);
        List<Map<String, Object>> mapList = csv.toMapList();
        StringBuilder builder = new StringBuilder(NEWLINE);
        for (Map<String, Object> map : mapList) {
            builder.append(map).append(NEWLINE);
        }
        log.info(builder.toString());
        List<Student> studentList = csv.toBeanList(Student.class);
        builder.setLength(ZERO);
        builder.append(NEWLINE);
        for (Student student : studentList) {
            builder.append(BeanUtils.beanToMap(student)).append(NEWLINE);
        }
        log.info(builder.toString());
    }

}

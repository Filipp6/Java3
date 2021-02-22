import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class IOHomeWork {
    File file = new File("src/test/java/test.txt");


    @Test
    public void saveHistoryTest() {
        try (ReadWriteLinesToFile historyService = HistoryService.getInstance(file)) {
            for (int i = 0; i < 150; i++) {
                historyService.writeLineToFile("line number " + i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readLast100LInesTest() throws IOException {
        List<String> lines = null;
        try (ReadWriteLinesToFile historyService = HistoryService.getInstance(file)) {
            for (int i = 0; i < 150; i++) {
                historyService.writeLineToFile("line number " + i);
            }

            lines = historyService.getLastLines(file, 100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
    }
}

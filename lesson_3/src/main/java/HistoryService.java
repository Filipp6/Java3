import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HistoryService implements ReadWriteLinesToFile {

    private PrintWriter printWriter;

    private HistoryService(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public static HistoryService getInstance(File file) throws FileNotFoundException {
        try {
            return new HistoryService(new PrintWriter(new FileOutputStream(file, true), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void close(){
        if(printWriter != null){
            printWriter.close();
        }
    }

    @Override
    public void writeLineToFile(String line) {
        printWriter.println(line);
    }

    @Override
    public List<String> getLastLines(File file, Integer numberOfLines) {
        List<String> result = new ArrayList<>();
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, Charset.defaultCharset())) {
            for (int i = 0; i < numberOfLines; i++) {
                String line = reader.readLine();
                if (line == null) {
                    return result;
                }
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

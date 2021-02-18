import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

public class IOTests {

    @Test
    public void fileExample() throws IOException {
        File file = new File("src/test/java/test.txt");

        System.out.println("Is it here? - " + file.exists());
        System.out.println("How log are you? - " + file.length());
        System.out.println("Where are you? - " + file.getAbsolutePath());
        System.out.println("- " + file.getParent());
        System.out.println("- " + file.isFile());

        File createdFile = new File("src/test/java/createdFile.txt");
        System.out.println(createdFile.createNewFile());

        File directory = new File("src/test/java");
        File[] files = directory.listFiles();


        System.out.println(directory.getPath() + " " + Arrays.toString(files));

        System.out.println("Filter: " + directory.getPath() + " " + Arrays.toString(directory.listFiles(pathname -> pathname.getPath().contains("IO"))));

//        Files.readAllLines()
    }

    @Test
    public void IOStreamReadExample() throws IOException {
        File file = new File("src/test/java/test.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            while (inputStream.available() > 0) {
                System.out.println((char) inputStream.read());
            }
        }
    }


    @Test
    public void IOStreamReadArrExample() throws IOException {
        File file = new File("src/test/java/test.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] arr = new byte[4];
            while (inputStream.read(arr) > 0) {
                System.out.println(new String(arr));
            }
        }
    }

    @Test
    public void IOStreamWriteExample() throws Exception {
        File file = new File("src/test/java/test.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(65);
        outputStream.write(new byte[]{42, 42, 66, 76});
        outputStream.close();
    }

    @Test
    public void IOStreamReaderCharset() throws Exception {
        File file = new File("src/test/java/test.txt");
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            int i;
            while ((i = inputStreamReader.read()) != -1) {
                System.out.println((char) i);
            }
        }
    }

    @Test
    public void BufferedIOStreamReader() throws Exception {
        File file = new File("src/test/java/test.txt");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            int i;
            while ((i = inputStream.read()) != -1) {
                System.out.println((char) i);
            }
        }
    }

    @Test
    public void DataIOStreamReader() throws Exception {
        File file = new File("src/test/java/test.txt");
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file))) {
            outputStream.writeLong(64564564565L);
        }

//        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(file))){
//            System.out.println(inputStream.readLong());
//        }

    }

    @Test
    public void RAReader() throws IOException {
        File file = new File("src/test/java/test.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {


            randomAccessFile.seek(3L);
            byte[] bytes = new byte[6];
            randomAccessFile.read(bytes);

            System.out.println(new String(bytes));

            randomAccessFile.seek(0L);
            byte[] bytesAfterSeek = new byte[6];
            randomAccessFile.read(bytesAfterSeek);

            System.out.println(new String(bytesAfterSeek));
        }
    }

    @Test
    public void classSerializationExample() throws Exception {
        Person person = new Person("John", "Smith");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/test/java/person.txt"))) {
            out.writeObject(person);
        }
    }

    @Test
    public void classDeserializationExample() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/test/java/person.txt"))) {
            Person p = (Person) in.readObject();
            System.out.println(p.getFamilyName());
        }
    }

    @Test
    public void objectMapperExample() throws JsonProcessingException {
        Person person = new Person("John", "Smith", "Moscow", new Date(), 55);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }
}

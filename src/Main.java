import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        try {
            writeContactsToFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("IO Exception, fix your stuff!");
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            System.out.println("Something went wrong.!");
        }

        readAllContacts();
    }

    private static void writeContactsToFile() throws IOException {
    }

//    public static void writeContactsToFile() throws IOException {
//        String directory = "data";
//        String filename = "info.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//
//        if (! Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }
//
//    }

    public static void readAllContacts() {
        String directory = "data";
        String filename = "info.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        List<String> contacts;

        try {
            contacts = Files.readAllLines(dataFile);
            for(String contact : contacts) {
                System.out.println(contact);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
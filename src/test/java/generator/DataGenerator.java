package generator;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import dto.Account;
import dto.Folder;
import dto.Note;

import java.io.*;
import java.util.Random;

public class DataGenerator {

    private static void writeObject(Object object, String name) {
        String json = JsonWriter.objectToJson(object);
        try {
            FileOutputStream out = new FileOutputStream(name + ".json");
            out.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private static <T> T readObject(String name) {
        try {
            String json = new BufferedReader(new InputStreamReader(new FileInputStream(name))).lines().reduce("", (s1, s2) -> s1 + s2);
            return (T) JsonReader.jsonToJava(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void generateNote(String content, String filename) {
        Note note = new Note(content);
        writeObject(note, filename);
    }

    private static void generateFolder(String name, String filename) {
        Folder folder = new Folder(name);
        writeObject(folder, filename);
    }

    private static void generateAccount(String login, String password, String filename) {
        Account account = new Account(login, password);
        writeObject(account, filename);
    }

    public static Note readNote(String name) {
        return readObject(name);
    }

    public static Folder readFolder(String name) {
        return readObject(name);
    }

    public static Account readAccount(String name) {
        return readObject(name);
    }

    private static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        generateNote(randomString(), "note");
        generateNote(randomString(), "otherNote");
        generateFolder(randomString(), "folder");
        generateAccount("yajanah653@glenwoodave.com", "qwerty123", "account");
        //yajanah653@glenwoodave.com:qwerty123
    }
}

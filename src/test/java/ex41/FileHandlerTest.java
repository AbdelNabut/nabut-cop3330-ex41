package ex41;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void readPeople() throws FileNotFoundException {
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        ArrayList<String> testPeople = new ArrayList<>();
        testPeople.add("Ling, Mai");
        testPeople.add("Johnson, Jim");
        testPeople.add("Zarnecki, Sabrina");
        testPeople.add("Jones, Chris");
        testPeople.add("Jones, Aaron");
        testPeople.add("Swift, Geoffrey");
        testPeople.add("Xiong, Fong");
        ArrayList<String> people = new ArrayList<>();
        Scanner content = new Scanner(file);
        while (content.hasNextLine()) {
            String data = content.nextLine();
            people.add(data);
        }
        content.close();
        assertEquals(people, testPeople);
    }

    @Test
    void outputPeople() throws IOException {
        ArrayList<String> people = new ArrayList<>();
        people.add("Ling, Mai");
        people.add("Johnson, Jim");
        people.add("Zarnecki, Sabrina");
        people.add("Jones, Chris");
        people.add("Jones, Aaron");
        people.add("Swift, Geoffrey");
        people.add("Xiong, Fong");
        FileWriter myWriter = new FileWriter("src/main/java/ex41/output.txt");
        Collections.sort(people);
        myWriter.write("Total of " + people.size() + " names\n");
        myWriter.write("-------------------------\n");
        for(String person : people) {
            myWriter.write(person + "\n");
        }
        myWriter.close();
        String testOutput = new String(
                Files.readAllBytes(Paths.get("src/main/java/ex41/output.txt")), StandardCharsets.UTF_8);
        String actualOutput = new String(
                Files.readAllBytes(Paths.get("src/test/java/ex41/testOutput.txt")), StandardCharsets.UTF_8);
        assertEquals(testOutput, actualOutput);

    }
}
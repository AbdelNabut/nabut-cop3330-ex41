package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static ArrayList<String> readPeople(File file) throws FileNotFoundException {
        ArrayList<String> people = new ArrayList<String>();
        Scanner content = new Scanner(file);
        while (content.hasNextLine()) {
            String data = content.nextLine();
            people.add(data);
        }
        content.close();
        return people;
    }
    public static void outputPeople(ArrayList<String> people, FileWriter myWriter) throws IOException {
        myWriter.write("Total of " + people.size() + " names\n");
        myWriter.write("-------------------------\n");
        for(String person : people) {
            myWriter.write(person + "\n");
        }
        myWriter.close();

    }
}

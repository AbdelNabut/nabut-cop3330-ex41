/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class App
{

    public static void main( String[] args ) throws IOException {
        // create array to hold people
        // open input file
        // read each string from input file into people array.
        // sort array
        // output sorted array into output file.

        ArrayList<String> people = new ArrayList<String>();
        File inFile = new File("src/main/java/ex41/exercise41_input.txt");
        FileWriter myWriter = new FileWriter("src/main/java/ex41/output.txt");
        people = FileHandler.readPeople(inFile);
        Collections.sort(people);
        FileHandler.outputPeople(people, myWriter);

    }
}
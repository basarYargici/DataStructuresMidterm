package Q5;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;

/**
 * Project: DataStructuresMidterm
 * Package: Q5
 * <p>
 *
 * @author Ibrahim Basar YARGICI
 * Date 11/29/2020
 * <p>
 * Q5) Modify the program in Figure 2.19 so that if no command-line arguments are given,
 * then the standard input is used.
 * <p>
 * Working pathname is .\src\Q5\text.txt
 */
public class ListFiles {
    /**
     * This is the main function which makes use of listFile method.
     * User can give a pathname of a file as a first argument or
     * can give the name of file with usage of standard input.
     *
     * @param args args[0] used as a path of file.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args.length == 0) { // If program did not executed with command-line arguments, standard input will be used to get the pathway of file.
            System.out.print("Please enter an absolute pathname for file :");
            String filename = scanner.nextLine();
            listFile(filename);
        } else {
            for (String fileName : args)
                listFile(fileName);
        }
    }

    /**
     * This method will take the name or pathway of file as a parameter and
     * will print the text inside of this file.
     *
     * @param fileName This is a filename which shows us the name or pathway of file.
     */
    public static void listFile(String fileName) {
        System.out.println("FILE: " + fileName);

        try (Scanner fileIn = new Scanner(new FileReader(fileName))) { // This line will scan the inside of file and if
            // exception throws, will terminate the program.
            while (fileIn.hasNextLine()) {
                String oneLine = fileIn.nextLine();
                System.out.println(oneLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(-1); // This line terminates the program
        }
    }
}

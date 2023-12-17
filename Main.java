import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) throws IOException {
        String fileName = "D:\\WarAndPeace\\WarAndPeace.txt";
        char symbol = readChar();
        int count = calcCharsCount(fileName, symbol);
        System.out.println(count);


        StringBuilder reversedText = new StringBuilder();

        for (int i = fileName.length() - 1; i >= 0; i--) {

            reversedText.append(fileName.charAt(i));
        }

        try (FileWriter writer = new FileWriter("D:\\WarAndPeace\\ReversedWrite.txt", true)) {
            writer.write(String.valueOf(reversedText));
        } catch (IOException ex) {
        }

    }

    private static char readChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        return str.charAt(0);
    }

    private static int calcCharsCount(String fileName, char symbol) throws IOException {
        return (int) Files.lines(Paths.get(fileName))
                .flatMap(line -> line.chars().mapToObj(c -> (char) c))
                .filter(s -> s == symbol)
                .count();
    }
}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\WarAndPeace\\WarAndPeace.txt";
        char symbol = readChar();
        int count = calcCharsCount(fileName, symbol);
        System.out.println(count);
    }

    private static char readChar() throws IOException{
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
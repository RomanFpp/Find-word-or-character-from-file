import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Path.*;

public class Main {
    public static void main(String[] args) {
try{
        Path filePath = of("D:\\WarAndPeace\\WarAndPeace.txt");
        java.lang.String source = Files.readString(filePath);
        StringBuilder reversed = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i-- ){
            reversed.append(source.charAt(i));
        }
        System.out.print(reversed);
    }catch (OutOfMemoryError | IOException memoryError){
return;}
    }
}
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String Filename = args[0];
        Commands.delete();
        People.read();
        Foods.read();
        Sports.read();
        Commands.read(Filename);


    }
}

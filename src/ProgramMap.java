import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramMap {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.println("Enter file full path: " );
        String path = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String line = bufferedReader.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                int cout = Integer.parseInt(fields[1]);
                if (votes.containsKey(name)){
                    int votesSoFar = votes.get(name);
                    votes.put(name, cout + votesSoFar);
                }
                else {
                    votes.put(name, cout);
                }
                line = bufferedReader.readLine();
            }

            for(String key : votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
            }

        }
        catch (IOException ioException){
            System.out.println("Error: " + ioException.getMessage());
        }

        scanner.close();
    }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Start {

    public static void main(String[] args) throws Exception{
Path path = Paths.get(args[0]);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
try{

  

        FileReader fileReader = new FileReader(path.toFile());
        BufferedReader reader = new BufferedReader(fileReader);


        String line = null;
       while ((line = reader.readLine()) != null){
           String[] line1 = line.split(" ");

           for (String add:line1) {
               if (map.containsKey(add)){

                   map.put(add, map.get(add) + 1);

               }
               else {
                   map.put(add, 1);
               }
               break;
           }

       }
        reader.close();

    map.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(System.out::println); // или любой другой конечный метод
}
catch (Exception e){
    e.printStackTrace();
}

    }
}

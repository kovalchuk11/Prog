package u2Home.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadGson {

    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\I\\Documents\\json.txt";
        String result = readFile(path);


        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result, JSON.class);

//        for (Adress rate : json.adress) {
//            System.out.println(rate.country + "=" + rate.city);
//        }

        System.out.println("JSON: \n\t" + json.toString());
    }

    public static String readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally{
            br.close();
        }
    }

}
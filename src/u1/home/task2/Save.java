package u1.home.task2;

import java.io.FileWriter;
import java.io.IOException;

public class Save {
    public static void main(String[] args) {

    }
    public static void saveTo(String src) {
        try {
            FileWriter writer = new FileWriter(src, false);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}

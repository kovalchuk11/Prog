package u1.home.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    static Class<?> cls = Clazz1.class;
    static String path = "C:\\SomeDir\\notes4.txt";
    public static StringBuilder sb;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        start();
    }

    public static void write() throws NoSuchFieldException, IllegalAccessException {
        sb = new StringBuilder();
        Field[] publicFields = cls.getDeclaredFields();
        Clazz1 obj = new Clazz1();
        for (Field fil : publicFields) {
            if (fil.isAnnotationPresent(Save.class)) {
                String f = fil.getName();
                Field fiel = cls.getDeclaredField(f);
                sb.append(fil.getName())
                        .append(":")
                        .append(fiel.get(obj) + "\r\n");
            }
        }

        System.out.println("в файл записанны эти  значения из класса\n" + sb);

        try (FileWriter writer = new FileWriter(path, false)) {
            // запись всей строки
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "у тебя ошибка 2");
        }
        start();
    }

    public static void read(String path) throws FileNotFoundException {
        Clazz1 obj2 = new Clazz1();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String f = scanner.nextLine();
            String[] words = f.split(":");
            String one = words[0];
            String two = words[1];
            try {
                Field field = cls.getDeclaredField(one);
                field.setAccessible(true);
                System.out.println("Значение поля: " + field.get(obj2));
                field.set(obj2, two);
                System.out.println("Записалось значением с файла: " + field.get(obj2));
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " у тебя ошибка 1");
            }
            System.out.println("==");
        }

        start();
    }
    public static void start(){
    sb = new StringBuilder();
        sb.append("=========================\n")
                .append("Меню\n")
                .append("1 - сериализировать\n")
                .append("2 - десириализировать\n")
                .append("=========================");
        System.out.println(sb);
        switch (scan.nextInt()){
            case 1:
                try {
                    write();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    read(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("нет такого пунтка");
                start();
                break;
        }
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Insan> humans= new ArrayList();
        humans.add(new Insan("Elnurl", "Eliyev", (short) 35));
        humans.add(new Insan("Elnurf", "Memmedov", (short) 26));
        humans.add(new Insan("Elnurm", "Kazimov", (short) 58));
        humans.add(new Insan("Elnura", "Huseynov", (short) 41));
        humans.add(new Insan("Elnure", "Quliyev", (short) 29));
        humans.add(new Insan("Elnurj", "Elesgerov", (short) 12));

        List<Insan> sortedList = humans.stream().sorted(Comparator.comparing(Insan::getName)).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println("-------------------------------");

        List<Insan> sortedList2 = humans.stream().sorted(Comparator.comparing(Insan::getSurname)).collect(Collectors.toList());
        sortedList2.forEach(System.out::println);
        System.out.println("------------------------------");

        List<Insan> sortedList3 = humans.stream().sorted(Comparator.comparingInt(Insan::getAge)).collect(Collectors.toList());
        sortedList3.forEach(System.out::println);
        System.out.println("------------------------------");

        List<Insan> sortedList4 = humans.stream().sorted(Comparator.comparingInt(Insan::getAge).reversed()).collect(Collectors.toList());
        sortedList4.forEach(System.out::println);
        System.out.println("------------------------------");

        double averageAge = humans.stream().collect(Collectors.averagingInt(Insan::getAge));
        System.out.println(averageAge);

        Insan old = humans.stream().max(Comparator.comparing(Insan::getAge)).get();
        System.out.println(old);

        Insan young = humans.stream().min(Comparator.comparing(Insan::getAge)).get();
        System.out.println(young);

        int minAge = humans.stream().mapToInt(Insan::getAge).min().orElseThrow();
        System.out.println(minAge);

        File file = new File("Humans.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i<sortedList3.size(); i++){
                writer.write(String.valueOf(sortedList3.get(i))+"\n");
            }
            writer.close();
            System.out.println("Melumatlar fayla yazildi");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
                String[] data = (scanner.nextLine()).split(" ");
                Insan insan = new Insan(data[0], data[1], Short.parseShort(data[2]));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

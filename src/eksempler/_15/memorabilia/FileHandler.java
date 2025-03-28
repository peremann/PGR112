package eksempler._15.memorabilia;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileHandler {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<Memorabilia> readFromFile() throws FileNotFoundException {
        Set<Memorabilia> memorabiliaToReturn = new HashSet<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String type = scanner.nextLine();
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            Year year = Year.parse(scanner.nextLine());
            String celeb = scanner.nextLine();
            String description = scanner.nextLine();
            int askingPrice = Integer.parseInt(scanner.nextLine());
            switch (type){
                case "Skateboard" -> {
                    String skateboardType = scanner.nextLine();
                    Skateboard sb = new Skateboard(id, name, year, celeb, description, askingPrice, skateboardType);
                    memorabiliaToReturn.add(sb);
                }
                case "Poster" -> {
                    int width = Integer.parseInt(scanner.nextLine());
                    int height = Integer.parseInt(scanner.nextLine());
                    Poster poster = new Poster(id, name, year, celeb, description, askingPrice, width, height);
                    memorabiliaToReturn.add(poster);
                }
                case "SportsEquipment" -> {
                    String sport = scanner.nextLine();
                    SportEquipment se = new SportEquipment(id, name, year, celeb, description, askingPrice, sport);
                    memorabiliaToReturn.add(se);
                }
                default -> {
                    System.out.println("Hm, something weird happened");
                }

            }
            scanner.nextLine(); // Swallowing ---
        }
        return memorabiliaToReturn;
    }


}

package eksempler._09.memorabilia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Memorabilia> readFromFile() throws FileNotFoundException {
        ArrayList<Memorabilia> memorabiliaToReturn = new ArrayList<>();
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
                    Skateboard sb = new Skateboard();
                    sb.setId(id);
                    sb.setName(name);
                    sb.setDescription(description);
                    sb.setCelebrityInvolved(celeb);
                    sb.setAskingPrice(askingPrice);
                    sb.setYear(year);
                    sb.setSkateboardType(skateboardType);
                    memorabiliaToReturn.add(sb);
                }
                case "Poster" -> {
                    int width = Integer.parseInt(scanner.nextLine());
                    int height = Integer.parseInt(scanner.nextLine());
                    Poster poster = new Poster();
                    poster.setId(id);
                    poster.setName(name);
                    poster.setDescription(description);
                    poster.setCelebrityInvolved(celeb);
                    poster.setAskingPrice(askingPrice);
                    poster.setYear(year);
                    poster.setWidth(width);
                    poster.setHeight(height);
                    memorabiliaToReturn.add(poster);
                }
                case "SportsEquipment" -> {
                    String sport = scanner.nextLine();
                    SportEquipment se = new SportEquipment();
                    se.setId(id);
                    se.setName(name);
                    se.setDescription(description);
                    se.setCelebrityInvolved(celeb);
                    se.setAskingPrice(askingPrice);
                    se.setYear(year);
                    se.setSport(sport);
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

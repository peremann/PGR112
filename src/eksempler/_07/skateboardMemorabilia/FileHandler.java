package eksempler._07.skateboardMemorabilia;

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

    public ArrayList<Skateboard> readFromFile() throws FileNotFoundException {
        ArrayList<Skateboard> boardsToReturn = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            int id = Integer.parseInt(scanner.nextLine());
            String model = scanner.nextLine();
            Year year = Year.parse(scanner.nextLine());
            String celeb = scanner.nextLine();
            String description = scanner.nextLine();
            int askingPrice = Integer.parseInt(scanner.nextLine());
            scanner.nextLine(); // Swallowing ---
            Skateboard skateboard = new Skateboard();
            skateboard.setId(id);
            skateboard.setModel(model);
            skateboard.setYear(year);
            skateboard.setCelebrityInvolved(celeb);
            skateboard.setDescription(description);
            skateboard.setAskingPrice(askingPrice);
            boardsToReturn.add(skateboard);
        }
        return boardsToReturn;
    }

    public void writeSkateboardsToFile(ArrayList<Skateboard> skateboards) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Skateboard skateboard : skateboards) {
                fileWriter.write(skateboard.getId() + "\n");
                fileWriter.write(skateboard.getModel() + "\n");
                fileWriter.write(skateboard.getYear() + "\n");
                fileWriter.write(skateboard.getCelebrityInvolved() + "\n");
                fileWriter.write(skateboard.getDescription() + "\n");
                fileWriter.write(skateboard.getAskingPrice() + "\n");
                fileWriter.write("---\n");
            }
        }
    }
}

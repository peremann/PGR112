package eksempler._15.memorabilia;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Set;

public class MemorabiliaImporter {
    private FileHandler fileHandler;
    private Inventory inventory;

    public MemorabiliaImporter() {
        this.fileHandler = new FileHandler();
        fileHandler.setFileName("files/memorabilia.txt");
        this.inventory = new Inventory();
    }

    public void importMemorabilia() throws FileNotFoundException, SQLException {
        Set<Memorabilia> allMemorabilia = fileHandler.readFromFile();
        inventory.insertMemorabilia(allMemorabilia);
    }
}

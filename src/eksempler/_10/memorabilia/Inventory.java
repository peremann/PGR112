package eksempler._10.memorabilia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Inventory {
    private FileHandler fileHandler;
    private ArrayList<Memorabilia> allBoards;

    public ArrayList<Memorabilia> getAllMemorabilia() {
        return allBoards;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void retrieveMemorabiliaFromFile() throws FileNotFoundException {
        allBoards = fileHandler.readFromFile();
    }

}

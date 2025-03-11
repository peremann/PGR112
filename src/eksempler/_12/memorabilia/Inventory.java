package eksempler._12.memorabilia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

public class Inventory {
    private FileHandler fileHandler;
    private Set<Memorabilia> allBoards;

    public Set<Memorabilia> getAllMemorabilia() {
        return allBoards;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void retrieveMemorabiliaFromFile() throws FileNotFoundException {
        allBoards = fileHandler.readFromFile();
    }

}

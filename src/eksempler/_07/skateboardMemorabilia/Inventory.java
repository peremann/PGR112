package eksempler._07.skateboardMemorabilia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {
    private FileHandler fileHandler;
    private ArrayList<Skateboard> allBoards;

    public ArrayList<Skateboard> getAllBoards() {
        return allBoards;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public ArrayList<Skateboard> getBoardsWithinBudget(int budget) {
        ArrayList<Skateboard> boardsWithinBudget = new ArrayList<>();
        for (Skateboard board : allBoards) {
            if(board.getAskingPrice()<=budget){
                boardsWithinBudget.add(board);
            }
        }
        return boardsWithinBudget;
    }

    public ArrayList<Skateboard> getBoardsByCelebrity(String celebrity) {
        ArrayList<Skateboard> boardsByCelebrity = new ArrayList<>();
        for (Skateboard board : allBoards) {
            if(board.getCelebrityInvolved().equalsIgnoreCase(celebrity)){
                boardsByCelebrity.add(board);
            }
        }
        return boardsByCelebrity;
    }

    public void addSkateboard(Skateboard skateboard){
        if(skateboard.getId()==0){
            skateboard.setId(nextId());
        }
        allBoards.add(skateboard);
    }

    private int nextId(){
        int currentMaxId = 0;
        for (Skateboard board : allBoards) {
            if(board.getId()>currentMaxId){
                currentMaxId = board.getId();
            }
        }
        return currentMaxId+1;
    }

    public void retrieveSkateboardsFromFile() throws FileNotFoundException {
        allBoards = fileHandler.readFromFile();
    }

    public void storeSkateboardsOnFile() throws IOException {
        fileHandler.writeSkateboardsToFile(allBoards);
    }
}

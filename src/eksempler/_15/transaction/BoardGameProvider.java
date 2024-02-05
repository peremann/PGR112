package eksempler._15.transaction;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static eksempler._14.PropertiesProvider.PROPS;

public class BoardGameProvider {
    private static final String ADD_BOARDGAME_SQL = "INSERT INTO Brettspill VALUES(?,?,?,?,?,?,?)";
    private final MysqlDataSource boardGameDS;

    public BoardGameProvider(){
        boardGameDS = new MysqlDataSource();
        boardGameDS.setServerName(PROPS.getProperty("host"));
        boardGameDS.setPortNumber(Integer.parseInt(PROPS.getProperty("port")));
        boardGameDS.setDatabaseName(PROPS.getProperty("db_name"));
        boardGameDS.setUser(PROPS.getProperty("uname"));
        boardGameDS.setPassword(PROPS.getProperty("pwd"));
    }

    public void addBoardGames(List<BoardGame> newBoardGames) throws SQLException {
        try (Connection con = boardGameDS.getConnection();
             PreparedStatement statement = con.prepareStatement(ADD_BOARDGAME_SQL);
        ) {
            con.setAutoCommit(false);
            try{
                for (BoardGame newBoardGame : newBoardGames) {
                    statement.setInt(1, newBoardGame.id());
                    statement.setString(2, newBoardGame.name());
                    statement.setString(3, newBoardGame.type());
                    statement.setInt(4, newBoardGame.nrOfPlayers());
                    statement.setInt(5, newBoardGame.minutes());
                    statement.setInt(6, newBoardGame.ageLimit());
                    statement.setString(7, newBoardGame.imageUrl());
                    statement.executeUpdate();
                }
                con.commit();
            } catch(SQLException e){
                System.out.println("Exception caught. Rolling back transaction");
                con.rollback();
                throw e;
            }
        }
    }
}

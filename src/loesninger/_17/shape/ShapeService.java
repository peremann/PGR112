package loesninger._17.shape;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.awt.*;
import java.sql.*;

public class ShapeService {
    private final MysqlDataSource shapesDS;

    private static final String CALL_ADD_CIRCLE = "{call InsertCircle(?,?,?,?,?,?)}";

    public ShapeService() {
        shapesDS = new MysqlDataSource();
        shapesDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        shapesDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        shapesDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        shapesDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        shapesDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public Circle addCircle(Color color, boolean filled, double radius, MovablePoint center) throws SQLException {
        try (Connection conn = shapesDS.getConnection();
             CallableStatement stmt = conn.prepareCall(CALL_ADD_CIRCLE)
        ) {
            stmt.setString(1, color.toString());
            stmt.setBoolean(2, filled);
            stmt.setDouble(3, radius);
            stmt.setDouble(4, center.getX());
            stmt.setDouble(5, center.getY());
            stmt.registerOutParameter(6, Types.INTEGER);
            stmt.executeUpdate();
            return new Circle(stmt.getInt(6), color, filled, radius, center);
        }

    }
}

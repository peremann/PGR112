package eksempler._16.employee;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProvider {
    private static final String GET_ALL_EMPLOYEES_SQL = "{call GetAllEmployeesWithType()}";
    private static final String GET_ALL_REGULAR_EMPLOYEES_SQL = "{call GetAllRegularEmployees()}";
    private static final String ADD_REGULAR_EMPLOYEE_SQL = "{call AddRegularEmployee(?,?,?,?)}";
    private MysqlDataSource ds;

    public EmployeeProvider() {
        ds = new MysqlDataSource();
        ds.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        ds.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        ds.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        ds.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        ds.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public List<Employee> getAllEmployees() throws SQLException {
        try (Connection con = ds.getConnection();
             CallableStatement statement = con.prepareCall(GET_ALL_EMPLOYEES_SQL);
             ResultSet rs = statement.executeQuery();
        ) {
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                switch (type) {
                    case "Regular" ->
                            employees.add(new RegularEmployee(id, name, rs.getFloat("RegularSalary"), rs.getInt("RegularBonus")));
                    case "Contract" ->
                            employees.add(new ContractEmployee(id, name, rs.getFloat("ContractPayPerHour"), rs.getString("ContractPeriod")));
                    default -> throw new SQLException("Unknown employee type found");
                }
            }
            return employees;
        }
    }

    public List<RegularEmployee> getAllRegularEmployees() throws SQLException {
        try (Connection con = ds.getConnection();
             CallableStatement statement = con.prepareCall(GET_ALL_REGULAR_EMPLOYEES_SQL);
             ResultSet rs = statement.executeQuery();
        ) {
            List<RegularEmployee> employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float salary = rs.getFloat("salary");
                int bonus = rs.getInt("bonus");
                employees.add(new RegularEmployee(id, name, salary, bonus));
            }
            return employees;
        }
    }

    public RegularEmployee addRegularEmployee(String name, float salary, int bonus) throws SQLException {
        try (Connection con = ds.getConnection();
             CallableStatement statement = con.prepareCall(ADD_REGULAR_EMPLOYEE_SQL)) {
            statement.setString(1, name);
            statement.setFloat(2, salary);
            statement.setInt(3, bonus);
            statement.registerOutParameter(4, Types.INTEGER);
            statement.executeUpdate();
            return new RegularEmployee(statement.getInt(4), name, salary, bonus);
        }
    }
}


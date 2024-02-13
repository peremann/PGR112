package eksempler._16.employee;

import java.util.Objects;

public class RegularEmployee extends Employee {
    private float salary;
    private int bonus;

    public RegularEmployee(int id, String name, float salary, int bonus) {
        super(id, name);
        this.salary = salary;
        this.bonus = bonus;
    }

    public RegularEmployee(int id, String name) {
        super(id, name);
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegularEmployee that = (RegularEmployee) o;
        return Float.compare(salary, that.salary) == 0 && bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, bonus);
    }

    @Override
    public String toString() {
        return "RegularEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                "} " + super.toString();
    }
}

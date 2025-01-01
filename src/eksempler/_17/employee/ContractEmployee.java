package eksempler._17.employee;

import java.util.Objects;

public class ContractEmployee extends Employee{
    private float payPerHour;
    private String contractPeriod;

    public ContractEmployee(int id, String name, float payPerHour, String contractPeriod) {
        super(id, name);
        this.payPerHour = payPerHour;
        this.contractPeriod = contractPeriod;
    }

    public ContractEmployee(int id, String name) {
        super(id, name);
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContractEmployee that = (ContractEmployee) o;
        return Float.compare(payPerHour, that.payPerHour) == 0 && Objects.equals(contractPeriod, that.contractPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payPerHour, contractPeriod);
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "payPerHour=" + payPerHour +
                ", contractPeriod='" + contractPeriod + '\'' +
                "} " + super.toString();
    }
}

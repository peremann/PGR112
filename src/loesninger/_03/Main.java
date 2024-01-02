package loesninger._03;

public class Main {
    public static void main(String[] args) {
        SillyProgram sp = new SillyProgram();
        sp.onePersonLiving();
        sp.allPersonsLiving();
        sp.names[0] = "Agnete";
        sp.allPersonsLiving();
        sp.printNumberOfCharsInStreetNames();
    }
}

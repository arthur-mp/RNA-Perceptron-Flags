package utils;

public class DataBase {
    private Double[] x;
    private Double[] y;

    public DataBase() {
        this.x = new Double[28];
        this.y = new Double[8];
    }

    public DataBase(Double[] x, Double[] y) {
        this.x = x;
        this.y = y;
    }

    public Double[] getX() {
        return x;
    }

    public Double[] getY() {
        return y;
    }
}

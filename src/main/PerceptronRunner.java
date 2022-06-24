package main;

import utils.DataBase;
import utils.GenerateDataBase;

public class PerceptronRunner {

    public static void main(String[] args) throws Exception {

        GenerateDataBase generateDataBase = new GenerateDataBase();

        /*
         * Enter file name
         * Files are in 'Date'
         */
        DataBase[] dataBase = generateDataBase.generateDataBase("and");

        Perceptron p = new Perceptron(dataBase[0].getX().length, dataBase[0].getY().length, 0.1);

        double erroEp = 0;
        double erroAm = 0;

        for (int e = 0; e < 10000; e++) {
            erroEp = 0;

            for (int a = 0; a < dataBase.length; a++) {
                Double[] x = dataBase[a].getX();
                Double[] y = dataBase[a].getY();
                Double[] out = p.learn(x, y);

                for (int j = 0; j < out.length; j++) {
                    erroAm += Math.abs(y[j] - out[j]);
                }

                erroEp += erroAm;
                erroAm = 0;
            }

            System.out.println("Época: " + (e + 1) + " - erro: " + erroEp);
        }

        Double[][] w = p.getW();
        System.out.println("-----------------------------------------");
        for (int j = 0; j < w[0].length; j++) {
            System.out.printf("Neuronio: %d\n", j + 1);
            for (int i = 0; i < w.length; i++) {
                System.out.printf("Peso %d: %2f\n", i, w[i][j]);
            }
            System.out.println("-----------------------------------------");
        }
    }
}

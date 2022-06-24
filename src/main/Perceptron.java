package main;

import java.util.Random;

import models.FunctionActivation;

public class Perceptron {

    private Double ni;
    private int amountInput;
    private int amountOutput;
    private Double[][] w;

    private final static Double Range_Max = 0.03;
    private final static Double Range_Min = -0.03;

    public Perceptron(int amountInput, int amountOutput, Double ni) {
        this.ni = ni;
        this.amountInput = amountInput;
        this.amountOutput = amountOutput;
        w = new Double[amountInput + 1][amountOutput];
        generateRandoW();
    }

    private void generateRandoW() {
        Random random = new Random();
        for (int i = 0; i < amountInput + 1; i++) {
            for (int j = 0; j < amountOutput; j++) {
                this.w[i][j] = random.nextDouble(Range_Max * 2) + Range_Min;
            }
        }
    }

    public Double[] learn(Double[] xIn, Double[] y) {
        Double[] x = new Double[xIn.length + 1];
        Double[] out = new Double[y.length];

        for (int i = 0; i < xIn.length; i++) {
            x[i] = xIn[i];
        }
        x[x.length - 1] = 1.0;

        for (int j = 0; j < out.length; j++) {
            Double u = 0.0;

            for (int i = 0; i < x.length; i++) {
                u += x[i] * w[i][j];
            }

            out[j] = FunctionActivation.sigmoidal(u);
        }

        for (int j = 0; j < out.length; j++) {
            for (int i = 0; i < x.length; i++) {
                w[i][j] += ni * (y[j] - out[j]) * x[i];
            }
        }

        return out;
    }

    public Double[][] getW() {
        return w;
    }
}

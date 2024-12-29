package ai;

import java.util.Random;

public class NeuralNetwork {
    private int inputSize;
    private int outputSize;
    private double[][] weights; // Simple weight matrix
    private double[] biases;
    private Random random;

    public NeuralNetwork(int inputSize, int outputSize) {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
        this.weights = new double[inputSize][outputSize];
        this.biases = new double[outputSize];
        this.random = new Random();

        initializeWeights();
    }

    private void initializeWeights() {
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < outputSize; j++) {
                weights[i][j] = random.nextDouble() - 0.5; // Initialize weights between -0.5 and 0.5
            }
        }
        for (int i = 0; i < outputSize; i++) {
            biases[i] = random.nextDouble() - 0.5;
        }
    }

    public double[] predict(int[] state) {
        double[] outputs = new double[outputSize];
        for (int i = 0; i < outputSize; i++) {
            outputs[i] = biases[i];
            for (int j = 0; j < inputSize; j++) {
                outputs[i] += state[j] * weights[j][i];
            }
        }
        return softmax(outputs);
    }

    private double[] softmax(double[] outputs) {
        double sum = 0.0;
        for (double value : outputs) {
            sum += Math.exp(value);
        }
        for (int i = 0; i < outputs.length; i++) {
            outputs[i] = Math.exp(outputs[i]) / sum;
        }
        return outputs;
    }

    public void update(int[] state, double[] target) {
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                weights[j][i] += 0.01 * (target[i] - predict(state)[i]) * state[j]; // Simple gradient update
            }
            biases[i] += 0.01 * (target[i] - predict(state)[i]);
        }
    }
}

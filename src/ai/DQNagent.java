package ai;

import java.util.*;

public class DQNagent {
    // private int stateSize;
    private int actionSize;
    private double gamma;
    private double epsilon;
    private double epsilonDecay;
    private double epsilonMin;
    private NeuralNetwork model;
    private List<Experience> memory;

    public DQNagent(int stateSize, int actionSize, double gamma, double epsilon, double epsilonDecay,
            double epsilonMin) {
        // this.stateSize = stateSize;
        this.actionSize = actionSize;
        this.gamma = gamma;
        this.epsilon = epsilon;
        this.epsilonDecay = epsilonDecay;
        this.epsilonMin = epsilonMin;
        this.model = new NeuralNetwork(stateSize, actionSize);
        this.memory = new ArrayList<>();
    }

    public int act(int[] state) {
        if (Math.random() < epsilon) {
            return new Random().nextInt(actionSize); // Random action (Exploration)
        } else {
            double[] qValues = model.predict(state);
            int bestAction = 0;
            double maxQValue = qValues[0];

            // Loop through Q-values to find the best action
            for (int i = 1; i < qValues.length; i++) {
                if (qValues[i] > maxQValue) {
                    maxQValue = qValues[i];
                    bestAction = i;
                }
            }

            return bestAction; // Best action (Exploitation)
        }
    }

    public void remember(int[] state, int action, int reward, int[] nextState, boolean done) {
        memory.add(new Experience(state, action, reward, nextState, done));
    }

    public void replay(int batchSize) {
        if (memory.size() < batchSize)
            return;

        List<Experience> batch = new ArrayList<>(memory.subList(0, batchSize));
        for (Experience exp : batch) {
            double[] qValues = model.predict(exp.state);
            double target = exp.reward;
            if (!exp.done) {
                double[] nextQValues = model.predict(exp.nextState);
                target += gamma * Arrays.stream(nextQValues).max().getAsDouble();
            }
            qValues[exp.action] = target;
            model.update(exp.state, qValues);
        }

        if (epsilon > epsilonMin) {
            epsilon *= epsilonDecay;
        }
    }

    private static class Experience {
        int[] state;
        int action;
        int reward;
        int[] nextState;
        boolean done;

        public Experience(int[] state, int action, int reward, int[] nextState, boolean done) {
            this.state = state;
            this.action = action;
            this.reward = reward;
            this.nextState = nextState;
            this.done = done;
        }
    }
}

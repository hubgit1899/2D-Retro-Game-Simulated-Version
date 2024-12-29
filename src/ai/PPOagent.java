package ai;

public class PPOagent {
    private NeuralNetwork policyNetwork;
    private NeuralNetwork valueNetwork;
    private double gamma = 0.99;
    private double epsilon = 0.2;

    public PPOagent(int stateSize, int actionSize) {
        this.policyNetwork = new NeuralNetwork(stateSize, actionSize);
        this.valueNetwork = new NeuralNetwork(stateSize, 1);
    }

    public int act(int[] state) {
        double[] probabilities = policyNetwork.predict(state);
        double randomValue = Math.random();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue < cumulativeProbability) {
                return i;
            }
        }
        return probabilities.length - 1;
    }

    public void train(int[] state, int action, int reward, int[] nextState, boolean done) {
        double[] policy = policyNetwork.predict(state);
        double oldProb = policy[action];

        double advantage = reward + (done ? 0 : gamma * valueNetwork.predict(nextState)[0])
                - valueNetwork.predict(state)[0];
        double ratio = policy[action] / oldProb;

        double clippedAdvantage = Math.min(ratio * advantage, clip(ratio, 1 - epsilon, 1 + epsilon) * advantage);
        policy[action] += 0.01 * clippedAdvantage;
        policyNetwork.update(state, policy);

        double valueTarget = reward + (done ? 0 : gamma * valueNetwork.predict(nextState)[0]);
        valueNetwork.update(state, new double[] { valueTarget });
    }

    /**
     * Custom clipping function to restrict a value within a range.
     *
     * @param value The value to clip.
     * @param min   The minimum allowed value.
     * @param max   The maximum allowed value.
     * @return The clipped value.
     */
    private double clip(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }
}

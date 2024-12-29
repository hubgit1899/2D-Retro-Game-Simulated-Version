package ai;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameEnvironment env = new GameEnvironment(5, new int[] { 0, 0 }, List.of(new int[] { 2, 2 }),
                List.of(new int[] { 1, 1 }), new int[] { 4, 4 });

        PPOagent ppo = new PPOagent(10, 4);
        DQNagent dqn = new DQNagent(10, 4, 0.95, 1.0, 0.995, 0.01);

        for (int i = 0; i < 1000; i++) {
            int[] state = env.reset();
            boolean done = false;
            while (!done) {
                int action = ppo.act(state);
                GameEnvironment.Result result = env.step(action);
                ppo.train(state, action, result.reward, result.nextState, result.done);
                dqn.remember(state, action, result.reward, result.nextState, result.done);
                state = result.nextState;
                done = result.done;
            }
            dqn.replay(32);
        }
    }
}

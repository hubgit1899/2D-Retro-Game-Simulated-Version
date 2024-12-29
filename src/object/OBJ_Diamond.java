package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Diamond extends Entity {

    GamePanel gp;
    public static final String objName = "Legendary Diamond";

    public OBJ_Diamond(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = objName;
        value = 500;
        down1 = setup("/objects/coin_bronze", gp.tileSize, gp.tileSize);

    }

    public boolean use(Entity entity) {

        gp.playSE(1);
        gp.ui.addMessage("Coin +" + value);
        gp.player.coin += value;
        return true;
    }

}
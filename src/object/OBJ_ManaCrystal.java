package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_ManaCrystal extends Entity {

    GamePanel gp;
    public static final String objName = "Mana Crystal";

    public OBJ_ManaCrystal(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = objName;
        value = 1;
        down1 = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/manacrystal_blank", gp.tileSize, gp.tileSize);
        price = 10;
    }

    @Override
    public boolean use(Entity entity) {
        gp.playSE(2);
        gp.ui.addMessage("Mana +" + value);
        gp.player.mana += value;
        return true;
    }
}

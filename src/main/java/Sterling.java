import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Sterling
* @author sralph3
* @version 1
*/
public class Sterling extends SilverType {
    private int maxLevel = 200;
    /**
     * Constructor
     * @param x The X position of Sterling
     * @param y The Y position of Sterling
     * @param bounds The bounding Rectangle
     */
    public Sterling(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/pikachu.png"));
    }

    /**
     * @return if the pokemon is old or not
     */
    public boolean isOld() {
        return (this.getLevel() > this.maxLevel);
    }

    /**
     * @return a boolean representing if one pokemon can reproduce with another
     * @param otherPokemon The other pokemon
     */
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        return (otherPokemon instanceof Sterling);
    }

    /**
     * Returns a new pokemon of same type in same location if reproducing
     * @return a new pokemon
     * @param otherPokemon The other pokemon
     */
    public Sterling reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)) {
            Random ran = new Random();
            if (ran.nextDouble() > 0.99) {
                return (new Sterling(this.getXPos(), this.getYPos()
                    , this.getBounds()));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @return a boolean representing if one pokemon can harm the other
     * @param otherPokemon The other pokemon
     */
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        Random ran = new Random();
        double adjuster = super.adjuster(otherPokemon);
        if (otherPokemon instanceof Sterling) {
            adjuster +=  -0.12;
        }
        double compare = ran.nextDouble();
        return (compare < adjuster);
    }
}

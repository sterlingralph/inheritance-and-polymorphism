import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Rapidash
* @author sralph3
* @version 1
*/
public class Rapidash extends FireType {
    private int maxLevel = 175;

    /**
     * Constructor
     * @param x The X position of Rapidash
     * @param y The Y position of Rapidash
     * @param bounds The bounding Rectangle
     */
    public Rapidash(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/rapidash.png"));
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
        return (otherPokemon instanceof Rapidash);
    }

    /**
     * Returns a new pokemon of same type in same location if reproducing
     * @return a new pokemon
     * @param otherPokemon The other pokemon
     */
    public Rapidash reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)) {
            Random ran = new Random();
            if (ran.nextDouble() > 0.98) {
                return (new Rapidash(this.getXPos(), this.getYPos()
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
        double chance;
        if (otherPokemon instanceof FireType) {
            if (this.getLevel() > otherPokemon.getLevel()) {
                chance = 0.9;
            } else {
                chance = 0.12;
            }
        } else {
            chance = adjuster;
        }
        double compare = ran.nextDouble();
        return (compare < chance);
    }
}

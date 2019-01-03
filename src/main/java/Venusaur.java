import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Venusaur
* @author sralph3
* @version 1
*/
public class Venusaur extends GrassType {
    private int maxLevel = 150;

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Venusaur(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/venusaur.png"));
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
        return (otherPokemon instanceof Venusaur);
    }

    /**
     * Returns a new pokemon of same type in same location if reproducing
     * @return a new pokemon
     * @param otherPokemon The other pokemon
     */
    public Venusaur reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)) {
            Random ran = new Random();
            if (ran.nextDouble() > 0.99) {
                return (new Venusaur(this.getXPos(), this.getYPos()
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
            chance = adjuster + 0.10;
        }
        if (otherPokemon instanceof Poliwhirl) {
            chance = 0.7;
        } else {
            chance = adjuster;
        }
        double compare = ran.nextDouble();
        return (compare < chance);
    }
}

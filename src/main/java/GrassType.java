import java.awt.Rectangle;
import java.util.Random;
/**
 * A grass type pokemon
 *
 * @author sralph3
 * @version 1
 */

public abstract class GrassType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    /**
     * moves the pokemon by a random amount, taking into account it's region
     */
    public void move() {
        Random ran = new Random();
        Rectangle rect = this.getBounds();
        boolean isGreen = ((this.getXPos() < (rect.width) / 2)
            && (this.getYPos() < (rect.height) / 2));
        int newX;
        int newY;
        if (this.getXPos() + 90 > rect.width) {
            this.setXPos(this.getXPos() - 90);
        } else if (this.getYPos() + 90 > rect.height) {
            this.setYPos(this.getYPos() - 90);
        }
        if (isGreen) {
            newX = this.getXPos() + 3 * (ran.nextInt(51) - 25);
            newY = this.getYPos() + 3 * (ran.nextInt(51) - 25);
        } else {
            newX = this.getXPos() + (ran.nextInt(21) - 10);
            newY = this.getYPos() + (ran.nextInt(21) - 10);
        }

        if (newX + 90 < rect.width && newX > 0) {
            this.setXPos(newX);
        }
        if (newY + 90 < rect.height && newY > 0) {
            this.setYPos(newY);
        }
        this.level += 1;
        this.health += -1;
    }

    /**
     * Return 1 for normal chance, less than 1 for lower, >1 for higher chance
     * @return a double representing an adjustment amount for damaging others
     * @param other The other pokemon which to adjust to
     */
    protected double adjuster(Pokemon other) {
        if (other instanceof WaterType) {
            return 0.75;
        } else if (other instanceof FireType) {
            return 0.25;
        } else {
            return 0.5;
        }
    }

    /**
     * @return a boolean representing if one pokemon can harm the other
     * @param otherPokemon The other pokemon
     */
    public abstract boolean canHarmPokemon(Pokemon otherPokemon);

    /**
     * @return a boolean representing if one pokemon can reproduce with another
     * @param otherPokemon The other pokemon
     */
    public abstract boolean canReproduceWithPokemon(Pokemon otherPokemon);

    /**
     * Returns a new pokemon of same type in same location if reproducing
     * @return a new pokemon
     * @param otherPokemon The other pokemon
     */
    public abstract Pokemon reproduceWithPokemon(Pokemon otherPokemon);

    /**
     * @return if the pokemon is old or not
     */
    public abstract boolean isOld();
}

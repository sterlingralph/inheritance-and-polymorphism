import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;
/**
 * The abstract Pokemon for the PokeBattle Simulation
 *
 * @author sralph3
 * @version 1
 */

public abstract class Pokemon {

    private Rectangle bounds;
    private int xPos;
    private int yPos;
    protected int level = 0;
    protected int health = 100;
    private ImageIcon image;

    /**
     * Constructor
     *
     * Represents a Pokemon in the PokeWorld. Each Pokemon
     * has a location in the world and attributes which help
     * it reproduce and thrive.
     * @param xPos The X position of this Pokemon
     * @param yPos The Y position of this Pokemon
     * @param bounds The boundaries of the PokeWorld where
     *               the Pokemon can exist
     */
    public Pokemon(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
    }

    /**
     * moves the pokemon by a random amount, taking into account it's region
     */
    public abstract void move();

    /**
     * @return if the pokemon collides with another
     * @param otherPokemon The other pokemon
     */
    public boolean collidesWithPokemon(Pokemon otherPokemon) {
        boolean xO = (this.getXPos() + 89 >= otherPokemon.getXPos()
            && this.getXPos() <= otherPokemon.getXPos() + 89);
        boolean yO = (this.getYPos() + 89 >= otherPokemon.getYPos()
            && this.getYPos() <= otherPokemon.getYPos() + 89);
        return (xO && yO);
    }

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

    /**
     * @return a boolean representing if one pokemon can reproduce with another
     * @param otherPokemon The other pokemon
     */
    public abstract boolean canHarmPokemon(Pokemon otherPokemon);

    /**
     * Harms another pokemon
     * @param otherPokemon The pokemon to harm
     */
    public void harmPokemon(Pokemon otherPokemon) {
        otherPokemon.adjHealth(-50);
    }

    /**
     * Sets the pokemon's health to zero
     */
    public void faint() {
        this.health = 0;
    }

    /**
     * @return if the pokemon has fainted
     */
    public boolean hasFainted() {
        return ((this.health < 1) || this.isOld());
    }

    /**
     * @return the X position of this Pokemon
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * changes the x position
     * @param in the new x position
     */
    public void setXPos(int in) {
        this.xPos = in;
    }

    /**
     * @return the Y position of this Pokemon
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * changes the y position
     * @param in the new y position
     */
    public void setYPos(int in) {
        this.yPos = in;
    }

    /**
     * @return the bounding rectangle of the PokeWorld
     *             that this Pokemon exists in
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
    * Sets the image attribute for this pokemon
    * @param image the ImageIcon to use to represent this Pokemon
    */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Should draw the Pokemon at its location.
     * @param g object for drawing use
     */
    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
    /**
     * @return the level of this Pokemon
     */
    public int getLevel() {
        return this.level;
    }
    /**
     * @return the health of this Pokemon
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * Adjsuts the health by an amount.
     * @param adj amount to adjust the health by
     */
    protected void adjHealth(int adj) {
        this.health += this.health + adj;
    }

}

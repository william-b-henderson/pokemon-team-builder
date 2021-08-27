/**
 * Generic class for building Pokemon types. All types have a number assigned to them 1-18
 * 1 - Normal
 * 2 - Fire
 * 3 - Water
 * 4 - Grass
 * 5 - Electric
 * 6 - Ice
 * 7 - Fighting
 * 8 - Poison
 * 9 - Ground
 * 10 - Flying
 * 11 - Psychic
 * 12 - Bug
 * 13 - Rock
 * 14 - Ghost
 * 15 - Dragon
 * 16 - Dark
 * 17 - Steel
 * 18 - Fairy
 */
public class Type {

    double[] weaknesses;
    double[] strengths;

    String type;

    public Type(double[] strengths, double[] weaknesses, String type) {
        this.weaknesses = weaknesses;
        this.strengths = strengths;
        this.type = type;
    }

    /**
     * Returns 2 if this is super effective against other, .5 if it is not very effective,
     * 0 if it has no effect, and 1 if it does normal damage.
     */
    public int effectiveness(Type other) {
        return 1;
    }

    @Override
    public String toString() {
        return this.type;
    }
}

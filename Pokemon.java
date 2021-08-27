public class Pokemon {
    Type t1;
    Type t2;
    double[] attackEffectiveness;
    double[] defenseEffectiveness;
    double[] counters;
    int rating;

    public Pokemon(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
        attackEffectiveness = attackEffectiveness();
        defenseEffectiveness = defenseEffectiveness();
        counters = counter();
        rating = 1;
    }

    public Pokemon(Type t1) {
        this.t1 = t1;
        this.t2 = null;
        attackEffectiveness = t1.strengths;
        defenseEffectiveness = t1.weaknesses;
        counters = counter();
        rating = 1;
    }

    @Override
    public String toString() {
        if (t2 == null) {
            return (t1 + " type pokemon");
        }
        return (t1 + " and " + t2 + " type pokemon");
    }

    /**
     * Prints the effectiveness and Counter chart of this pokemon.
     * * 1 - Normal
     *  * 2 - Fire
     *  * 3 - Water
     *  * 4 - Grass
     *  * 5 - Electric
     *  * 6 - Ice
     *  * 7 - Fighting
     *  * 8 - Poison
     *  * 9 - Ground
     *  * 10 - Flying
     *  * 11 - Psychic
     *  * 12 - Bug
     *  * 13 - Rock
     *  * 14 - Ghost
     *  * 15 - Dragon
     *  * 16 - Dark
     *  * 17 - Steel
     *  * 18 - Fairy
     */
    public void effectiveness() {
        System.out.println(this);
        System.out.printf("%12s %12s %12s %12s\n", "Type", "Attacking", "Defending", "Counter");
        System.out.printf("-----------------------------------------------------------\n");
        String[] types = new String[]{"Normal", "Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"};
        for (int i = 0; i < 18; i += 1) {
            String type = types[i];
            double attacking = attackEffectiveness[i];
            double defending = defenseEffectiveness[i];
            double counter = counters[i];
            System.out.printf("%12s %12.2f %12.2f %12.0f\n", type, attacking, defending, counter);
        }
    }

    private void verticalTypePrinter() {
        System.out.println("TYPE      | Total Effective | Total Resist | Total Counter");
        System.out.println("Normal    |");
        System.out.println("Fire      |");
        System.out.println("Water     |");
        System.out.println("Grass     |");
        System.out.println("Electric  |");
        System.out.println("Ice       |");
        System.out.println("Fighting  |");
        System.out.println("Poison    |");
        System.out.println("Ground    |");
        System.out.println("Flying    |");
        System.out.println("Psychic   |");
        System.out.println("Bug       |");
        System.out.println("Rock      |");
        System.out.println("Ghost     |");
        System.out.println("Dragon    |");
        System.out.println("Dark      |");
        System.out.println("Steel     |");
        System.out.println("Fairy     |");
    }

    /**
     * Returns an integer list of which types the pokemon is super effective against.
     * @return
     */
    private double[] attackEffectiveness() {
        double[] returnList = new double[18];
        for (int i = 0; i < 18; i += 1) {
            returnList[i] = Math.max(t1.strengths[i], t2.strengths[i]);
        }
        return returnList;
    }

    /**
     * Returns an integer list of which types the pokemon is damaged by.
     * @return
     */
    private double[] defenseEffectiveness() {
        double[] returnList = new double[18];
        for (int i = 0; i < 18; i += 1) {
            returnList[i] = t1.weaknesses[i] * t2.weaknesses[i];
        }
        return returnList;
    }

    /**
     * Returns a double list of which types this pokemon counters, 1 being counter and 0 being no counter.
     * @return
     */
    private double[] counter() {
        double[] returnList = new double[18];
        for (int i = 0; i < 18; i += 1) {
            if (attackEffectiveness[i] > 1 && defenseEffectiveness[i] < 1) {
                returnList[i] = 1;
            } else {
                returnList[i] = 0;
            }
        }
        return returnList;
    }
}

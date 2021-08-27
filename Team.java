import java.util.Arrays;

public class Team {
    Pokemon[] team = new Pokemon[6];
    int size;
    double[] teamAttackEffectiveness;
    double[] teamDefenseEffectiveness;
    double[] teamCounters;
    double[] rating;

    public Team(Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6) {
        team[0] = p1;
        team[1] = p2;
        team[2] = p3;
        team[3] = p4;
        team[4] = p5;
        team[5] = p6;
        size = 6;
        teamAttackEffectiveness = sumTeamAttackEffectiveness();
        teamDefenseEffectiveness = sumTeamDefenseEffectiveness();
        teamCounters = sumTeamCounters();
        rating = teamRating();
    }

    public Team() {
        size = 0;
    }

    /**
     * Removes all pokemon from the team and resets size to 0.
     */
    public void clear() {
        while (size > 0) {
            team[size-1] = null;
            size -= 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        if (size == 0) {
            return "There are no Pokemon on this team.";
        }
        for (Pokemon p : team) {
            if (p != null) {
                returnString.append(p);
                returnString.append("\n");
            }
        }
        return returnString.toString();
    }

    /**
     * Adds Pokemon p to the team.
     */
    public void addPokemon(Pokemon p) {
        if (size == 6) {
            return;
        }
        if (size == 5) {
            team[size] = p;
            size += 1;
            update();
            return;
        }
        team[size] = p;
        size += 1;
    }
    /**
     * Prints to console the team's total type effectiveness against all types.
     */
    public void matchUp() {
        update();
        System.out.println(this);
        System.out.printf("%12s %12s %12s %12s\n", "Type", "Attacking", "Defending", "Counter");
        System.out.printf("-----------------------------------------------------------\n");
        String[] types = new String[]{"Normal", "Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"};
        for (int i = 0; i < 18; i += 1) {
            String type = types[i];
            double attacking = teamAttackEffectiveness[i];
            double defending = teamDefenseEffectiveness[i];
            double counter = teamCounters[i];
            System.out.printf("%12s %12.2f %12.2f %12.0f\n", type, attacking, defending, counter);
        }
        System.out.println("Team Rating: " + rating[0] + "\nTypes Countered: " + rating[1]);
    }


    /**
     * Returns team attack effectiveness.
     */
    private double[] sumTeamAttackEffectiveness() {
        double[] attackTotal = new double[18];
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < 18; j += 1) {
                if (team[i].attackEffectiveness[j] > 1) {
                    attackTotal[j] += 1;
                }
            }
        }
        return attackTotal;
    }

    private double[] sumTeamDefenseEffectiveness() {
        double[] defenseTotal = new double[18];
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < 18; j += 1) {
                if (team[i].defenseEffectiveness[j] < 1) {
                    defenseTotal[j] += 1;
                }
            }
        }
        return defenseTotal;
    }

    private double[] sumTeamCounters() {
        double[] counterTotal = new double[18];
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < 18; j += 1) {
                counterTotal[j] += team[i].counters[j];
            }
        }
        return counterTotal;
    }
    
    /**
     * Returns a double representing the team's arbitrary score, used for ranking.
     * @return in the format [rating, numTypesCountered].
     */
    public double[] teamRating() {
        double[] totalRating = new double[2];
        double rating = 0;
        double numTypesCountered = 18;
        boolean countersAll = true;
        for (double d : teamCounters) {
            if (d == 0) {
                countersAll = false;
                numTypesCountered -= 1;
            } else {
                rating += 1;
            }
        }
        if (countersAll) {
            rating += 100;
        }
        totalRating[0] = rating;
        totalRating[1] = numTypesCountered;
        return totalRating;
    }

    /**
     * Updates the values of the team
     */
    private void update() {
        teamAttackEffectiveness = sumTeamAttackEffectiveness();
        teamDefenseEffectiveness = sumTeamDefenseEffectiveness();
        teamCounters = sumTeamCounters();
        rating = teamRating();
    }
}



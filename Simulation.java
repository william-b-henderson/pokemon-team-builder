import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


/**
 * Simulates the creation of every possible team combination and finds the team with the most super-effectives (strengths) and least weaknesses.
 * Also selects for greater coverage of pokemon types.
 */
public class Simulation {
    public static Type[] typeList = new Type[]{new NormalType(), new FireType(), new WaterType(), new GrassType(), new ElectricType(), new IceType(), new FightingType(), new PoisonType(), new GroundType(), new FlyingType(), new PsychicType(), new BugType(), new RockType(), new GhostType(), new DragonType(), new DarkType(), new SteelType(), new FairyType()};;
    public static Pokemon[] pokeList = pokeList();


    public static void main(String[] args) throws IOException {
        System.out.println();
        //flieMaker();

        Team myTeam = new Team();
        myTeam.addPokemon(new Pokemon(typeList[2], typeList[8]));
        myTeam.addPokemon(new Pokemon(typeList[0], typeList[15]));
        myTeam.addPokemon(new Pokemon(typeList[4], typeList[7]));
        myTeam.addPokemon(new Pokemon(typeList[4], typeList[11]));
        myTeam.addPokemon(new Pokemon(typeList[1]));
        myTeam.addPokemon(new Pokemon(typeList[10]));
        myTeam.matchUp();


        ArrayList<Team> teams = makeXTeams(10000);
        Team bestTeam = myTeam;
        for (Team team : teams) {
            if (team.rating[1] >= 17) {
                team.matchUp();
                bestTeam = team;
            }

        }
        bestTeam.matchUp();



    }

    /**
     * Writes to a file the input message.
     */
    public static void fileWrite(String input) {
        try {
            FileWriter myWriter = new FileWriter("teams.txt");
            myWriter.write(input);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Creates and returns file if it does not already exist.
     */
    public static File flieMaker() {
        try {
            File myObj = new File("teams.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return myObj;
            } else {
                System.out.println("File already exists.");
                return myObj;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a Team[] Array of size amount.
     */
    public static ArrayList<Team> makeXTeams(int amount) {
        ArrayList<Team> returnTeam = new ArrayList<>();
        for (int i = 0; i < amount; i += 1) {
            returnTeam.add(makeRandomTeam());
        }
        return returnTeam;
    }
    /**
     * Returns a Team of 6 random pokemon chosen without replacement
     * @return
     */
    public static Team makeRandomTeam() {
        Team returnTeam = new Team();
        Set<Integer> teamIDs = new HashSet<>();
        while (teamIDs.size() < 6) {
            int id = StdRandom.uniform(298);
            if (!teamIDs.contains(id)) {
                teamIDs.add(id);
            }
        }
        for (int i : teamIDs) {
            returnTeam.addPokemon(pokeList[i]);
        }

        return returnTeam;
    }

    /**
     * Returns a list of Pokemon with all pokemon type combinations possible.
     * @return
     */
    public static Pokemon[] pokeList() {
        pokeList = new Pokemon[324];
        Type[][] fakePokemon = new Type[26][];
        fakePokemon[0] = new Type[]{new NormalType(),new IceType()};
        fakePokemon[1] = new Type[]{new NormalType(),new PoisonType()};
        fakePokemon[2] = new Type[]{new NormalType(),new BugType()};
        fakePokemon[3] = new Type[]{new NormalType(),new RockType()};
        fakePokemon[4] = new Type[]{new NormalType(),new GhostType()};
        fakePokemon[5] = new Type[]{new NormalType(),new SteelType()};
        fakePokemon[6] = new Type[]{new FireType(),new GrassType()};
        fakePokemon[7] = new Type[]{new FireType(),new FairyType()};
        fakePokemon[8] = new Type[]{new ElectricType(),new FightingType()};
        fakePokemon[9] = new Type[]{new IceType(),new PoisonType()};
        fakePokemon[10] = new Type[]{new FightingType(),new GroundType()};
        fakePokemon[11] = new Type[]{new FightingType(),new FairyType()};
        fakePokemon[12] = new Type[]{new PoisonType(),new SteelType()};
        fakePokemon[13] = new Type[]{new GroundType(),new FairyType()};
        fakePokemon[14] = new Type[]{new BugType(),new DragonType()};
        fakePokemon[15] = new Type[]{new BugType(),new DarkType()};
        fakePokemon[16] = new Type[]{new RockType(),new GhostType()};
        fakePokemon[17] = new Type[]{new PsychicType(),new DragonType()};
        fakePokemon[18] = new Type[]{new DragonType(),new FairyType()};

        /* Legendary Only Typings */
        fakePokemon[19] = new Type[]{new FireType(),new WaterType()};
        fakePokemon[20] = new Type[]{new FireType(),new SteelType()};
        fakePokemon[21] = new Type[]{new IceType(),new DragonType()};
        fakePokemon[22] = new Type[]{new FightingType(),new RockType()};
        fakePokemon[23] = new Type[]{new FightingType(),new GhostType()};
        fakePokemon[24] = new Type[]{new PsychicType(),new GhostType()};
        fakePokemon[25] = new Type[]{new PsychicType(),new DragonType()};

        int index = 0;
        for (int i = 0; i < 18; i += 1) {
            for (int k = 0; k < 18; k += 1) {
                boolean notFake = true;
                for (int j = 0; j < fakePokemon.length; j += 1) {
                    if (fakePokemon[j][0].equals(typeList[i]) && fakePokemon[j][1].equals(typeList[k])) {
                       notFake = false;
                    }
                }
                if (notFake) {
                    if (typeList[i].equals(typeList[k])) {
                        pokeList[index] = new Pokemon(typeList[i]);
                        index += 1;
                    } else {
                        pokeList[index] = new Pokemon(typeList[i], typeList[k]);
                        index += 1;
                    }
                }
            }
        }


        return arrayCondenser(pokeList);
    }

    /**
     * Removes the null locations in the pList array and returns a condensed version of the array.
     * @param pList
     * @return
     */
    private static Pokemon[] arrayCondenser(Pokemon[] pList) {
        int newSize = pList.length;
        for (Pokemon p : pList) {
            if (p == null) {
                newSize -= 1;
            }
        }
        Pokemon[] returnList = new Pokemon[newSize];
        int ptr = 0;
        for (Pokemon p : pList) {
            if (p != null) {
                returnList[ptr] = p;
                ptr += 1;
            }
        }
        return returnList;
    }

}

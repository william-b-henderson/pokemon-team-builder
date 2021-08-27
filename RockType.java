public class RockType extends Type {
    static double[] strengths = new double[]{1,2,1,1,1,2,.5,1,.5,2,1,2,1,1,1,1,.5,1};
    static double[] weaknesses = new double[]{.5,.5,2,2,1,1,2,.5,2,.5,1,1,1,1,1,1,2,1};
    static String type = "Rock";

    public RockType() {
        super(strengths, weaknesses, type);
    }
}

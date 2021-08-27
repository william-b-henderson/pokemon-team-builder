public class FireType extends Type {
    static double[] strengths = new double[]{1,.5,.5,2,1,2,1,1,1,1,1,2,.5,1,.5,1,2,1};
    static double[] weaknesses = new double[]{1,.5,2,.5,1,.5,1,1,2,1,1,.5,2,1,1,1,.5,.5};
    static String type = "Fire";

    public FireType() {
        super(strengths, weaknesses, type);
    }
}

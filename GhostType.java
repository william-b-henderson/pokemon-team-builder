public class GhostType extends Type {
    static double[] strengths = new double[]{0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,.5,1,1};
    static double[] weaknesses = new double[]{0,1,1,1,1,1,0,.5,1,1,1,.5,1,2,1,2,1,1};
    static String type = "Ghost";

    public GhostType() {
        super(strengths, weaknesses, type);
    }
}

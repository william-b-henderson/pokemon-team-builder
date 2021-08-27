public class GroundType extends Type {
    static double[] strengths = new double[]{1,2,1,.5,2,1,1,2,1,0,1,.5,2,1,1,1,2,1};
    static double[] weaknesses = new double[]{1,1,2,2,0,2,1,.5,1,1,1,1,.5,1,1,1,1,1};
    static String type = "Ground";

    public GroundType() {
        super(strengths, weaknesses, type);
    }
}

public class FlyingType extends Type {
    static double[] strengths = new double[]{1,1,1,2,.5,1,2,1,1,1,1,2,.5,1,1,1,.5,1};
    static double[] weaknesses = new double[]{1,1,1,.5,2,2,.5,1,0,1,1,.5,2,1,1,1,1,1};
    static String type = "Flying";

    public FlyingType() {
        super(strengths, weaknesses, type);
    }
}

public class WaterType extends Type {
    static double[] strengths = new double[]{1,2,.5,.5,1,1,1,1,2,1,1,1,2,1,.5,1,1,1};
    static double[] weaknesses = new double[]{1,.5,.5,2,2,.5,1,1,1,1,1,1,1,1,1,1,.5,1};
    static String type = "Water";

    public WaterType() {
        super(strengths, weaknesses, type);
    }
}

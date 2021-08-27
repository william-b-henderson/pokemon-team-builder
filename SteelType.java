public class SteelType extends Type {
    static double[] strengths = new double[]{1,.5,.5,1,.5,2,1,1,1,1,1,1,2,1,1,1,.5,2};
    static double[] weaknesses = new double[]{1,.5,.5,.5,.5,2,1,1,1,1,1,1,1,1,2,1,1,2};
    static String type = "Steel";

    public SteelType() {
        super(strengths, weaknesses, type);
    }
}

public class DragonType extends Type {
    static double[] strengths = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,.5,0};
    static double[] weaknesses = new double[]{1,.5,.5,.5,.5,2,1,1,1,1,1,1,1,1,2,1,1,2};
    static String type = "Dragon";

    public DragonType() {
        super(strengths, weaknesses, type);
    }
}

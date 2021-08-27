public class PoisonType extends Type {
    static double[] strengths = new double[]{1,1,1,2,1,1,1,.5,.5,1,1,1,.5,.5,1,1,0,2};
    static double[] weaknesses = new double[]{1,1,1,.5,1,1,.5,.5,2,1,2,.5,1,1,1,1,1,.5};
    static String type = "Poison";

    public PoisonType() {
        super(strengths, weaknesses, type);
    }
}

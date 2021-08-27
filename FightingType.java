public class FightingType extends Type {
    static double[] strengths = new double[]{2,1,1,1,1,2,1,.5,1,.5,.5,.5,2,0,1,2,2,.5};
    static double[] weaknesses = new double[]{1,1,1,1,1,1,1,1,1,2,2,.5,.5,1,1,.5,1,2};
    static String type = "Fighting";

    public FightingType() {
        super(strengths, weaknesses, type);
    }
}

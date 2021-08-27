public class FairyType extends Type {
    static double[] strengths = new double[]{1,.5,1,1,1,1,2,.5,1,1,1,1,1,1,2,2,.5,1};
    static double[] weaknesses = new double[]{1,1,1,1,1,1,.5,2,1,1,1,.5,1,1,0,.5,2,1};
    static String type = "Fairy";

    public FairyType() {
        super(strengths, weaknesses, type);
    }
}

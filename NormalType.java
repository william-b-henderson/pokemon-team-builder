public class NormalType extends Type {
    static double[] strengths = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,.5,0,1,1,.5,1};
    static double[] weaknesses = new double[]{1,1,1,1,1,1,2,1,1,1,1,1,1,0,1,1,1,1};
    static String type = "Normal";

    public NormalType() {
        super(strengths, weaknesses, type);
    }

}

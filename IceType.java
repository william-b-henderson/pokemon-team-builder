public class IceType extends Type {
    static double[] strengths = new double[]{1,.5,.5,2,1,.5,1,1,2,2,1,1,1,1,2,1,.5,1};
    static double[] weaknesses = new double[]{1,2,1,1,1,.5,2,1,1,1,1,1,2,1,1,1,2,1};
    static String type = "Ice";

    public IceType() {
        super(strengths, weaknesses, type);
    }
}

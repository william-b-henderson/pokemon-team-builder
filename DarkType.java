public class DarkType extends Type {
    static double[] strengths = new double[]{1,1,1,1,1,1,.5,1,1,1,2,1,1,2,1,.5,1,.5};
    static double[] weaknesses = new double[]{1,1,1,1,1,1,2,1,1,1,0,2,1,.5,1,.5,1,2};
    static String type = "Dark";

    public DarkType() {
        super(strengths, weaknesses, type);
    }
}

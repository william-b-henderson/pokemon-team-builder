public class GrassType extends Type {
    static double[] strengths = new double[]{1,.5,2,.5,1,1,1,.5,2,.5,1,.5,2,1,.5,1,.5,1};
    static double[] weaknesses = new double[]{1,2,.5,.5,.5,2,1,2,.5,2,1,2,1,1,1,1,1,1};
    static String type = "Grass";

    public GrassType() {
        super(strengths, weaknesses, type);
    }
}

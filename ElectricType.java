public class ElectricType extends Type {
    static double[] strengths = new double[]{1,1,2,.5,.5,1,1,1,0,2,1,1,1,1,.5,1,1,1};
    static double[] weaknesses = new double[]{1,1,1,1,.5,1,1,1,2,.5,1,1,1,1,1,1,.5,1};
    static String type = "Electric";

    public ElectricType() {
        super(strengths, weaknesses, type);
    }
}

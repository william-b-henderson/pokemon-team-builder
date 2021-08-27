public class BugType extends Type {
    static double[] strengths = new double[]{1,.5,1,2,1,1,.5,.5,1,.5,2,1,1,.5,1,2,.5,.5};
    static double[] weaknesses = new double[]{1,2,1,.5,1,1,.5,1,.5,2,1,1,2,1,1,1,1,1};
    static String type = "Bug";

    public BugType() {
        super(strengths, weaknesses, type);
    }
}

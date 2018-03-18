import java.math.BigInteger;
import java.util.Random;

public class MyBigInter extends BigInteger {

    public MyBigInter(byte[] val) {
        super(val);
    }

    public MyBigInter(int signum, byte[] magnitude) {
        super(signum, magnitude);
    }

    public MyBigInter(String val, int radix) {
        super(val, radix);
    }

    private MyBigInter(String val) {
        super(val);
    }

    public MyBigInter(int numBits, Random rnd) {
        super(numBits, rnd);
    }

    public MyBigInter(int bitLength, int certainty, Random rnd) {
        super(bitLength, certainty, rnd);
    }


    public static MyBigInter valueof(String val){
        return new MyBigInter(val);
    }


}

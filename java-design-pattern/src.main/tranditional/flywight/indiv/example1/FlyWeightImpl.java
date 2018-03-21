package tranditional.flywight.indiv.example1;

public class FlyWeightImpl implements FlyWeight {
    @Override
    public void action(int arg) {
        System.out.println("args is: "+ arg);
    }
}

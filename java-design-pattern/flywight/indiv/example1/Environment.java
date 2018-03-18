package flywight.indiv.example1;

public class Environment {
    public static void main(String[] args) {
        FlyWeight a = FlyWeightFactory.getFlyWeight("a");
        a.action(1);

        FlyWeight a1 = FlyWeightFactory.getFlyWeight("a");
        System.out.println(a == a1);

        FlyWeight b = FlyWeightFactory.getFlyWeight("b");
        b.action(2);
        FlyWeight c = FlyWeightFactory.getFlyWeight("c");
        c.action(3);
    }
}

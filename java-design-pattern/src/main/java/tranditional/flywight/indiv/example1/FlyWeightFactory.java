package tranditional.flywight.indiv.example1;

import java.util.HashMap;
import java.util
        .Map;

public class FlyWeightFactory {
    private static Map<String, FlyWeight> flyWeights = new HashMap<>();

    public FlyWeightFactory(String arg){
        flyWeights.put(arg,new FlyWeightImpl());
    }

    public static FlyWeight getFlyWeight(String key){
        if(flyWeights.get(key) == null){
            flyWeights.put(key,new FlyWeightImpl());
        }
        return flyWeights.get(key);
    }

    public static int size(){
        return flyWeights.size();
    }
}

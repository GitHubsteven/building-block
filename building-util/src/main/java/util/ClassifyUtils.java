package util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ClassifyUtils {
    /**
     * 分类请求中的商品，类型参考{@link CompareTypeEnum}，如果在数据库中存在商品的话，那么会返回对应的id
     *
     * @param reqList 请求参数中的商品信息
     * @param dbList  db中存在的商品
     * @return 商品分类和对应的商品信息
     */
    public static <T> Map<CompareTypeEnum, List<T>> classifyGoods(Collection<T> reqList, Collection<T> dbList, Function<T, String> keyMapper) {
        final Map<String, T> existedKey2Map = dbList.stream()
                .collect(Collectors.toMap(keyMapper, it -> it));
        // 将请求中的类别分类
        final Map<CompareTypeEnum, List<T>> result = reqList.stream()
                .collect(Collectors.groupingBy(it -> {
                    final String key = keyMapper.apply(it);
                    final T t = existedKey2Map.get(key);
                    return t == null ? CompareTypeEnum.REQ_BUT_DB : CompareTypeEnum.BOTH_EXIST;
                }));
        // 分类db中未分类的数据
        final List<String> reqKeys = reqList.stream()
                .map(keyMapper)
                .collect(Collectors.toList());
        final List<T> existedDbButReq = dbList.stream().filter(it -> {
            final String key = keyMapper.apply(it);
            return !reqKeys.contains(key);
        }).collect(Collectors.toList());
        result.put(CompareTypeEnum.DB_BUT_REQ, existedDbButReq);
        return result;

    }
}

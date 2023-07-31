/**
 * @author: asx
 * @date: 2023/7/12
 * @descrition:
 */
package pers.asx.hash;

/**
 * @author: asx
 * @date: 2023/7/12
 * @descrition:
 */
public interface HashConflictResolver {
    /**
     * 获取哈希
     *
     * @param obj 对象
     * @return hash value
     */
    int getHash(Object obj);

    /**
     * 重新hash
     *
     * @return
     */
    int reHash(Object obj,Object obj2);
}

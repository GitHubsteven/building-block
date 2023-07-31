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
public class OpenAddressHashConflictResolver implements HashConflictResolver {

    int[] hash_address = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0
    };


    @Override
    public int getHash(Object obj) {
        if (obj == null)
            return 0;
        int h = obj.hashCode();


        return h ^ (h >>> 16);
    }

    @Override
    public int reHash(Object obj1, Object obj2) {
        int hash = getHash(obj1);
        int hash2 = getHash(obj2);
        if (hash2 == hash) {
            if (obj1.equals(obj2))
                return 0;

        }
        return 0;
    }

    public static void main(String[] args) {
        HashConflictResolver resolver = new OpenAddressHashConflictResolver();
        System.out.println(resolver.getHash("123"));
        System.out.println(resolver.getHash("123"));
    }
}

package brute.force;

/**
 * @Authoer: asa.x
 * @Date: 2020/7/29
 * @Descrition:
 */
public class SequentialSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 444, 44, 44, 444};
        int index = sequentialSearch(array, 44);
        System.out.println(index);
    }

    /**
     * SequentialSearch2(A[0...n],k)
     * A[n+1] = k
     * i<--0
     * while(A[i] != k)
     * i ++
     * return i <n ? i : -1;
     *
     * @param array value array
     * @param k     search key
     */
    public static int sequentialSearch(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                return i;
            }
        }
        return -1;
    }
}

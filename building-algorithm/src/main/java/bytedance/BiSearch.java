/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition:
 */
package bytedance;

/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition:
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] sortedNumber = new int[]{
                1, 3, 5, 7, 9, 11
        };
        System.out.println(search(sortedNumber, 1));
    }

    public static int search(int[] sortedNumbers, int target) {
        int start = 0;
        int end = sortedNumbers.length - 1;
        int index = -1;
        int mid;
        do {
            if (start > end) {
                break;
            }
            mid = (end + start) / 2;
            if (sortedNumbers[mid] == target) {
                index = mid;
                break;
            }
            if (sortedNumbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } while (true);

        return index;
    }
}

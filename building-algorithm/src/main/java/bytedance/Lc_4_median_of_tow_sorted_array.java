/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition:
 */
package bytedance;

/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition: https://leetcode.cn/problems/median-of-two-sorted-arrays/?company_slug=bytedance
 */
public class Lc_4_median_of_tow_sorted_array {
    public static void main(String[] args) {
        int[] number1 = new int[]{1, 6, 7};
        int[] number2 = new int[]{2, 3, 4, 5, 8, 9};
        double median = findMedianSortedArrays(number1, number2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        if (nums1.length == 0 && nums2.length > 0) {
            return getMedian(nums2);
        }
        if (nums2.length == 0 && nums1.length > 0) {
            return getMedian(nums1);
        }
        int start_1 = 0, mid_1, end_1 = nums1.length - 1, pre_1 = -1;
        int start_2 = 0, mid_2, end_2 = nums2.length - 1, pre_2 = -1;
        int totalLength = nums1.length + nums2.length;
        // 不在乎奇数还是偶数
        int median = totalLength / 2;
        boolean isEven = (totalLength % 2 == 0);
        if (!isEven) {
            median++;
        }
        int existedLength = 0;
        int[] breakNumbers = null;
        do {
            if (existedLength >= median) {
                break;
            }
            if (start_1 > end_1) {
                breakNumbers = nums1;
                break;
            }
            // 如果
            if (start_2 > end_2) {
                breakNumbers = nums2;
                break;
            }
            // 不一定是中位数，是取需要的位数和中位数之间最小的数
            mid_1 = start_1 + Math.min(median - existedLength - 1, (end_1 - start_1) / 2);
            mid_2 = start_2 + Math.min(median - existedLength - 1, (end_2 - start_2) / 2);
            // 两个中位数，取小的
            if ((nums1[mid_1] < nums2[mid_2]) || (nums1[mid_1] == nums2[mid_2] && (nums1[start_1] <= nums2[start_2]))) {
                existedLength = existedLength + (mid_1 - start_1 + 1);
                start_1 = mid_1 + 1;
                pre_1 = mid_1;
            } else {
                existedLength += mid_2 - start_2 + 1;
                start_2 = mid_2 + 1;
                pre_2 = mid_2;
            }
        } while (true);
        // 如果循环结束后，仍然没找出中位数的话
        if (median > existedLength) {
            int difInNeed = median - existedLength;
            if (breakNumbers == nums1) {
                pre_2 = pre_2 + difInNeed;
            } else {
                pre_1 = pre_1 + difInNeed;
            }
        }
        int cur_1 = pre_1 < 0 ? Integer.MIN_VALUE : nums1[pre_1];
        int cur_2 = pre_2 < 0 ? Integer.MIN_VALUE : nums2[pre_2];
        int cur = Math.max(cur_1, cur_2);
        int next_1 = pre_1 + 1 > nums1.length - 1 ? Integer.MAX_VALUE : nums1[pre_1 + 1];
        int next_2 = pre_2 + 1 > nums2.length - 1 ? Integer.MAX_VALUE : nums2[pre_2 + 1];
        // 如果是偶数
        return isEven ? (double) (cur + Math.min(next_1, next_2)) / 2 : cur;
    }

    public static double getMedian(int[] notEmptyNumbers) {
        int length = notEmptyNumbers.length;
        int median_under = notEmptyNumbers.length / 2;
        if ((length % 2) == 0) {
            return (double) (notEmptyNumbers[median_under - 1] + notEmptyNumbers[median_under]) / 2;
        } else {
            return notEmptyNumbers[median_under];
        }
    }
}
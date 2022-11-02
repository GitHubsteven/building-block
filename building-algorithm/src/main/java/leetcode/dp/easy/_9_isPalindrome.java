package leetcode.dp.easy;

/**
 * is palindrome
 */
public class _9_isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        String xStr = String.valueOf(x);
        int head = 0,  tail= xStr.length()-1;
        boolean isPalindrome =true;
        while(head <= tail){
            if(xStr.charAt(head) != xStr.charAt(tail)){
                isPalindrome = false;
                break;
            }
            head ++;
            tail --;
        }
        return isPalindrome;
    }

    public static boolean isPalindrome_official(int x) {
        if(x<0 || ((x % 10 == 0 && x != 0))) return false;
        int revertNumber = 0;

        while(x > revertNumber){
            revertNumber = revertNumber*10+ x %10;
            x = x/10;
        }
        return x == revertNumber || revertNumber /10 == x;
    }
}

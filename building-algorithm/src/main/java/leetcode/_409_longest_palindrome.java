package leetcode;

public class _409_longest_palindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
    public  static String longestPalindrome(String s) {
        int length = s.length();
        if(length ==1) return s;
        int max = 1,cnt;
        int cur = 1;
        int from = 0,to = 0;
        for (int i = 0; i < length -1; i++) {
            cnt = 1;
            cur =1;
            while(true){
                if((i-cnt) < 0 || (i+ cnt)>(length-1)) break;
                if(s.charAt(i-cnt) == s.charAt(i+cnt)){
                    cnt++;
                    cur += 2;
                }else{
                    break;
                }
            }
            if(cnt !=1 && cur > max){
                from = i-(cnt-1);
                to = i+ (cnt-1);
                max= cur;
            }
            // 重置cur->1
            cur = 1;
            cnt =1;
            while(true){
                if(((i-cnt +1) <0) ||(i+cnt) > (length -1)) break;
                if(s.charAt(i-cnt+1) == s.charAt(i+cnt)){
                    cnt ++;
                    cur +=2;
                }else{
                    break;
                }
            }
            if(cur-1 > max) {
                from = i-cnt+2;
                to = i+ (cnt-1);
                max = cur -1;
            }
        }
        return s.substring(from,to+1);
    }
}

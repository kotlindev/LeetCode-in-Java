package g0201_0300.s0224_basic_calculator;

// #Hard #String #Math #Stack #Recursion #Top_Interview_150_Stack
// #2025_03_09_Time_2_ms_(96.52%)_Space_45.07_MB_(23.63%)

public class Solution {
    private int i = 0;

    public int calculate(String s) {
        char[] ca = s.toCharArray();
        return helper(ca);
    }

    private int helper(char[] ca) {
        int num = 0;
        int prenum = 0;
        boolean isPlus = true;
        for (; i < ca.length; i++) {
            char c = ca[i];
            if (c != ' ') {
                if (c >= '0' && c <= '9') {
                    if (num == 0) {
                        num = (c - '0');
                    } else {
                        num = num * 10 + c - '0';
                    }
                } else if (c == '+') {
                    prenum += num * (isPlus ? 1 : -1);
                    isPlus = true;
                    num = 0;
                } else if (c == '-') {
                    prenum += num * (isPlus ? 1 : -1);
                    num = 0;
                    isPlus = false;
                } else if (c == '(') {
                    i++;
                    prenum += helper(ca) * (isPlus ? 1 : -1);
                    isPlus = true;
                    num = 0;
                } else if (c == ')') {
                    return prenum + num * (isPlus ? 1 : -1);
                }
            }
        }
        return prenum + num * (isPlus ? 1 : -1);
    }
}

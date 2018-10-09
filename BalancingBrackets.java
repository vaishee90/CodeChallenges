import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
    static String isBalanced(String s) {
    		Stack<Character> st = new Stack();
        String ans = "YES";
        char[] carray = s.toCharArray();
        for(char c : carray){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else{
                if(c == ')' && !st.isEmpty()){
                    if(st.pop() != '('){
                        ans = "NO";
                        break;
                    } 
                }
                else if(c == '}' && !st.isEmpty()){
                    if(st.pop() != '{'){
                        ans = "NO";
                        break;
                    } 
                }
                else if(c == ']' && !st.isEmpty()){
                    if(st.pop() != '['){
                        ans = "NO";
                        break;
                    } 
                }
                else{
                    ans = "NO";
                        break;
                }
            }
        }
        if(!st.isEmpty())
        		ans = "NO";
        return ans;
    }
    
    public static void main(String[] args) {

    		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = sc.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }
    }
}

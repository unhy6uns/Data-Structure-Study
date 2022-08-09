import java.util.Stack;
import java.io.*;

class InFix {
    public String expression;
    
    private Stack<String> postFixStack = new Stack<>();

    InFix(String s){
        expression = s;
    }
    private static boolean isVarOrEmpty(String s){
        if(s.length()<=1)
            return true;
        else
            return false;
    }
    private String[] splitByLastOperator(String s){
        String[] splited = new String[3];   //[left operand, operator, right operand]
        int index = lastOperatorIndex(s);
        if(index==-1){
            splited[0] = "";
            splited[1] = "";
            splited[2] = s;
        } else if(index==-2)
            splited = splitByLastOperator(s.substring(1,s.length()-1));
        else{
            splited[0] = s.substring(0,index);
            splited[1] = s.substring(index,index+1);
            splited[2] = s.substring(index+1,s.length());
        }
        return splited;
    }

    private static int lastOperatorIndex(String s){
        if(isVarOrEmpty(s))
            return -1;
        else{
            int rank=0;
            int index = -2;
            boolean plusMinus=false;   // true if + or - exist
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                switch (ch) {
                    case ')':
                        rank++;
                        break;
                    case '(':
                        rank--;
                        break;
                }
                if(rank==0){
                    if(ch=='+'||ch=='-'){
                        index = i;
                        plusMinus = true;
                    } else if(!plusMinus){
                        if(ch=='*'||ch=='/'){
                            index = i;
                        }
                    }
                }
            }
            return index;
        }
    }
    
    public String postFixString(){
        postFixString(expression);
        return postFixStack.pop();
    }
    private void postFixString(String s){
        String[] splited;
        splited = splitByLastOperator(s);
        String left = splited[0];
        String right = splited[2];
        String operator = splited[1];
        if(isVarOrEmpty(right))
            postFixStack.push(right);
        else {
            postFixString(right);
        }
        if(isVarOrEmpty(left))
            postFixStack.push(left);
        else {
            postFixString(left);
        }
        String postFixLeft = postFixStack.pop();
        String postFixRight = postFixStack.pop();
        String concat = postFixLeft + postFixRight + operator;
        postFixStack.push(concat);
    }
}


public class BJ1918 {
    public static void main(String[] args) throws IOException {
        String read = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        read = br.readLine();

        InFix problem = new InFix(read);
        String answer = problem.postFixString();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}


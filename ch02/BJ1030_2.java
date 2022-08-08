import java.io.*;
import java.util.StringTokenizer;

class coorstack{
    public int[] item = new int[11];
    public int topIndex;
    public int value;
    coorstack(int R){
        for(int i=0; i<11; i++){
            item[i] = 0;
        }
        topIndex = -1;
        value = R;
    }
    public void append(int n){
        topIndex++;
        item[topIndex] = n;
    }
}

class fractal_number{
    private int N_;
    private int K_;
    private int s_;
    public fractal_number(int s, int N, int K){
        N_ = N;
        K_ = K;
        s_ = s;
    }
    public coorstack find(int R){
        coorstack array = new coorstack(R);
        if(array.topIndex!=s_-1){
            array.append(array.value%N_);
            array.value = array.value/N_;
            find(array);
        }
        else{
            array.append(array.value);
        }
        return array;
    }
    public coorstack find(coorstack R){
        coorstack array = R;
        if(array.topIndex!=s_-1){
            array.append(array.value%N_);
            array.value = array.value/N_;
            find(array);
        }
        else{
            array.append(array.value);
        }
        return array;
    }
    public int find_value(coorstack R, coorstack C){
        int min = (N_-K_)/2-1;
        int max = (N_+K_)/2;
        for(int i=0; i<s_; i++){
            if(R.item[i]>min && R.item[i]<max){
                for(int j=0; j<s_; j++){
                    if(C.item[i]>min && C.item[i]<max){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

public class BJ1030_2 {
    public static void main(String[] args) throws IOException {
        String read = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            read = br.readLine();

        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        StringTokenizer st = new StringTokenizer(read);
        int s = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        fractal_number problem = new fractal_number(s,N,K);
        char[] answer = new char[(R2-R1+1)*(C2-C1+2)];
        for(int i=R1; i<R2+1; i++){
            for(int j=C1; j<C2+2; j++){
                if(j==C2+1){
                    answer[(i-R1)*(C2+2-C1)+(j-C1)] = '\n';
                }
                else{
                    coorstack row = problem.find(i);
                    coorstack col = problem.find(j);
                    int a = problem.find_value(row,col);
                    answer[(i-R1)*(C2+2-C1)+(j-C1)] = (char) (a + '0');
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();



    }
}
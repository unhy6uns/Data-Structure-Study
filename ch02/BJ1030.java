import java.io.*;
import java.util.StringTokenizer;


class fractal{
    int s_ = 0;
    int N_;
    int K_;
    int[][] base_;
    int[][] fractal_;
    fractal(int N, int K){
        this.N_ = N;
        this.K_ = K;
        this.s_ = 1;
        base_ = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if((i>(N-K)/2 - 1) && (i<(N+K)/2)){
                    if((j>(N-K)/2 - 1) && (j<(N+K)/2)){
                        base_[i][j]=1;
                    }
                }
                else base_[i][j] = 0;
            }
        }
        fractal_ = base_;
    }
    void buildFractal(int s){
        if(this.s_ == s){
            return;
        } else{
            int N1 = (int) Math.pow(this.N_,this.s_);
            int N2 = N1 * this.N_;
            int[][] next_fractal = new int[N2][N2];
            for(int i=0; i<N1; i++){
                for(int j=0; j<N1; j++){
                    if(fractal_[i][j] == 0){
                        for(int k=0; k<this.N_; k++){
                            for(int l=0; l<this.N_; l++){
                                next_fractal[this.N_*i+k][this.N_*j+l] = base_[k][l];
                            }
                        }
                    }
                    else{
                        for(int k=0; k<this.N_; k++){
                            for(int l=0; l<this.N_; l++){
                                next_fractal[this.N_*i+k][this.N_*j+l] = 1;
                            }
                        }
                    }
                }
            }
            this.fractal_ = next_fractal;
            this.s_++;
            buildFractal(s);
        }
    }
    char[] showFractal(int R1, int R2, int C1, int C2){
        char[] cropped = new char[(R2-R1+1)*(C2-C1+2)];
        int count=0;
        for(int i=R1; i<R2+1; i++){
            for(int j=C1; j<C2+2; j++){
                if(j==C2+1){
                    cropped[count] = '\n';
                }
                else cropped[count] = (char) (this.fractal_[i][j]+'0');
                // System.out.println(cropped[count]);
                count++;
            }
        }
        return cropped;
    }
}

public class BJ1030 {
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

        fractal fr = new fractal(N, K);
        fr.buildFractal(s);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(fr.showFractal(R1,R2,C1,C2));
        bw.flush();
        bw.close();



    }
}
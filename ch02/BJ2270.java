import java.util.Scanner;

class hanoi{
    int target=0;           // before solve -> target is 0
    int trials=0;
    int n;
    int[] n_of_plates;
    int[][] seq_of_plates;
    int final_target = 0;

    public void solveHanoi(){
        if(this.target == 0){       //to set target at first step
            for(int i=0; i<3; i++){
                if(this.seq_of_plates[i][0]==this.n) this.target = (i+1)%1000000;
            }
            final_target = this.target;
        }
        if(this.n==1) { //boundary condition
            if(this.n_of_plates[this.target-1]==0) this.trials++;
        }
        else {
            int to_remove = 3;

            if(this.seq_of_plates[this.target-1][0]==this.n){
                // System.out.println("case1");

                // no additional trials, no change of target
                
                to_remove = this.target-1;

            }
            else{
                // System.out.println("case2");

                // additionally required movements
                this.trials += (int) Math.pow(2,this.n-1) % 1000000;  

                // change of target
                if(this.seq_of_plates[0][0]==this.n){
                    to_remove = 0;
                    if(this.target == 2) this.target = 3;
                    else this.target = 2;
                } else if(this.seq_of_plates[1][0]==this.n){
                    to_remove = 1;
                    if(this.target == 1) this.target = 3;
                    else this.target = 1;
                } else if(this.seq_of_plates[2][0]==this.n){
                    to_remove = 2;
                    if(this.target == 1) this.target = 2;
                    else this.target = 1;
                }
            }

            // remove the largest plate
            n--;
            n_of_plates[to_remove]--;
            for(int i=1; i<this.n; i++){
                seq_of_plates[to_remove][i-1]=seq_of_plates[to_remove][i];
            }
            seq_of_plates[to_remove][this.n-1] = 0;

            // System.out.println(this.target);
            // System.out.println(this.trials);
            // System.out.printf("%d %d %d",this.n_of_plates[0],this.n_of_plates[1],this.n_of_plates[2]);

            solveHanoi();
            
            
        }
    }
}

public class BJ2270 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        hanoi problem = new hanoi();

        problem.n = sc.nextInt();
        problem.n_of_plates = new int[3]; 
        problem.seq_of_plates = new int[3][problem.n];

        for(int i=0;i<3;i++){
            problem.n_of_plates[i] = sc.nextInt();
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<problem.n_of_plates[i]; j++){
                problem.seq_of_plates[i][j] = sc.nextInt();
            }
        }
        sc.close();
        problem.solveHanoi();
        System.out.println(problem.final_target);
        System.out.println(problem.trials);
        
    }
}
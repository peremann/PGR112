package loesninger._02.loopPractice;

public class LoopTesting {
    public void run(){
        int i = 9;
        int sum = 0;
        for(int j = i; j>=0; j--){
            sum = sum + j;
            if(j==7){
                System.out.println("Look! It was 7!");
            } else{
                System.out.println("Tallet: "+j);
            }
        }
        System.out.println("Sum: "+sum);
    }
}

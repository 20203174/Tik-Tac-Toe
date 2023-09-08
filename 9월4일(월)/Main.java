import java.util.Random;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        TikTakToe tikTakTo = new TikTakToe();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int j = 0;

        while(true){
            System.out.println("원하는 자리에 돌을 놓아주세요 (0 2)");
            i = scanner.nextInt();
            j = scanner.nextInt();
            if(tikTakTo.playGame(i, j)){
                break;
            }
        }
    }
}

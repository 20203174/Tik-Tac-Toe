import java.util.Random;
import java.util.Scanner;

public class TikTakToe {
    private static int[][] computerStatus = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public TikTakToe() {
        computerInput();
        printMap();
    }

    public static void computerInput() {
        Random random = new Random();
        int randomI = random.nextInt(3);
        int randomJ = random.nextInt(3);
        boolean complete = true;

        while(complete){
            if(computerStatus[randomI][randomJ] == 0) {
                computerStatus[randomI][randomJ] = 1;
                System.out.println("컴퓨터는 "+randomI+", "+randomJ+"에 입력했습니다.");
                complete = false;
            }
            else{
                 randomI = random.nextInt(3);
                 randomJ = random.nextInt(3);
            }
        }
    }


    public static boolean examine(BinaryOp binder) {
        int count = 0;
        int i = 0;
        int init = binder.apply();

        for(i = 0; i < 3; i++) { //가로 검사
            for(int j = 0; j < 3; j++){
                if(computerStatus[i][j] == init) count++;
            }
            if(count ==3)return true; else count = 0;
            i++;
        }

        for(i = 0; i < 3; i++) { // 세로 검사
            for(int j = 0; j < 3; j++) {
                if(computerStatus[j][i] == init)count++;
            }
            if(count == 3) return true; else count = 0;
        }

        for(i = 0; i < 3; i++) {
            if(computerStatus[i][i] == init)count++;
        }
        if(count == 3) return true; else count = 0;

        if(computerStatus[2][0] == init && computerStatus[1][1] == init && computerStatus[0][2] == init)return true; else count = 0;
        
        return false;
    }

    public static void printMap() {
        int count = 0;
        System.out.println("--------------");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(computerStatus[i][j] == 1){
                    System.out.print("| O ");
                    count ++;
                }
                if(computerStatus[i][j] == 2){
                    System.out.print("| X ");
                    count ++;
                }
                if(computerStatus[i][j] == 0){
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
            System.out.println("--------------");
        }
        if(count == 9){
            System.out.println("무승부 입니다ㅠ 게임을 다시 시작해주세요!");
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                    computerStatus[i][j] = 0;
                }
            }
        }
    }
    
    public boolean playGame(int userI, int userJ) {
        if(computerStatus[userI][userJ] == 0) {
            computerStatus[userI][userJ] = 2;
            // computerStatus[userI][userJ] = 2;
        }
        else{
            System.out.println("빈자리가 아닙니다! 다시 입력해주세용");
            return false;
        }

        if(examine(new User())){
            printMap();
            System.out.println("너가 이겼습니다!");
            return true;
        }else{
            computerInput();
        }
        if(examine(new Computer())){
            printMap();
            System.out.println("컴퓨터가 이겼습니다!");
            return true;
        }
        printMap();
        return false;
        
    }
    
}
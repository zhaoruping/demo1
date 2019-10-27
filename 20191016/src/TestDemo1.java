import java.util.Scanner;

public class TestDemo1 {
    public static int forgJump(int n){

        if(n==1){
          return 1;
        }
        if(n==2){
            return 2;
        }
        return forgJump(n-1)+forgJump(n-2);
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数字：");
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(forgJump(n));

    }
}

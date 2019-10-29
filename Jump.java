public class Jump {
    //递归
    public static int frogJump(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return frogJump(n-1)+frogJump(n-2);
    }
    //非递归
    public static int frogJump1(int n){
        int a1=1;
        int a2=2;
        int a3=1;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        for(int i=3;i<=n;i++){
            a3=a1+a2;
            a2=a1;
            a2=a3;
        }
        return a3;

    }

    public static void main(String[] args) {
        System.out.println(frogJump(3));
        System.out.println(frogJump1(3));
    }
}

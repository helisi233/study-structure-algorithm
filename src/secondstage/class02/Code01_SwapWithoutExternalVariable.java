package secondstage.class02;

// 不适用额外变量交换两个变量
// 前提条件 a和b必须是两块独立的空间
public class Code01_SwapWithoutExternalVariable {

    public static void Swap(int a, int b) {
        System.out.println("Before Swap a:" + a + " b:" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After Swap a:" + a + " b:" + b);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        Swap(a, b);
    }
}

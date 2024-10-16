package cn.afuo.example.lambda;

/**
 * @description: 静态减类
 * @author: tianci
 * @date: 2024/3/12 09:40
 */
public class StaticDemoSubtraction {

    public static int subtract(int a, int b){
        if (a > b) {
            return a - b;
        }
        return b - a;
    }

}

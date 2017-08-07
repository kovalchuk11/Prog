package u1.home.task1;

public class Klass1 {
    public static int mat(int a, int b){
        return a + b;
    }
    @Annot(a = 3, b = 4)
    public static int mat2(int a, int b){
        return a * b;
    }
}

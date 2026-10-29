

package  com.anas.singleton;



public class App{
    public  static void main() {
        var a=HolderSingleton.getInstance();
        var b = HolderSingleton.getInstance();

        System.out.println("Same instance? " + (a == b));

        System.out.println(EnumSingleton.INSTANCE.next()); // 1
        System.out.println(EnumSingleton.INSTANCE.next()); // 2
    }
}
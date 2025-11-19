package Singleton;

public class Singleton {
private static volatile Singleton instance;

//creates multiple instances if two threads access this method simultaneously
public static Singleton getInstance1(){
    if (instance == null){
        instance = new Singleton();
    }
    return instance;
}

//creates one instance of singleton on concurrent environment but it is unnecessarily expensive due to cost of synchronization at every call
public static synchronized Singleton getInstance2(){
    if (instance == null){
        instance = new Singleton();
    }
    return instance;
}

//An implementation of double checked locking of Singleton. Intention is to reduce cost of synchronization and improve performance, by only
// locking critical section of code, the code which creates instance of Singleton class.
public static Singleton getInstance3()
{
    if (instance == null){
        synchronized (Singleton.class)
        {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
    return instance;
}


    public static void main(String[] args) {
        Singleton singletonInstance1 = Singleton.getInstance1();
        Singleton singletonInstance2 = Singleton.getInstance2();
        Singleton singletonInstance3 = Singleton.getInstance3();

    }
}

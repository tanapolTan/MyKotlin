import java.lang.reflect.InvocationTargetException;

public class InstantUtilsJava {

    public static void main(String[] args) throws Exception {
        NewDog2 dogy = InstantUtilsJava.newInstance(NewDog2.class, "AAA", 20);
        System.out.println(dogy);
    }

    public static <T> T newInstance(Class clazz, Object... args) throws Exception {
        T result = null;
        if (args.length == 0) {
            result = (T) clazz.getDeclaredConstructor(null).newInstance();
        } else {
            Class[] arr = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = args[i].getClass();
            }

            result = (T) clazz.getDeclaredConstructor(arr).newInstance(args);
        }
        return result;
    }
}

class Doggy {
    Doggy() {

    }
}

class NewDog2 extends BaseObject {
    NewDog2() {
        super();
    }


    NewDog2 (String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    private String name;
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weigth) {
        this.weight = weight;
    }
}
package javaConcept;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
Not safe
 */
class SingletonClass {
    private static SingletonClass object = null;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (object == null) {
            object = new SingletonClass();
        }
        return object;
    }
}

/**
 * Prevent reflection api alteration
 * Or make reflection safe
 */
class SingletonClassReflectionSafe {
    private static SingletonClassReflectionSafe object = null;

    private SingletonClassReflectionSafe() {
        // or you can return the already initialized object
        if (object != null) {
            throw new RuntimeException("Create object using getInstance() method.");
        }
    }

    public static SingletonClassReflectionSafe getInstance() {
        if (object == null) {
            object = new SingletonClassReflectionSafe();
        }
        return object;
    }
}


/**
 * Or make Thread safe
 * <p>
 * // need to add synchronized keyword
 * now if 2 diff threads tried calling the this method in then one have to wait for other to complete
 */
class SingletonClassThreadSafe {
    private static SingletonClassThreadSafe object = null;

    private SingletonClassThreadSafe() {
    }

    public static synchronized SingletonClassThreadSafe getInstance() {
        if (object == null) {
            object = new SingletonClassThreadSafe();
        }
        return object;
    }
}

/**
 * Or make Serialize safe
 * <p>
 * // need to add synchronized keyword
 * now if 2 diff threads tried calling the this method in then one have to wait for other to complete
 */
class SingletonClassSerializeSafe {
    private static SingletonClassSerializeSafe object = null;

    private SingletonClassSerializeSafe() {

    }

    public static SingletonClassSerializeSafe getInstance() {
        if (object == null) {
            object = new SingletonClassSerializeSafe();
        }
        return object;
    }

    protected SingletonClassSerializeSafe readResolve() {
        return getInstance();
    }
}

public class SingletonClassTesting {
    public static void main(String[] args) {
        new SingletonClassTesting().run();
    }

    private void run() {
        Testing1();
//        Testing2_ReflectionChecking();
        Testing3_SerializeSafe();
    }

    private void Testing1() {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println("Singleton instance 1 : " + instance1.hashCode());
        System.out.println("Singleton instance 2 : " + instance2.hashCode());
    }

    private void Testing2_ReflectionChecking() {
        System.out.println("Inside Reflection Testing");
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = null;

        try {
            Class<SingletonClass> class1 = SingletonClass.class;
            Constructor<SingletonClass> con = class1.getDeclaredConstructor();
            con.setAccessible(true);
            instance2 = con.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Singleton instance 1 : " + instance1.hashCode());
        System.out.println("Singleton instance 2 : " + instance2.hashCode());

        System.out.println("Testing Reflection Safe class: ");
        SingletonClassReflectionSafe i1 = SingletonClassReflectionSafe.getInstance();
        SingletonClassReflectionSafe i2 = null;

        try {
            Class<SingletonClassReflectionSafe> class1 = SingletonClassReflectionSafe.class;
            Constructor<SingletonClassReflectionSafe> con = class1.getDeclaredConstructor();
            con.setAccessible(true);
            i2 = con.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Singleton instance 1 : " + i1.hashCode());
        System.out.println("Singleton instance 2 : " + i2.hashCode());
    }

    private void Testing3_SerializeSafe() {

        try {
            SingletonClassSerializeSafe instance1 = SingletonClassSerializeSafe.getInstance();
            ObjectOutput out = null;

            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SingletonClassSerializeSafe instance2 = (SingletonClassSerializeSafe) in.readObject();
            in.close();

            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtils {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        showInfo(stringBuilder);
    }

    public static void showInfo(StringBuilder stringBuilder) {
        Class cls = stringBuilder.getClass();

        packageName(cls);

        className(cls);

        classExtends(cls);

        interfaces(cls);

        variables(cls);

        constructors(cls);

        methods(cls);
    }

    public static void packageName(Class cls){
        System.out.println("Пакет :" + cls.getPackageName());
        System.out.println();
    }


    public static void className(Class cls) {
        System.out.println("Имя класса: " + cls.getName());
        System.out.println();
    }

    public static void classExtends(Class cls) {
        Class classE = cls.getSuperclass();
        if (classE != null) {
            System.out.println("Родитель класса");
            System.out.println(classE.getName());
        }
        System.out.println();
    }

    public static void interfaces(Class cls) {
        Class[] interfaces = cls.getInterfaces();
        if (interfaces.length == 0) {
            System.out.println("Интерфейс отсуствует");
        } else {
            System.out.println("Интерфейсы:");
            for (Class inter : interfaces) {
                System.out.println(inter.getName());
            }
        }
        System.out.println();
    }


    public static void variables(Class cls) {
        System.out.println("Переменные");
        Field[] variables = cls.getDeclaredFields();

        for (Field variable : variables) {
            System.out.println("- Var: " + variable.getName() + " (" + variable.getType().getName() + ")");
        }

        System.out.println();
    }


    public static void constructors(Class cls) {
        System.out.println("Конструкторы");
        Constructor[] constructors = cls.getConstructors();

        for (Constructor cons : constructors) {
            System.out.println(cons.getName());
            parameters(cons);
            System.out.println();
        }
    }

    public static void methods(Class cls) {
        System.out.println("Методы");
        Method[] methods = cls.getMethods();
        System.out.println("В классе "+methods.length+" метода");
        System.out.println();

        for (Method meth : methods) {
            System.out.println(meth.getName());
            parameters(meth);
            System.out.println();

            annotation(meth);
        }
    }

    public static void annotation(Method meth) {
        Annotation[] annotations = meth.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Aннотация");
            System.out.println(annotation.toString());
        }
    }

    public static <T extends Executable> void parameters(T methOrConst) {
        System.out.println("Параметры");
        Class[] types = methOrConst.getParameterTypes();

        if (types.length == 0) {
            System.out.println("- Параметры отсутсвуют");
        } else {
            for (Class type : types) {
                System.out.println("- " + type.getName());
            }
        }
    }
}

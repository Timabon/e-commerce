import java.lang.reflect.Field;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        User user = new User("Tima", 15);


        if (user.getClass().isAnnotationPresent(StringLength.class)) {
            System.out.println("This user is annotated with CustomAnnotation");
        } else {
            System.out.println("Standard User");
        }

        System.out.println("Hello Ender");

        for (Field field : user.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(StringLength.class)) {
                StringLength annotation = field.getAnnotation(StringLength.class);
                Object obj = null;
                try {
                    obj = field.get(user);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (obj instanceof String strValue) {
                    if (strValue.length() < annotation.min() || strValue.length() > annotation.max()) {
                        try {
                            checkLength();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }

            }
        }
    }

    static void checkLength() throws LengthException {
        throw new LengthException("The username has to be between 5 and 10 characters length.");
    }



}

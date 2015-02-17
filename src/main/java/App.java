import com.thoughtworks.xstream.XStream;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * Created by dan on 17.2.15.
 */
public class App {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Person person = new Person("Bob", 3);
        int maxAnnotationValue;
        Class reflection = Person.class;
        Field fieldAge = reflection.getDeclaredField("age");
        Field fieldName = reflection.getDeclaredField("name");
        Method[] methods = reflection.getDeclaredMethods();
        System.out.println("<"+reflection.getName()+">");
        for(Method m : methods){
            if (m.getName().equals("getName")){
                System.out.print("\t<" + fieldName.getName() + " " + m.getAnnotation(Size.class).annotationType().getSimpleName());
                System.out.print(" =\"" + m.getAnnotation(Size.class).max()+"\"");
                System.out.print(">"+person.getName());
                System.out.println("</" + fieldName.getName() + ">");


            }
            if (m.getName().equals("getAge")){

                System.out.print("\t<" + fieldAge.getName() + " " + m.getAnnotation(NotNull.class).annotationType().getSimpleName() + " =\"true\">");
                System.out.print(person.getAge());
                System.out.println("</" + fieldName.getName() + ">");
            }
        }
        System.out.println("</"+reflection.getName()+">");

    }

}

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dan on 17.2.15.
 */
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Size(max = 3)
    public String getName() {
        return name;
    }

    @NotNull
    public int getAge() {
        return age;
    }

}

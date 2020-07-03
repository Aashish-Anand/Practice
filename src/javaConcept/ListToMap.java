package javaConcept;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class User {
    private Long id;
    private String name;
    private String lastName;
    private int age;

    public User(Long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class ListToMap {
    public static void main(String[] args) {
        new ListToMap().run();
    }

    private void run() {
        List<User> users = Arrays.asList(
                new User(1l, "Bob", "Taylor", 30),
                new User(2l, "Tom", "Richard", 32),
                new User(3l, "Bob", "Wills", 31),
                new User(4l, "Nick", "Jackson", 29),
                new User(5l, "john", "Anderson", 31),
                new User(6l, "Tom", "Taylor", 30),
                new User(7l, "Bob", "Mills", 29)
        );

        // we are using Collectors.toMap
        // not work for duplicates
        Map<Long, String> map = users.stream().collect(Collectors.toMap(User::getId,User::getLastName));

        map.entrySet().forEach(System.out::println);

        // what if there are duplicates
//        Map result = users.stream()
//                .sorted(Comparator.comparingLong(User::getId).reversed())
//                .collect(Collectors.toMap(User::getName, User::getLastName,
//                        (oldValue, newValue)->oldValue, LinkedHashMap::new));
//        System.out.println(result);
    }


}

package Constructors;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Harry");
        User user2 = new User("Harry", "enricoatz64@gmail.com");
        User user3 = new User("Harry", "enricoatz64@gmail.com", 23);

        System.out.println(user1.username + " | " + user1.email + " | " + user1.age);
        System.out.println(user2.username + " | " + user2.email + " | " + user2.age);
        System.out.println(user3.username + " | " + user3.email + " | " + user3.age);

    }
}

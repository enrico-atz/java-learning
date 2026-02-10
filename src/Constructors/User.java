package Constructors;

public class User {

    String username;
    String email;
    int age;

    // Primo costruttore

    User(String username) {
        this.username = username;
    }

    // Overloading di costruttori

    User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

}

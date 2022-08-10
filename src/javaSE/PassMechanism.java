package javaSE;
class User{
    private String name;

    User() {}

    User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class PassMechanism {
    public static void main(String[] args) {
        User user1 = new User("zexi");
        pass(user1);
        System.out.println(user1);
    }

    static private void pass(User user) {
        user.setName("gong");
    }
}

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // to-String
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Email %s", getId(), getName(), getEmail());
    }
}

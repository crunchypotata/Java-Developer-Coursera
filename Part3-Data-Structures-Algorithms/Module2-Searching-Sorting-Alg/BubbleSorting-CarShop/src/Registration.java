public class Registration {
    public String license;
    public String owner;

    public Registration(String license, String owner) {
        this.license = license;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return license + "\t: " + owner;
    }

    public static void main(String[] args) {
        System.out.println("Registration class working ....");
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name, email;
    private final LocalDate birthDate;

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        DateTimeFormatter birthFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthText = birthDate.format(birthFormat);

        return String.format("Client: %s (%s) - %s", name, birthText, email);
    }
}

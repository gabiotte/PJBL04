import java.time.LocalDate;

public class Cliente {
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private LocalDate dob;

    public Cliente(String name, String cpf, String phone, String email, LocalDate dob) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String[] toCSV() {
        return new String[]{name, cpf, phone, email, dob.toString()};
    }
}

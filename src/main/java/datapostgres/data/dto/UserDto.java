package datapostgres.data.dto;

/**
 * Data Transfer Object (DTO) para el usuario.
 */
public class UserDto {

    private String name;
    private String email;

    // Constructor sin argumentos
    public UserDto() {}

    // Constructor con parámetros
    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters y Setters
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
}

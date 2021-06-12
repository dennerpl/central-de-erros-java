package dev.codenation.Central.de.Erros.model;



import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Table(name="users")
public class User {

    public User(Long id, @Size(max = 50) @NotNull String nome, @Size(max = 50) @NotNull String password, @Size(max = 50) @NotNull @Email String email) {
        this.id = id;
        this.name = nome;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 50)
    @NotNull
    private String name;

    @Column
    @Size(max = 50)
    @NotNull
    private String password;


    @Column(unique = true)
    @Size(max = 50)
    @NotNull
    @Email
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


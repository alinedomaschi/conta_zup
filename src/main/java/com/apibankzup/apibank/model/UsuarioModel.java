package com.apibankzup.apibank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty(message = "Campo Vazio! Digite novamente seu nome.")
    private String nome;

    @Column(unique = true)
    @NotNull
    @NotEmpty(message = "Campo Vazio! Digite novamente seu e-mail.")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "Campo Vazio! Digite novamente sua senha.")
    private String senha;

    @Column(unique = true)
    @NotNull
    @NotEmpty(message = "Campo Vazio! Digite novamente seu CPF.")
    private String cpf;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAniversario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

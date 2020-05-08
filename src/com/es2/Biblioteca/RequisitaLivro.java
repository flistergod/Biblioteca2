package com.es2.Biblioteca;

public class RequisitaLivro {

    int id;
    String data_hora;
    Livro livro;
    Pessoa pessoa;

    public RequisitaLivro(int id, String data_hora, Livro livro, Pessoa pessoa) {
        this.id = id;
        this.data_hora = data_hora;
        this.livro = livro;
        this.pessoa = pessoa;
        System.out.println("Livro "+ livro.getId()+ " requisitado");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

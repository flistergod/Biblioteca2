package com.es2.Biblioteca;

import java.time.LocalDate;

public class RequisitaLivro {

    int id;
    private LocalDate dateTime;
   private Livro livro;
   private Pessoa pessoa;
   private static int id_count;



    public RequisitaLivro(Livro livro, Pessoa pessoa) {
        this.id = id_count++;
        this.dateTime=LocalDate.now();
        this.livro = livro;
        this.pessoa = pessoa;
       // System.out.println("Livro "+ livro.getId()+ " requisitado");
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        RequisitaLivro.id_count = id_count;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id_count++;
    }


    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
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

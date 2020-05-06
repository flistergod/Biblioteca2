package com.es2.Biblioteca;

public class Livro {

    private int id, isbn;
    private  String autor, titulo;
    private  API_QR_Code_Stub qr_code;
    private static int id_count, isbn_count;

    public Livro(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn=isbn_count++;
    }



    public int getId() {
        return id;
    }

    public void setId() {
        this.id=id_count++;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public API_QR_Code_Stub getQr_code() {
        return qr_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        Livro.id_count = id_count;
    }

    public static int getIsbn_count() {
        return isbn_count;
    }

    public static void setIsbn_count(int isbn_count) {
        Livro.isbn_count = isbn_count;
    }

    public void setQr_code(API_QR_Code_Stub qr_code) {
        this.qr_code = qr_code;
    }
}

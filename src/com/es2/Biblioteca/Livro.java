package com.es2.Biblioteca;

public class Livro {

    private int id;
    private  String autor, titulo;
    private  API_QR_Code_Stub qr_code;

    public Livro(int id, String autor, String titulo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setQr_code(API_QR_Code_Stub qr_code) {
        this.qr_code = qr_code;
    }
}

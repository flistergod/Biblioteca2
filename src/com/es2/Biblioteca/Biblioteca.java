package com.es2.Biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private String nome, morada;
    ArrayList<Livro> livros= new ArrayList<Livro>();

    public Biblioteca(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        System.out.println("Biblioteca disponivel");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public  ArrayList<Livro> getLivros() {
        return livros;
    }

    public  void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }



    public  void addLivro(Livro l){
        String path=this.nome+";"+l.getId()+";"+l.getTitulo()+";"+l.getAutor();
        API_QR_Code_Stub api_qr_code_stub=new API_QR_Code_Stub();
        api_qr_code_stub.setPath(path);

        l.setQr_code(api_qr_code_stub);
        livros.add(l);
        System.out.println("livro "+l.getId()+ " inserido");}



    public  void removeLivro(Livro l) throws BookNotFoundException {


        if(livros.contains(l)){

            livros.remove(l);
            System.out.println("livro "+l.getId()+ " removido da biblioteca");
        }
        else System.out.println("livro nao encontrado");  throw  new BookNotFoundException();
    }

    public  int requisitaLivro(Livro l) throws BookNotFoundException {
        int aux;

        if(livros.contains(l)){return 1;}
        else{   System.out.println("livro "+l.getId()+ " indisponivel"); throw  new BookNotFoundException();}

    }


}

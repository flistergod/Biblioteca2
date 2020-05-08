package com.es2.Biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private String nome, morada;
    ArrayList<Livro> livros= new ArrayList<Livro>();
    ArrayList<RequisitaLivro> livrosEmprestados=new ArrayList<RequisitaLivro>();;

    public Biblioteca(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        /*
        reviewer:
        submitter:
         System.out.println("Biblioteca disponivel");
            mouthloud*/

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

    public ArrayList<RequisitaLivro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(ArrayList<RequisitaLivro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
    
    public void addRequisicao(RequisitaLivro requisitaLivro){

        if(livros.contains(requisitaLivro.getLivro())) {
            livrosEmprestados.add(requisitaLivro);
            removeLivro(requisitaLivro.getLivro());
        }
    }
    
    public void removeRequisicao(Livro livro, String email){


        for(int i=0;i<livrosEmprestados.size();i++){

            if(livrosEmprestados.get(i).getLivro().getQr_code()==livro.getQr_code() &&
                    livrosEmprestados.get(i).getPessoa().getEmail()==email ){

                livros.add(livrosEmprestados.get(i).getLivro());
                livrosEmprestados.remove(livrosEmprestados.get(i));

            }
        }

      
    }

    public  void addLivro(Livro l) {
        String path = this.nome + ";" + l.getId() + ";" + l.getTitulo() + ";" + l.getAutor();
        API_QR_Code_Stub api_qr_code_stub = new API_QR_Code_Stub();
        api_qr_code_stub.setPath(path);

        l.setQr_code(api_qr_code_stub);
        l.setId();
        livros.add(l);
        //  System.out.println("livro "+l.getId()+ " inserido");}
    }



    public  void removeLivro(Livro l)  {


        if(livros.contains(l)){

            livros.remove(l);
           // System.out.println("livro "+l.getId()+ " removido da biblioteca");
        }
        //else System.out.println("livro nao encontrado");  throw  new BookNotFoundException();
    }

    public  int verificaExistenciaLivro(Livro l)   {
        int aux;

        if (livros.contains(l)) {
            aux = 1;
        } else {
            aux = 0;

            /*
            reviewer:
            submitter:
            //System.out.println("livro "+l.getId()+ " indisponivel"); throw  new BookNotFoundException();}


             */

        }
        return  aux;
    }
    
    
}

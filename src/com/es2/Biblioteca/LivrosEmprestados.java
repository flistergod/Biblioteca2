package com.es2.Biblioteca;

import java.util.ArrayList;

public class LivrosEmprestados {

     ArrayList<RequisitaLivro> livrosEmprestados=new ArrayList<RequisitaLivro>();;
     int teste;

    public LivrosEmprestados() {
        teste=2;
    }

    public int getTeste(){return  teste;}

    public  ArrayList<RequisitaLivro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public  void setLivrosEmprestados(ArrayList<RequisitaLivro> livrosEmprestados) {
        livrosEmprestados = livrosEmprestados;
    }

    public   void addLivroEmprestado(RequisitaLivro requisitaLivro){
        livrosEmprestados.add(requisitaLivro);
        System.out.println("registo criado: "+requisitaLivro.getId());
    }

    public   void removeLivroEmprestado(RequisitaLivro requisitaLivro){

        if(livrosEmprestados.contains(requisitaLivro)){
            livrosEmprestados.remove(requisitaLivro);
            System.out.println("registo removido: "+requisitaLivro.getId());
        }
        else
        System.out.println("registo nao encontrado");
    }

    public  int devolveLivro(Livro l, Pessoa pessoa){
        int aux = 0;
       for(int i=0;i<livrosEmprestados.size();i++){

           if(livrosEmprestados.get(i).livro.getId()==l.getId() && livrosEmprestados.get(i).pessoa.getName()==pessoa.getName() ){

               livrosEmprestados.remove(i);
               System.out.println("Devolucao aceite com sucesso");
               aux=1;
               break;
           }

       }

       if(aux==0){ System.out.println("Devolucao nao aceite"); aux=0;}
       return aux;
    }
}

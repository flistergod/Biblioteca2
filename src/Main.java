import com.es2.Biblioteca.*;

public class Main {

    public static void main(String args[]) throws BookNotFoundException {

      System.out.println("Hello World");

        Biblioteca biblioteca= new Biblioteca("Biblioteca_Municipal","Viseu");

        LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        System.out.println("\n");

        Livro livro1=new Livro(1,"Paulo","O teu pai");
        Livro livro2=new Livro(2,"Nelson","not 13 - 0");
        Livro livro3=new Livro(3,"Rita","Sozinha na cozinha");
        Livro livro4=new Livro(4,"Manel","I am Marroquino");

        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);
        biblioteca.addLivro(livro3);
        biblioteca.addLivro(livro4);
        biblioteca.removeLivro(livro4);

        System.out.println("\n\n");

        Pessoa Nelson = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Pessoa Rodas = new Pessoa("Rodrigo Amaral", "rodas_loiras_boas@gmail.com","Rua sem bus, Viseu", "no need");
        Pessoa Anao = new Pessoa("Miguel Raimundo", "wannabefotografo@gmail.com","Cartrash, Lisboa", "966996960");
        Pessoa Iglesias = new Pessoa("Joao Dias", "fuckboy_do_hi5@gmail.com","Viseu of course", "uno dos tres");

        System.out.println("\n\n");


        if(biblioteca.requisitaLivro(livro1)==1){
            RequisitaLivro requisitaLivro1= new RequisitaLivro(1,"28/04/2020 10:56",livro1,Nelson);
            livrosEmprestados.addLivroEmprestado(requisitaLivro1);
            biblioteca.removeLivro(livro1);
        }

        System.out.println("\n\n");

        if(biblioteca.requisitaLivro(livro2)==1){
            RequisitaLivro requisitaLivro2= new RequisitaLivro(2,"28/04/2020 10:58",livro2,Iglesias);
            livrosEmprestados.addLivroEmprestado(requisitaLivro2);
            biblioteca.removeLivro(livro2);
        }

        System.out.println("\n\n");

        if(biblioteca.requisitaLivro(livro3)==1){
            RequisitaLivro requisitaLivro3= new RequisitaLivro(3,"28/04/2020 11:00",livro3,Rodas);
            livrosEmprestados.addLivroEmprestado(requisitaLivro3);
            biblioteca.removeLivro(livro3);
        }

        System.out.println("\n\n");

        if(biblioteca.requisitaLivro(livro4)==1){
            RequisitaLivro requisitaLivro4= new RequisitaLivro(4,"28/04/2020 11:14",livro4,Anao);
            livrosEmprestados.addLivroEmprestado(requisitaLivro4);
            biblioteca.removeLivro(livro4);
        }

        System.out.println("\n\n");

        int aux=0;
        try{

            aux=livrosEmprestados.devolveLivro(livro2,Nelson);
        }catch (Exception e){}


        if(aux==1){biblioteca.addLivro(livro2);}


        System.out.println("\n");

         aux=livrosEmprestados.devolveLivro(livro1,Nelson);

        if(aux==1){biblioteca.addLivro(livro1);}



    }




}

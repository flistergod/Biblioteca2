import com.es2.Biblioteca.*;

public class Main {

    public static void main(String args[]) {


        Biblioteca biblioteca= new Biblioteca("Biblioteca_Municipal","Viseu");


        Livro livro1=new Livro("Paulo","O teu pai");
        Livro livro2=new Livro("Nelson","not 13 - 0");
        Livro livro3=new Livro("Rita","Sozinha na cozinha");
        Livro livro4=new Livro("Manel","I am Marroquino");

        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);
        biblioteca.addLivro(livro3);
        biblioteca.addLivro(livro4);
        biblioteca.removeLivro(livro4);


        Pessoa Nelson = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Pessoa Rodas = new Pessoa("Rodrigo Amaral", "rodas_loiras_boas@gmail.com","Rua sem bus, Viseu", "no need");
        Pessoa Anao = new Pessoa("Miguel Raimundo", "wannabefotografo@gmail.com","Cartrash, Lisboa", "966996960");
        Pessoa Iglesias = new Pessoa("Joao Dias", "fuckboy_do_hi5@gmail.com","Viseu of course", "uno dos tres");



        RequisitaLivro requisitaLivro1= new RequisitaLivro(livro1,Nelson);
        biblioteca.addRequisicao(requisitaLivro1);

        RequisitaLivro requisitaLivro2= new RequisitaLivro(livro2,Iglesias);
        biblioteca.addRequisicao(requisitaLivro2);

        RequisitaLivro requisitaLivro3= new RequisitaLivro(livro3,Rodas);
        biblioteca.addRequisicao(requisitaLivro3);


        RequisitaLivro requisitaLivro4= new RequisitaLivro(livro4,Anao);
        biblioteca.addRequisicao(requisitaLivro4);


        biblioteca.removeRequisicao(livro1, Anao.getEmail());

        biblioteca.removeRequisicao(livro1, Nelson.getEmail());








    }




}

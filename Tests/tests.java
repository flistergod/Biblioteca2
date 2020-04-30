import com.es2.Biblioteca.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class tests {

    //loudmouth em quase todos

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        End e= new End();
    }

    @BeforeEach
    void setUp() throws Exception {

    }

    @AfterEach
    void tearDown() throws Exception {
    }

    //nitpicker
    @Test
    void createQrCode(){

        API_QR_Code_Stub api_qr_code_stub= new API_QR_Code_Stub();
        assertEquals("https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=",api_qr_code_stub.getPath());
        assertEquals(1,api_qr_code_stub.getId());
        assertEquals(1,API_QR_Code_Stub.getQr_code_count());
        assertEquals(1,API_QR_Code_Stub.getQr_codes().size());
    }


    //happypath

    @Test
    void createLivro(){

        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        assertEquals(1,livro.getId());

    }

    @Test
    void createPessoa(){

        Pessoa p1 = new Pessoa("Nelson","nelson.andrade98@gmail.com","IPV","938249102");
        assertEquals(p1.getName(),"Nelson");
    }

    @Test
    void CreateBiblioteca(){

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        assertEquals("BibliotecaMunicipal", biblioteca.getNome());
    }

    //happypath
    //excessive setup
    @Test
    void createRequisicao(){

        /*
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

        assertEquals(1,requisitaLivro.getId());

        */
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");

        biblioteca.addLivro(livro);
        RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

        assertEquals(1,requisitaLivro.getId());

    }

    @Test
    void criaRepositorioRequisicoes(){

        LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        assertEquals(2,livrosEmprestados.getTeste());
    }


    @Test
    void addLivroBiblioteca(){
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        assertEquals(0,biblioteca.getLivros().size());

        biblioteca.addLivro(livro);
        assertEquals(1,biblioteca.getLivros().size());


    }


    //Generous Leftovers
    @Test
    void criaQrCodeLivro() throws BookNotFoundException {

        //os metodos anteriores acedem ao count static
        //API_QR_Code_Stub.setQr_code_count(0);
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");

        assertEquals(0,API_QR_Code_Stub.getQr_code_count());
        biblioteca.addLivro(livro);



        assertEquals(1,API_QR_Code_Stub.getQr_code_count());

        biblioteca.removeLivro(livro);
        biblioteca.addLivro(livro);



        assertEquals(2,API_QR_Code_Stub.getQr_code_count());

        String aux= API_QR_Code_Stub.getQr_codes().get(0);
        String aux2= API_QR_Code_Stub.getQr_codes().get(1);
        assertNotEquals(aux,aux2);


    }

    @Test
    void removeLivroBiblioteca() throws BookNotFoundException {

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);
        assertEquals(1,biblioteca.getLivros().size());

        biblioteca.removeLivro(livro);
        assertEquals(0,biblioteca.getLivros().size());
    }

    @Test
    void ContemLivros(){

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);
        assertEquals("UnitAnti-Patterns",biblioteca.getLivros().get(0).getTitulo());
    }

//the liar
    @Test
    void guardaRegistoRequisicao(){

        LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");



            RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

         //   assertEquals(0,livrosEmprestados.getLivrosEmprestados().size());

            livrosEmprestados.addLivroEmprestado(requisitaLivro);
          //  assertEquals(1,livrosEmprestados.getLivrosEmprestados().size());
        }

    @Test
    void removeRegistoRequisicao(){

        LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");



        RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);


        livrosEmprestados.addLivroEmprestado(requisitaLivro);
        assertEquals(1,livrosEmprestados.getLivrosEmprestados().size());

        livrosEmprestados.removeLivroEmprestado(livrosEmprestados.getLivrosEmprestados().get(0));
        assertEquals(0,livrosEmprestados.getLivrosEmprestados().size());
    }

    //secret catcher
    @Test
    void verificaSeLivroDisponivel(){
        int aux = 0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        biblioteca.addLivro(livro);
        
        try {
             aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        assertEquals(1,aux);

    }

    @Test
    void requisitaLivro() throws BookNotFoundException {
        int aux=0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);

        try {
            aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        if(aux==1){

            RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

            assertEquals(0,livrosEmprestados.getLivrosEmprestados().size());

            livrosEmprestados.addLivroEmprestado(requisitaLivro);
            assertEquals(1,livrosEmprestados.getLivrosEmprestados().size());
        }
    }

    //Enumerator
//removeLivroQuandoRequisita
    @Test
    void teste1() throws BookNotFoundException {
int aux=0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        LivrosEmprestados livrosEmprestados = new LivrosEmprestados();
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);

        try {
            aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        if (aux == 1) {

            RequisitaLivro requisitaLivro = new RequisitaLivro(1, "29/04/2020 15:54", livro, p1);
            livrosEmprestados.addLivroEmprestado(requisitaLivro);

            assertEquals(1, biblioteca.getLivros().size());
            biblioteca.removeLivro(livro);
            assertEquals(0, biblioteca.getLivros().size());


        }
    }

    //free rider
//insereLivroBibliotecaRequisicao
    @Test
    void teste2() throws BookNotFoundException {
        int aux=0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        LivrosEmprestados livrosEmprestados = new LivrosEmprestados();
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);


        try {
            aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        if (aux == 1) {

            RequisitaLivro requisitaLivro = new RequisitaLivro(1, "29/04/2020 15:54", livro, p1);
            livrosEmprestados.addLivroEmprestado(requisitaLivro);


            biblioteca.removeLivro(livro);


            assertEquals(0,biblioteca.getLivros().size());
            biblioteca.addLivro(livrosEmprestados.getLivrosEmprestados().get(0).getLivro());

            livrosEmprestados.removeLivroEmprestado(livrosEmprestados.getLivrosEmprestados().get(0));
            assertEquals(1,biblioteca.getLivros().size());


            assertEquals(1,biblioteca.getLivros().get(0).getId());




        }
    }
//devolveLivro
    @Test
    void teste3() throws BookNotFoundException {
int aux=0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        LivrosEmprestados livrosEmprestados = new LivrosEmprestados();
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);


        try {
            aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        if (aux == 1) {

            RequisitaLivro requisitaLivro = new RequisitaLivro(1, "29/04/2020 15:54", livro, p1);
            livrosEmprestados.addLivroEmprestado(requisitaLivro);


            biblioteca.removeLivro(livro);


         biblioteca.addLivro(livrosEmprestados.getLivrosEmprestados().get(0).getLivro());

         livrosEmprestados.removeLivroEmprestado(livrosEmprestados.getLivrosEmprestados().get(0));

         assertEquals(1,biblioteca.getLivros().get(0).getId());

        }

    }



}

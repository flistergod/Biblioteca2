import com.es2.Biblioteca.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*Equipa de submiter: 15256 e 16043
* Equipa de reviwer: 16601 e 16075 */

public class UTAntipatterns {


    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        End e = new End();
    }

    @BeforeEach
    void setUp() throws Exception {

    }

    @AfterEach
    void tearDown() throws Exception {
    }


    @Test
    void createQrCode() {

        /*//nitpicker
        * reviwer: 16601
        * submitter:15256
        *
        * nao e necessario fazer tantas comparacoes
        *
        *  API_QR_Code_Stub api_qr_code_stub= new API_QR_Code_Stub();
        assertEquals("https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=",api_qr_code_stub.getPath());
        assertEquals(1,api_qr_code_stub.getId());
        assertEquals(1,API_QR_Code_Stub.getQr_code_count());
        assertEquals(1,API_QR_Code_Stub.getQr_codes().size());
    }*/

        API_QR_Code_Stub api_qr_code_stub = new API_QR_Code_Stub();
        api_qr_code_stub.setPath("ola;12");
        assertEquals("https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl="+api_qr_code_stub.getId()+";ola;12", api_qr_code_stub.getPath());


    }




    @Test
    void createLivro() {

        //happypath
        /*
        * reviwer:16075
        * submitter:16043
        *
        *  Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        assertEquals(1,livro.getId());
        *
        * o id do livro é agora automatico
        * */

    Livro.setIsbn_count(0);
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");

       assertEquals(0, livro.getIsbn());


        Livro livro1 = new Livro("Pedro", "UnitAnti-Patterns");

        assertEquals(1, livro1.getIsbn());

    }

    @Test
    void createPessoa() {

        Pessoa p1 = new Pessoa("Nelson", "nelson.andrade98@gmail.com", "IPV", "938249102");
        assertEquals(p1.getName(), "Nelson");
    }

    @Test
    void CreateBiblioteca() {

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        assertEquals("BibliotecaMunicipal", biblioteca.getNome());
    }


    @Test
    void createRequisicao() {

            /*
            * //happypath
             //excessive setup
             * Generous Leftovers
            reviwer:16601
            * submitter:16043
            *
            * O id e a data da requisicao são automaticos
            * nao e necessario preparar a biblioteca
            * nao e necessario adicionar o livro a biblioteca
            * ter atencao aos ids ja existentes de requisicoes
            *
            *  Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");

        biblioteca.addLivro(livro);
        RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

        assertEquals(1,requisitaLivro.getId());
            *  * */


        RequisitaLivro.setId_count(1);
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");
        RequisitaLivro requisitaLivro = new RequisitaLivro(livro, p1);

        assertEquals(1, requisitaLivro.getId());


    }


    @Test
    void addLivroBiblioteca() {
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");
        assertEquals(0, biblioteca.getLivros().size());

        biblioteca.addLivro(livro);
        assertEquals(1, biblioteca.getLivros().size());


    }


    @Test
    void criaQrCodeLivro() {

        /*
        * Generous Leftovers
        * reviwer: 16075
        * submiter:15256
        *
        * ter atencao do incremento dos ids dos qr codes no asserts
        *
        *  Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
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
        * */

        //os metodos anteriores acedem ao count static
        API_QR_Code_Stub.setQr_code_count(0);

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");

        assertEquals(0, API_QR_Code_Stub.getQr_code_count());
        biblioteca.addLivro(livro);


        assertEquals(1, API_QR_Code_Stub.getQr_code_count());

        biblioteca.removeLivro(livro);
        biblioteca.addLivro(livro);


        assertEquals(2, API_QR_Code_Stub.getQr_code_count());

        String aux = API_QR_Code_Stub.getQr_codes().get(0);
        String aux2 = API_QR_Code_Stub.getQr_codes().get(1);
        assertNotEquals(aux, aux2);


    }

    @Test
    void removeLivroBiblioteca() {

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        biblioteca.addLivro(livro);
        assertEquals(1, biblioteca.getLivros().size());

        biblioteca.removeLivro(livro);
        assertEquals(0, biblioteca.getLivros().size());
    }

    @Test
    void ContemLivros() {

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        biblioteca.addLivro(livro);
        assertEquals("UnitAnti-Patterns", biblioteca.getLivros().get(0).getTitulo());
    }


    @Test
    void guardaRegistoRequisicao() {

        /*
        *
        *  //the liar
        *
        * reviwer:16075
        * submiter:16043
        *
        * O teste passa sempre prque nao ha asserts
        *
        *   LivrosEmprestados livrosEmprestados= new LivrosEmprestados();
        Pessoa p1=new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com","Nisa, Portalegre", "938249102");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");



            RequisitaLivro requisitaLivro= new RequisitaLivro(1,"29/04/2020 15:54", livro, p1);

            livrosEmprestados.addLivroEmprestado(requisitaLivro);
        * */

        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        biblioteca.addLivro(livro);
        RequisitaLivro requisitaLivro = new RequisitaLivro(livro, p1);

        assertEquals(0, biblioteca.getLivrosEmprestados().size());

        biblioteca.addRequisicao(requisitaLivro);
        assertEquals(1, biblioteca.getLivrosEmprestados().size());
    }

    @Test
    void removeRegistoRequisicao() {




        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        biblioteca.addLivro(livro);

        RequisitaLivro requisitaLivro = new RequisitaLivro(livro, p1);


        biblioteca.addRequisicao(requisitaLivro);
        assertEquals(1, biblioteca.getLivrosEmprestados().size());
        biblioteca.removeRequisicao(livro, p1.getEmail());

        assertEquals(0, biblioteca.getLivrosEmprestados().size());
    }


    @Test
    void verificaSeLivroDisponivel() {

        /*
        * //secret catcher
        * reviwer:16601
        * submiter:15256
        *
        * o teste fica a espera de uma exception que nunca existe
        *
        *  int aux = 0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro= new Livro(1,"Pedro","UnitAnti-Patterns");
        biblioteca.addLivro(livro);

        try {
             aux= biblioteca.requisitaLivro(livro);
        } catch (BookNotFoundException e) {

        }

        assertEquals(1,aux);

*
*
        * */
        int aux = 0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        aux = biblioteca.verificaExistenciaLivro(livro);

        assertEquals(0, aux);

        biblioteca.addLivro(livro);

        aux = biblioteca.verificaExistenciaLivro(livro);

        assertEquals(1, aux);
    }

    @Test
    void requisitaLivro() {
        int aux = 0;
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro = new Livro("Pedro", "UnitAnti-Patterns");


        biblioteca.addLivro(livro);

        aux = biblioteca.verificaExistenciaLivro(livro);

        if (aux == 1) {
            biblioteca.addRequisicao(new RequisitaLivro(livro, p1));
            assertEquals(livro.getId(), biblioteca.getLivrosEmprestados().get(0).getLivro().getId());
        }

    else

    {
        assertEquals(0, biblioteca.getLivrosEmprestados().size());
    }

}


    @Test
    void removeLivroQuandoRequisita()  {

        /*Enumerator
        * nome do metodo era teste1
        * reviwer:16601
        * submiter:16043*/


        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro("Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);

        assertEquals(1,biblioteca.getLivros().size());
        assertEquals(0,biblioteca.getLivrosEmprestados().size());

        biblioteca.addRequisicao(new RequisitaLivro(livro,p1));

        assertEquals(0,biblioteca.getLivros().size());

        assertEquals(1,biblioteca.getLivrosEmprestados().size());
    }


//
    @Test
    void insereLivroBibliotecaRequisicao()  {

        /*Enumerator e //free rider
         * nome do metodo era teste2
         *
         * reviwer:16075
         * submiter:15256
         *
         *este assert deve ser feito noutro teste: verificar se o livro devolvido é
         * o correto
         *
         *    assertEquals(1,biblioteca.getLivros().get(0).getId());

         *
         *    int aux=0;
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
         * */




        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro("Pedro","UnitAnti-Patterns");


            biblioteca.addLivro(livro);


            assertEquals(1,biblioteca.getLivros().size());

            biblioteca.addRequisicao(new RequisitaLivro(livro,p1));

            assertEquals(0,biblioteca.getLivros().size());

            biblioteca.removeRequisicao(livro,p1.getEmail());

            assertEquals(1,biblioteca.getLivros().size());



        }

        @Test
    void devolveLivro() {
        Biblioteca biblioteca = new Biblioteca("BibliotecaMunicipal", "Viseu");
        Pessoa p1 = new Pessoa("Nelson Andrade", "nelson.andrade98@gmail.com", "Nisa, Portalegre", "938249102");
        Livro livro= new Livro("Pedro","UnitAnti-Patterns");


        biblioteca.addLivro(livro);



        biblioteca.addRequisicao(new RequisitaLivro(livro,p1));


        biblioteca.removeRequisicao(livro,p1.getEmail());

        assertEquals(0,biblioteca.getLivros().get(0).getId());


    }





}

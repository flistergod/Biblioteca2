import com.es2.Biblioteca.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class tests {


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

    //nitpicker
    @Test
    void createQrCode() {

        API_QR_Code_Stub api_qr_code_stub = new API_QR_Code_Stub();
        api_qr_code_stub.setPath("ola;12");
        assertEquals("https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl="+api_qr_code_stub.getId()+";ola;12", api_qr_code_stub.getPath());


    }


    //happypath

    @Test
    void createLivro() {

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

    //happypath
    //excessive setup
    @Test
    void createRequisicao() {


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

    //the liar
    @Test
    void guardaRegistoRequisicao() {


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

    //secret catcher
    @Test
    void verificaSeLivroDisponivel() {
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

    //free rider
//
    @Test
    void insereLivroBibliotecaRequisicao()  {


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




}

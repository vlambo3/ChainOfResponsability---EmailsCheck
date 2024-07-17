/*
Esta clase forma parte del patrón de diseño Cadena de Responsabilidad
La clase chequeará el manejo de mail dependiendo de su destino o tema.
*/
public class CheckEmail {

    //Representa el primer manejador en la cadena de responsabilidad.
    private Handler chain;

    //Método para crear la cadena de responsabilidad
    private Handler createChain() {
        // Se crean instancias de cada manejador específico.
        Handler managerHandler = new ManagerHandler();
        Handler comercialHandler = new ComercialHandler();
        Handler technicalHandler = new TechnicalHandler();
        Handler spamHandler = new SpamHandler();

        // Se establecen las relaciones de encadenamiento entre los manejadores.
        managerHandler.setNextHandler(comercialHandler);
        comercialHandler.setNextHandler(technicalHandler);
        technicalHandler.setNextHandler(spamHandler);

        // Se devuelve el primer manejador de la cadena.
        return managerHandler;
    }

    // Constructor que inicializa la cadena de responsabilidad.
    public CheckEmail() {
        this.chain = createChain();
    }

    // Método público para iniciar el proceso de manejo de un correo electrónico.
    public String checkEmail(Email email) {
        // Se inicia el procesamiento del correo electrónico a través de la cadena de responsabilidad.
        return chain.handleRequest(email);
    }
}

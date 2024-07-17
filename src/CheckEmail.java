/*
Esta clase forma parte del patrón de diseño Cadena de Responsabilidad
La clase chequeará el manejo de mail dependiendo de su destino o tema.
*/
public class CheckEmail {

    //Representa el primer manejador en la cadena de responsabilidad.
    private Handler handler;

    // Constructor que inicializa la cadena de responsabilidad.
    public CheckEmail() {

        //Se inicia la cadena de responsablidad
        handler = new ManagerHandler();

        //Construímos la cadena
        Handler comercialHandler = new ComercialHandler();
        Handler technicalHandler = new TechnicalHandler();
        Handler spamHandler = new SpamHandler();

        //Unimos la cadena
        handler.setNextHandler(comercialHandler);
        comercialHandler.setNextHandler(technicalHandler);
        technicalHandler.setNextHandler(spamHandler);
    }

    // Método público para iniciar el proceso de manejo de un correo electrónico.
    public String checkEmail(Email email) {
        // Se inicia el procesamiento del correo electrónico a través de la cadena de responsabilidad.
        return handler.handleRequest(email);
    }
}

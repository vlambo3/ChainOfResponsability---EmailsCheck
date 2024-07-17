/*
Esta clase abstracta forma parte del patrón de diseño Cadena de Responsabilidad
Este patrón se usa cuando se necesita procesar una solicitud de forma flexible,
pasándola a través de una serie de objetos (handlers) que pueden manejarla de forma
independiente.
*/
public abstract class Handler {

    /*
    El atributo 'nextHandler' es una referencia a otro objeto del mismo tipo
    Este atributo permite que un objeto del mismo tipo 'Handler',
    pase una solicitud a otro 'Handler' en la cadena.
    Modificador de Acceso: 'protected'
    Se utiliza porque permite que las subclases y clases dentro del mismo
    paquete accedan directamente al siguiente manejador, facilitando la
    implementación y extensión del patrón
     */
    protected Handler nextHandler;


    /*
    Éste método se usa para establecer cuál es el siguiente manejador en la cadena
    si el manejador actual no puede manejarla.
    */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /*
    Éste método lo deben implementar las subclases
    El parámetro 'email' representa el correo electrónico que se está procesando, y es
    necesario para que cada subclase de 'Handler' defina como manejar ese correo
    electrónico según sus reglas específicas.
    */
    public abstract String handleRequest(Email email);

}

package oop2.tp3.ejercicio5;

public abstract class Actuacion {
    private String nombreEvento;
    private int numeroEspectadores;
    public Actuacion(String nombreEvento, int numeroEspectadores){
        this.nombreEvento=nombreEvento;
        this.numeroEspectadores=numeroEspectadores;
    }
    public abstract float calcularMonto();

    //Plantilla
    public final float calcularCreditos(){
        float credito = Math.max(this.getNumeroEspectadores() - 30, 0);
        return credito+adicionalCreditos(); //Delega en las subclases
    }

    public abstract float adicionalCreditos();

    String getNombreEvento(){
        return this.nombreEvento;
    }

    int getNumeroEspectadores(){
        return this.numeroEspectadores;
    }
}

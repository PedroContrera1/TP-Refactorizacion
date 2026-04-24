package oop2.tp3.ejercicio5;

public class Comedia extends Actuacion {
    public Comedia (String nombreEvento, int numeroEspectadores){
        super(nombreEvento, numeroEspectadores);
    }
    @Override
    public float calcularMonto() {
        float monto = 30000;
        if (this.getNumeroEspectadores() > 20) {
            monto += 10000 + 500 * (this.getNumeroEspectadores() - 20);
        }
        monto += 300 * this.getNumeroEspectadores();
        return monto;
    }

    @Override
    public float adicionalCreditos() {
        return (float)Math.floor(this.getNumeroEspectadores() / 5);
    }
}

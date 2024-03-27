
/**
 *Representa las coordenadas (x, y) en el espacio bidimensional.
 */
public class Coordenada
{
    private int x;
    private int y;

    /**
     * Constructor  que inicializa las coordenadas.
     */
    public Coordenada(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    /**
     * Devuelve una representación en cadena de la coordenada en el formato (x, y).
     */
    public String toString(){
        return "("+x+" , "+y+")"+"\n";
    }
}

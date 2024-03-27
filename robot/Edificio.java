import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Representa el edificio con pasillos libres (L), pasillos estrechos (E) y la posición del tornillo (T).
 * Contiene métodos para resolver el edificio y encontrar el camino desde la entrada hasta el tornillo.
 */
public class Edificio
{
    private char[][] datos;
    private boolean[][] visitados;
    private int filas;
    private int columnas;

    /**
     *  Constructor que inicializa el edificio con sus dimensiones y datos.
     */
    public Edificio(int filas, int columnas, char[][] datos)
    {
        this.filas=filas;
        this.columnas=columnas;
        this.datos=datos;
        this.visitados=new boolean[filas][columnas];
    }
    /**
     *  Método principal que inicia la búsqueda del tornillo y devuelve una lista de coordenadas 
     *  que representan el camino desde la entrada hasta el tornillo.
     */
    public List<Coordenada> resolverEdificio(boolean trace){
        List<Coordenada> solucion = new ArrayList<>();
        boolean exito = buscarTornillo(1, 1, solucion, trace);
        
        if(!exito){
            System.out.print("No se encontro un camino hasta el tornillo");
        }
        
        return solucion;
    }    
    /**
     * Método que inicia la búsqueda del tornillo utilizando un enfoque de vuelta atrás.
     */
    private boolean buscarTornillo(int x, int y, List<Coordenada> solucion, boolean trace){
        Stack<Coordenada> camino = new Stack<>();
        boolean exito = buscarRecursivo(x, y, camino,trace);
        
        if(exito){
            while(!camino.isEmpty()){
                solucion.add(camino.pop());
            }
        }
        return exito;
    }
    /**
     * Método recursivo que realiza la búsqueda del tornillo. Se utiliza en conjunto
     * con buscarTornillo.
     */
    private boolean buscarRecursivo(int x, int y, Stack<Coordenada> camino, boolean trace){
        if (trace) {
            System.out.println("Explorando: (" + x + ", " + y + ")");
        }
        
        if(x<1 ||x>filas || y<1 || y>columnas){
            if (trace) {
                System.out.println("Fuera de los límites");
            }
            return false;
        }
        if(datos[x-1][y-1] == 'T'){
            camino.push(new Coordenada(x,y));
            if (trace) {
                System.out.println("¡Tornillo encontrado!");
            }
            return true;
        }
        if(datos[x-1][y-1] == 'E' || visitados[x-1][y-1]){
            if (trace) {
                System.out.println("Paso estrecho o ya visitado");
            }
            return false;
        }
        visitados[x-1][y-1] = true;
        
        if(buscarRecursivo(x-1, y, camino, trace) ||
           buscarRecursivo(x+1, y, camino, trace) ||
           buscarRecursivo(x, y+1, camino, trace)){
            camino.push(new Coordenada(x,y));
               if (trace) {
                System.out.println("Movimiento hacia atrás");
            }
               return true;
           }
           return false;
    }
    }

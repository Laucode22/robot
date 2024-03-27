import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;

/**
 * Maneja la entrada de datos, ya sea desde un archivo o desde la consola.
 */

public class FEntrada
{
    /**
     * Lee el edificio desde un archivo y devuelve una instancia de la clase Edificio.
     */
    public static Edificio cargarEdificioDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int filas = Integer.parseInt(br.readLine());
            int columnas = Integer.parseInt(br.readLine());

            char[][] datos = new char[filas][columnas];

            for (int i = 0; i < filas; i++) {
                String fila = br.readLine();
                datos[i] = fila.replaceAll("\\s", "").toCharArray();
            }

            return new Edificio(filas, columnas, datos);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lee el edificio desde la consola y devuelve una instancia de la clase Edificio.
     */
    public static Edificio leerEdificioDesdeConsola(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("1.Introduce el numero de filas: \n");
            System.out.print("2.Introduce el numero de columnas:\n");
            System.out.print("3.Introduce los datos del edificio (L,E,T):\n");
            
            int filas=Integer.parseInt(br.readLine());
            int columnas=Integer.parseInt(br.readLine());
            char[][] datos = new char[filas][columnas];
            
            for(int i = 0; i<filas; i++){
                String fila = br.readLine();
                datos[i] = fila.replaceAll("\\s","").toCharArray();
            }
            
            return new Edificio(filas, columnas, datos);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
}

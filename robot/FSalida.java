import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Maneja la salida de resultados, ya sea imprimiendo en la consola o escribiendo en un archivo.
 */
public class FSalida
{
    /**
     *  Escribe las coordenadas de la solución en un archivo, 
     *  anexando al contenido existente si el archivo ya existe.
     */
    public static void escribirSalida(String outputFile, List<Coordenada> solucion) {
        // El segundo parámetro indica que se debe anexar al archivo existente
        try (FileWriter writer = new FileWriter(outputFile, true)) { 
            for (Coordenada coordenada : solucion) {
                writer.write(coordenada.toString()); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Objetivo: Muestra información de ayuda sobre la sintaxis del programa y las opciones disponibles.
     */
    public static void mostrarAyuda(){
        System.out.println("SINTAXIS:java -jar CambioDinamica.jar [-t][-h] [fichero entrada] [fichero salida]");
        System.out.println("-t Traza el algoritmo");
        System.out.println("-h Muestra esta ayuda");
        System.out.println("[fichero entrada] Nombre del fichero de entrada");
        System.out.println("[fichero salida] Nombre del fichero de salida");
        System.exit(0);
    }
}

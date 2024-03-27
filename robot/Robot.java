import java.util.List;
import java.util.Collections;
/**
 * Punto de entrada principal para la ejecución del programa.
 */
public class Robot
{
      /**
       * Realiza la lógica principal del programa. Verifica los argumentos de entrada, 
       * lee el edificio, resuelve el edificio y escribe los resultados.
       */
    public static void main(String[] args){
        
        // Verificar la cantidad correcta de argumentos
        if (args.length > 4) {
            FSalida.mostrarAyuda();
            return;
        }
        
        // Verificar si se proporciona el argumento -t para habilitar trazas
        boolean trace = false;
        // boolean trace = args.length > 0 && args[0].equals("-t");
        int startIndex = 0;
        if (args.length > 0 && args[0].equals("-t")) {
            trace = true;
            startIndex = 1;
        }
        // Verificar la opción de ayuda
        if (args.length > startIndex && args[startIndex].equals("-h")) {
            FSalida.mostrarAyuda();
            return;
        }
        // Leer el nombre del archivo de entrada y salida
        String inputFile = args.length > startIndex && !args[startIndex].equals("-t") ? args[startIndex] : null;
        if (trace) {
            System.out.println("Iniciando búsqueda con traza...");
        }
        Edificio edificio;
        
        if(inputFile != null){
            // Leer desde el archivo de entrada
            System.out.print("\n Se ha leido el archivo desde entrada \n");
            edificio = FEntrada.cargarEdificioDesdeArchivo(inputFile);
        }else{
            // Leer desde la entrada estándar
            edificio = FEntrada.leerEdificioDesdeConsola();
       }
       
       List<Coordenada> solucion = edificio.resolverEdificio(trace);
       Collections.reverse(solucion);
       String outputFile = (args.length > (startIndex + 1)) ? args[startIndex + 1] : null;
       
       if(outputFile != null){
           // Escribir en el archivo de salida
           System.out.print("\n Se ha escrito en el archivo de salida \n");
           FSalida.escribirSalida(outputFile, solucion);
       }else{
          // Imprimir la solución en la consola
          for(Coordenada coordenada: solucion){
              System.out.print("\n Se va a imprimir la solucion a continuacion: \n");
              System.out.print(coordenada);
          }
       }
     
     
}
}

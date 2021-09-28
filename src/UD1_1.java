/*Adjunto a este enunciado se te facilitará un fichero de texto que contendrá un registro por línea.
Dentro de este fichero se encuentran nombres de personas ficticias.
De este fichero deberás seleccionar diez nombres de manera aleatoria, es decir, no debes seleccionar
        los diez primeros sino que en cada ejecución de tu programa deberá aparecer una lista de personas distinta.
Para cada una de estas personas ficticias deberás inventarte una lista de cuatro calificaciones aleatorias entre
        0 y 10. Las calificaciones podrán tener decimales. Con esas calificaciones tendrás que calcular la media de cada alumno.
El cálculo de la media consiste en sumar las cuatro calificaciones y dividirlas entre cuatro.
Para finalizar, tendrás que mostrar por pantalla una fila por cada estudiante con sus cuatro calificaciones y su media.
Esta misma información tendrás que guardarla en un fichero en el mismo directorio donde se encuentre el ejecutable del programa.*/

import java.io.*;
import java.util.ArrayList;

public class UD1_1 {
    public static void main(String[] args) {
        final String RUTA_ENTRADA = "C:\\Users\\Sergio\\Clases\\2DAM\\Programacion Multimedia\\Tema 1\\UD1-1\\src\\Listado.csv";
        final String RUTA_SALIDA = "C:\\Users\\Sergio\\Clases\\2DAM\\Programacion Multimedia\\Tema 1\\UD1-1\\src\\ListadoFinal.csv";
        final short CANTIDAD_ALUMNOS = 10;

        ArrayList<String> arrAlumnos = listPicks(listToArrayList(RUTA_ENTRADA), CANTIDAD_ALUMNOS);

        File fichero = new File(RUTA_SALIDA);
        PrintWriter pw = null;

        if (fichero.exists()) fichero.delete();

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pw = new PrintWriter(RUTA_SALIDA);
            for (int i=0; i<(CANTIDAD_ALUMNOS); i++) {
                Alumno alumno = new Alumno(arrAlumnos.get(i));

                String nota1Formateada = String.format("%.02f", alumno.getNota1());
                String nota2Formateada = String.format("%.02f", alumno.getNota2());
                String nota3Formateada = String.format("%.02f", alumno.getNota3());
                String nota4Formateada = String.format("%.02f", alumno.getNota4());
                String mediaFormateada = String.format("%.02f", alumno.getMedia());

                String linea = "Alumno/a: " + alumno.getNombre() +
                        "; Notas: " + nota1Formateada + ", " + nota2Formateada + ", "
                        + nota3Formateada + ", " + nota4Formateada + "; Media: " + mediaFormateada;

                System.out.println(linea);
                pw.println(linea);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null)
                    pw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //Esta función recibe como parámetro un String correspondiente a una ruta y devuelve un ArrayList de String
    // con los elementos que contenga ese archivo.
    public static ArrayList<String> listToArrayList(String ruta) {
        BufferedReader br = null;
        ArrayList<String> arrNombres = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(ruta));

            String linea;
            while ((linea = br.readLine()) != null) {
                arrNombres.add(linea);
            }
            arrNombres.remove(0);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrNombres;
    }

    //Esta función recibe como parámetro un ArrayList de String y devuelve otro array pero sacando un número
    // establecido de elementos aleatorios de dicha lista.
    public static ArrayList<String> listPicks(ArrayList<String> arr, int picks) {
        ArrayList<String> arrFinal = new ArrayList<>();
        for (int i=0; i<picks; i++) {
            short num = (short)(Math.random()*arr.size());
            arrFinal.add(arr.get(num));
            arr.remove(num);
        }
        return arrFinal;
    }
}

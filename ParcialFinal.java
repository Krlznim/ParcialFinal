/******************************************************************************
Carlos Andres Gòmez Centeno
*******************************************************************************/
import java.util.Scanner;
import java.util.Random;

public class ParcialFinal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int MAX = 10;
		String[][] matrizAspirantes = new String[MAX][5];
		
		int contador = 0;
		int añoActual= 2026;
		int opcion = 0;
		
		do {
		    System.out.println(" MENU PRINCIPAL");
		    System.out.println("1. Adicionar aspirante");
		    System.out.println("2. Mostrar aspirantes");
		    System.out.println("3. Seleccionar aspirante al azar y evaluar su edad");
		    System.out.println("4. Extraer cèdulas a un vector");
		    System.out.println("5. Terminar");
		    System.out.print("Elija una opcion: ");
		    
		    opcion = scanner.nextInt();
		    scanner.nextLine();
		    
		    switch (opcion) {
		        case 1:
		            if (contador >= MAX){
		                System.out.println("La matriz ya esta llena (10 personas) no se puede ingresar mas ");
		            } else {
		                System.out.println(" Ingresando aspirante " + (contador + 1) + " de 10 ");
		                
		                System.out.print("Digite la cedula: ");
		                matrizAspirantes[contador][0] = scanner.nextLine();
		                
		                System.out.print("Digite el nombre: ");
		                matrizAspirantes[contador][1] = scanner.nextLine();
		                
		                System.out.print("Digite el año de nacimiento: ");
		                matrizAspirantes[contador][2] = scanner.nextLine();
		                
		                System.out.print("Digite el genero: ");
		                matrizAspirantes[contador][3] = scanner.nextLine();
		                
		                System.out.print("Digite la profesion: ");
		                matrizAspirantes[contador][4] = scanner.nextLine();
		                
		                contador++;
		                System.out.println("Aspirante guardado con exito!!!");
		                
		            }
		            break;
		        case 2:
		            if (contador == 0) {
		                System.out.println("No hay ningun aspirante ingresado todavia");
		            } else {
		                System.out.println(" LISTA DE ASPIRANTES ");
		                for (int i = 0; i < contador; i++) {
		                    System.out.println("Aspirante #" + (i + 1));
		                    System.out.println(" Cedula: " + matrizAspirantes[i][0]);
		                    System.out.println(" Nombre: " + matrizAspirantes[i][1]);
		                    System.out.println(" Año: " + matrizAspirantes[i][2]);
		                    System.out.println(" Genero: " + matrizAspirantes[i][3]);
		                    System.out.println(" Profes: " + matrizAspirantes[i][4]);
		                    
		                }
		            }
		            break;
		            
		        case 3:
		            if (contador == 0) {
		                System.out.println("Debe ingresar aspirante aspirante primero para hacer el sorteo.");
		            } else {
		                int numAleatorio = random.nextInt(10) + 1;
		                int fila = numAleatorio - 1;

                        System.out.println("\nNúmero aleatorio generado: " + numAleatorio);

                        if (fila >= contador) {
                            System.out.println("La posición #" + numAleatorio + " está vacía (solo hay " + contador + " personas registradas).");
                        } else {
                            System.out.println("Aspirante seleccionado en la posición #" + numAleatorio + ":");
                            System.out.println("  Nombre: " + matrizAspirantes[fila][1]);
                            System.out.println("  Año de nacimiento: " + matrizAspirantes[fila][2]);

                            int sumaEdades = 0;
                            for (int i = 0; i < contador; i++) {
                                int anioNacimiento = Integer.parseInt(matrizAspirantes[i][2]);
                                int edadPersona = añoActual - anioNacimiento;
                                sumaEdades += edadPersona;
                            }

                            double promedio = (double) sumaEdades / contador;
                            
                            int edadSeleccionado = añoActual - Integer.parseInt(matrizAspirantes[fila][2]);

                            System.out.println("\nPromedio de edad del grupo: " + promedio);
                            System.out.println("Edad del seleccionado: " + edadSeleccionado);

                            if (edadSeleccionado > promedio) {
                                System.out.println("Mensaje: El aspirante seleccionado es MAYOR que el promedio del grupo.");
                            } else if (edadSeleccionado < promedio) {
                                System.out.println("Mensaje: El aspirante seleccionado es MENOR que el promedio del grupo.");
                            } else {
                                System.out.println("Mensaje: El aspirante tiene EXACTAMENTE la misma edad del promedio.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- EXTRACCIÓN DE CÉDULAS A UN VECTOR ---");
                    String[] vectorCedulas = new String[MAX];

                    for (int i = 0; i < MAX; i++) {
                        vectorCedulas[i] = matrizAspirantes[i][0];
                    }

                    System.out.print("Vector de cédulas: [");
                    for (int i = 0; i < MAX; i++) {
                        System.out.print(" " + (vectorCedulas[i] != null ? vectorCedulas[i] : "null") + " ");
                    }
                    System.out.println("]");
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
		
	}
}

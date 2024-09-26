import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            Scanner teclado = new Scanner(System.in);
            String separator = "************************";
            String msg1 = "Ingrese la cantidad a convertir: ";
            System.out.println(separator);
            System.out.println("Conversor de moneda\n");
            System.out.println("1) Dólar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dólar");
            System.out.println("3) Dólar -> Real brasileño");
            System.out.println("4) Real brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Salir\n");
            System.out.println("Elija una opción válida");
            System.out.println(separator);
            int opcionValida = teclado.nextInt();
            if (opcionValida == 7) {
                System.out.println("Hasta luego!");
                break;
            }
            switch (opcionValida) {
                case 1:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "USD", "ARS");
                    break;
                case 2:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "ARS", "USD");
                    break;
                case 3:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "USD", "BRL");
                    break;
                case 4:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "BRL", "USD");
                    break;
                case 5:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "USD", "COP");
                    break;
                case 6:
                    System.out.println(msg1);
                    Caller.convert(teclado.nextDouble(), "COP", "USD");
                    break;

            }
        }
    }
}

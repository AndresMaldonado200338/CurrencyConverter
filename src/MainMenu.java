import java.io.IOException;
import java.util.Scanner;


public class MainMenu {
    CheckCurrency checkCurrency = new CheckCurrency();


    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("""
                    
                    -------------Bienvenido al conversor de moneda-------------
                    
                    Por favor ingrese la opción de conversion que desee:
                    
                    1)Dolar --> Peso Argentino
                    2)Peso Argentino --> Dolar
                    3)Peso Mexicano --> Dolar
                    4)Dolar  --> Peso Mexicano
                    5)Peso Colombiano --> Peso Mexicano
                    6)Peso Mexicano --> Euro
                    7)Euro --> Peso Mexicano
                    8)Salir
                    """
            );
            option = scanner.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("USD", "ARS", scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("ARS", "USD", scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("MXN", "USD", scanner.nextDouble());
                    break;
                case 4:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("USD", "MXN", scanner.nextDouble());
                    break;
                case 5:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("COP", "MXN", scanner.nextDouble());
                    break;
                case 6:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("MXN", "EUR", scanner.nextDouble());
                    break;
                case 7:
                    System.out.println("Ingrese por favor la cantidad a convertir:");
                    convert("EUR", "MXN", scanner.nextDouble());
                    break;
                case 8:
                    System.out.println("Gracias por usar el conversor de moneda.");
                    return;
            }
        }
    }

    private void convert(String base, String result, double quantity) {
        try {
            Coin coin = checkCurrency.requestAPI(base, result, quantity);
            if (coin.conversion_result() != null) {
                System.out.println("Conversion exitosa.");
                System.out.println(quantity + " " + base + " a " + result + " = " + coin.conversion_result());
            } else System.out.println("Error en la conversion");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
    }
}

package com.nilsen.conversorMonedas.Util;

public class MenuUtil {
    public static void opciones(){
        System.out.println("""
                        1) ARS - Peso argentino               
                        2) BOB - Boliviano boliviano           
                        3) BRL - Real brasileño             
                        4) CLP - Peso chileno                  
                        5) COP - Peso colombiano                   
                        6) MXN - Peso mexicano
                        7) USD - Dólar estadounidense
                    
                        8) Salir
                    """);
    }

    public static String seleccionMoneda(int option){
        String moneda;

        switch (option) {
            case 1:
                moneda = "ARS";
                break;

            case 2:
                moneda = "BOB";
                break;
            case 3:
                moneda = "BRL";
                break;

            case 4:
                moneda = "CLP";
                break;

            case 5:
                moneda = "COP";
                break;
            case 6:
                moneda = "MXN";
                break;

            case 7:
                moneda = "USD";
                break;

            default:
                System.out.println("Valor invalido\n");
                moneda = null;
                break;

        }
        return moneda;
    }


}

package com.nilsen.conversorMonedas.Main;

import com.google.gson.Gson;
import com.nilsen.conversorMonedas.DatosParMonedas;
import com.nilsen.conversorMonedas.HttpRequestApi;

import com.nilsen.conversorMonedas.Util.InputUtil;
import com.nilsen.conversorMonedas.Util.MenuUtil;

import java.math.BigDecimal;
import java.util.Scanner;

public class Monetix {
    public static void main(String[] args) {
        final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
        final String API_KEY = System.getenv("EXCHANGE_RATE_API_KEY");
        final var scanner = new Scanner(System.in);

        String url;
        HttpRequestApi enchangeRateApi = new HttpRequestApi();
        Gson gson = new Gson();
        String json;

        if (API_KEY == null) {
            throw new IllegalStateException("La variable de entorno EXCHANGE_RATE_API_KEY no está configurada.");
        }

        System.out.println("""
        *********** Bienvenidos a Monetix ***********
           Descubre el valor de una moneda en otra
        """);

        while(true){
            var option = 0;
            BigDecimal cantidad = null;
            String monedaOrigen = null;
            String monedaDestino = null;

            System.out.println("Ingrese la opción de la moneda de origen de interes:");
            MenuUtil.opciones();
            do {
                option= InputUtil.leerOpcion();
                if(option == 8){
                    return;
                }
                monedaOrigen = MenuUtil.seleccionMoneda(option);
            }while(monedaOrigen == null);

            System.out.println("Ingrese la opción de la moneda de destino de interes:");
            MenuUtil.opciones();
            do {
                option = 0;
                option = InputUtil.leerOpcion();
                if (option == 8) {
                    return;
                }
                monedaDestino = MenuUtil.seleccionMoneda(option);

            }while(monedaDestino == null);

            do {
                System.out.println("Ingrese la cantidad a convertir: ");
                try {
                    cantidad = new BigDecimal(scanner.nextLine());
                    url = URL_BASE + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad;

                    json = enchangeRateApi.obtenerDatos(url);

                    DatosParMonedas datos = gson.fromJson(json, DatosParMonedas.class);

                    if (datos.result().equals("error")) {
                        System.out.println("Ocurrió un error | " + datos.errorType());
                    } else {
                        System.out.println("\n" + cantidad + "[" + monedaOrigen + "]" + " es igual a " + datos.conversion_result()
                                + "[" + monedaDestino + "]");

                        System.out.println("¿Desea realizar otra conversión? (S/N)");
                        boolean validar = scanner.next().equalsIgnoreCase("S");
                        scanner.nextLine();

                        if (!validar) {
                            System.out.println("Vuelva pronto :)");
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor no reconocido | " + e.getMessage());
                }
            }while(cantidad == null);
        }
    }
}



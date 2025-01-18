<h1>Conversor de Monedas</h1>
<h3>Challenge | Oracle Next Education</h2>


## Descripción general

El programa permite al usuario convertir una cantidad de una moneda a otra utilizando las tasas de cambio actuales proporcionadas por una API externa. La aplicación realiza lo siguiente:

### Interacción con el usuario:
- El programa solicita al usuario seleccionar una moneda de origen y una moneda de destino.
- Luego, el usuario ingresa la cantidad de la moneda de origen que desea convertir.

### Uso de HTTP para consultar la API:
- Utiliza la clase `HttpRequestApi` para enviar una solicitud HTTP GET a un servicio de API (en este caso, ExchangeRate-API).
- La URL de la API incluye la clave de la API y los parámetros necesarios, como la moneda de origen, la moneda de destino y la cantidad a convertir.
- La URL se construye dinámicamente a partir de la entrada del usuario.

### Procesamiento de la respuesta de la API:
- La respuesta de la API se recibe en formato JSON, que contiene los resultados de la conversión, como el valor de la conversión y la tasa de cambio.
- El JSON recibido es procesado por `Gson` para convertirlo en objetos Java, como `DatosParMonedas`, que contienen la información de la conversión.

## Enfoque técnico

### Uso de la API (REST):
La API utilizada (ExchangeRate-API) es un servicio de tipo REST que expone un endpoint para obtener tasas de conversión de monedas. El programa interactúa con esta API enviando solicitudes HTTP y obteniendo las respuestas en formato JSON.

Puede obtener su llave en https://www.exchangerate-api.com/

### Gson para parseo JSON:
Se utiliza la librería `Gson` para convertir la respuesta JSON de la API a un objeto Java que facilita el manejo de los datos. Esto permite mapear fácilmente los campos del JSON a las variables del objeto `DatosParMonedas`.

## Flujo de la aplicación

1. El usuario inicia el programa.
2. Se le solicita seleccionar la moneda de origen y la moneda de destino mediante opciones numeradas.
3. El usuario ingresa la cantidad de la moneda que desea convertir.
4. El programa realiza una solicitud HTTP a la API con esos datos.
5. El programa recibe la respuesta JSON de la API y extrae los datos relevantes.
6. Muestra el resultado al usuario.
7. El usuario puede decidir si hacer otra conversión o salir.
![image](https://github.com/user-attachments/assets/e946bc9b-4090-4062-81fe-76eac7c6d1e6)
![image](https://github.com/user-attachments/assets/d3074af3-1fea-4855-ba02-b5f0c0c0c933)

## Conclusión

Este programa aprovecha el uso de HTTP para interactuar con un servicio API externo y obtener datos actualizados sobre tasas de cambio en tiempo real. Es una aplicación de consola que utiliza herramientas comunes en Java, como `Gson` para manejar JSON y `HttpURLConnection` para hacer solicitudes HTTP.


# 💱 Conversor de Monedas en Java

Este proyecto es una aplicación de consola escrita en Java que permite convertir entre distintas monedas utilizando tasas de cambio reales obtenidas desde una API externa. Está diseñado como una práctica de consumo de APIs, deserialización con Gson y aplicación de conceptos de programación orientada a objetos.

## 🚀 Funcionalidades principales
- Selección interactiva de monedas desde consola
- Conversión entre distintas divisas con tasas actualizadas
- Consulta de la última actualización de tasas
- Cálculo de la siguiente actualización estimada
- Manejo de errores y opciones de salida seguras

⸻

## 📦 Tecnologías y librerías
- Java 17+
- Gson (para deserializar respuestas JSON)
- HTTPClient (nativo de Java 11+ para hacer peticiones)
- API de tasas de cambio (por ejemplo: ExchangeRate-API o similar)

⸻

## 🧭 Cómo usarlo
1.	Clona el repositorio:
   
``` bash 
git clone https://github.com/alonso1298/Conversor-De-Monedas.git
cd Conversor-De-Monedas
```
2. Abre el proyecto en tu IDE favorito (IntelliJ, VS Code, NetBeans).
3. Compila y ejecuta la clase principal:

``` bash
javac ConversorDeMonedas.java
java ConversorDeMonedas
```
(El nombre exacto de la clase principal puede variar; ajústalo según el archivo que contiene el método main).

## 🧠 Estructura del proyecto
``` txt
Conversor-De-Monedas/
├── src/
│   ├── ConversorDeMonedas.java       # Lógica de interacción por consola
│   ├── TasaCambio.java               # Clase modelo para las tasas
├── gson-2.10.1.jar                   # Librería Gson (si se incluye manualmente)
├── README.md
```

## 🧪 Ejemplo de uso
``` txt
Bienvenido al Conversor de Monedas
1. USD a EUR
2. EUR a MXN
3. Ver última actualización
4. Salir

Seleccione una opción:
> 1
Ingrese la cantidad: 100
Resultado: 92.57 EUR
```

## 📝 Notas
•	El proyecto podría requerir conexión a Internet para obtener las tasas actualizadas.
•	Asegúrate de incluir tu propia clave de API en caso de que el servicio la requiera.

## 📄 Licencia
Este proyecto está bajo la licencia MIT. Puedes usarlo y modificarlo libremente.

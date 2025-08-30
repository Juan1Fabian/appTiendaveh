# App Tienda de Vehículos

`appTiendaveh` es una aplicación Android para gestionar un inventario de vehículos. Permite registrar, listar (con búsqueda) y buscar vehículos por placa, interactuando con una API backend.

## Funcionalidades

*   **Registrar Vehículo:** Guarda nuevos vehículos en la API (marca, modelo, color, precio, placa).
*   **Listar Vehículos:** Muestra todos los vehículos desde la API, con filtro de búsqueda en tiempo real.
*   **Buscar por Placa:** Busca y muestra un vehículo específico por su placa.

## Componentes Clave

*   **`Registrar.java` (`activity_registrar.xml`):** Para añadir nuevos vehículos.
*   **`Listar.java` (`activity_listar.xml`):** Para ver todos los vehículos y filtrar la lista.
*   **`Buscar.java` (`activity_buscar.xml`):** Para buscar un vehículo por su placa.

## Tecnología

*   **Lenguaje:** Java
*   **Red:** Volley (para peticiones HTTP a la API)
*   **UI:** Componentes estándar de Android (EditText, Button, ListView, SearchView).

## API Backend Requerida

La aplicación necesita una API con los siguientes endpoints:

*   **`POST /vehiculos`**: Registrar vehículo.
*   **`GET /vehiculos`**: Listar todos los vehículos.
*   **`GET /vehiculos/placa/:placa`**: Buscar vehículo por placa.

---
## **¡IMPORTANTE! Configuración de la URL de la API**

Para que la aplicación funcione, **debes configurar correctamente la dirección IP y el puerto de tu servidor API** en los archivos Java.

1.  **Abre los siguientes archivos en Android Studio:**
    *   `Registrar.java`
    *   `Listar.java`
    *   `Buscar.java`

2.  **Localiza la variable de la URL:** Busca líneas que definan la URL del servicio, como `URL` o `BASE_URL`.

3.  **Modifica la IP y el Puerto:**
    *   **Si usas un emulador de Android** y tu servidor API corre en la misma computadora:
        Reemplaza la IP por `10.0.2.2`. Ejemplo:
        `String URL_API = "http://10.0.2.2:TU_PUERTO_SERVIDOR/vehiculos";`
    *   **Si usas un dispositivo Android físico** (conectado a la misma red Wi-Fi que tu computadora donde corre el servidor API):
        Reemplaza la IP por la **dirección IP local de tu computadora** en la red. Ejemplo:
        `String URL_API = "http://192.168.1.5:TU_PUERTO_SERVIDOR/vehiculos";`
        (Para encontrar la IP de tu PC/Mac: en Windows usa `ipconfig`, en macOS/Linux usa `ifconfig` o `ip addr`).
    *   Reemplaza `TU_PUERTO_SERVIDOR` con el número de puerto que tu API está usando (ej. `3000`).

**Ejemplo de URL para `Buscar.java` (endpoint con `/placa/`):**
`String urlBaseServicio = "http://10.0.2.2:3000/vehiculos/placa/";`

---

## Para Empezar

1.  Abre el proyecto en Android Studio.
2.  **Configura la URL de la API como se describe arriba.**
3.  Asegúrate de que tu servidor API backend esté en ejecución.
4.  Construye y ejecuta la app.

## AUTOR

# JUAN FABIAN TRUCIOS QUISPE

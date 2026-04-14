# Proyecto de Automatización con Selenium: SauceDemo

Este proyecto consiste en la automatización de pruebas de login para la plataforma **SauceDemo** utilizando Java, Selenium WebDriver y JUnit 5. Se ha implementado el patrón de diseño **Page Object Model (POM)** para garantizar un código mantenible y escalable.

## 📂 Estructura del Proyecto

```text
MiprimerSelenium/
├── src/
│   └── test/
│       └── java/
│           ├── pages/          # Clases con la lógica de las páginas (POM) 
│           │   ├── LoginPage.java
│           │   └── LoginPage2.java # Clase que se pide en la tarea
│           └── test/           # Clases que contienen los casos de prueba (JUnit)
│               ├── LoginTest.java
│               └── LoginTest2.java # Clase que se pide en la tarea
├── .gitignore                  # Archivos excluidos del control de versiones
├── pom.xml                     # Configuración de dependencias (Selenium 4.41, JUnit 5)
└── README.md                   # Documentación del proyecto
```

## Respuestas a las Cuestiones

### 1. ¿Qué hace la anotación `@BeforeEach`?
Es una anotación de JUnit 5 que indica que el método marcado debe ejecutarse **antes de cada test** individualmente. Su función principal es preparar el entorno de prueba (instanciar el WebDriver, maximizar la ventana y navegar a la URL base) para asegurar que cada caso de prueba comience desde un estado limpio y conocido.

### 2. ¿Para qué sirve `assertTrue`?
Es una **aserción** de JUnit que verifica si una condición booleana es verdadera. Si la condición se cumple, el test continúa con éxito; si es falsa, el test falla inmediatamente y muestra un mensaje de error opcional. En este proyecto, lo usamos para validar que la URL contiene "inventory" o que el mensaje de error es el correcto.

### 3. ¿Qué diferencia hay entre `findElement()` y `findElements()`?
* **`findElement()`**: Busca en el DOM el **primer** elemento que coincida con el localizador proporcionado. Si no encuentra nada, lanza una excepción (`NoSuchElementException`).
* **`findElements()`**: Busca **todos** los elementos que coincidan y devuelve una `List<WebElement>`. Si no encuentra ninguno, devuelve una lista vacía en lugar de lanzar una excepción, lo que es útil para verificar la existencia (o no) de elementos sin romper la ejecución.

### 4. ¿Por qué utilizamos una clase `LoginPage` en lugar de escribir todo en el test?
Para implementar el patrón **Page Object Model (POM)**. Esto separa la lógica de la página de la lógica del test. Las ventajas principales son:
* **Mantenimiento**: Si la web cambia un ID, solo lo corregimos en la clase Page una vez.
* **Reutilización**: Diferentes tests pueden usar los mismos métodos de login.
* **Legibilidad**: El código del test es mucho más limpio y fácil de entender para alguien que no sea técnico.

---
##  Tecnologías utilizadas
* **Lenguaje**: Java 25
* **Framework de Testing**: JUnit 5
* **Automatización**: Selenium WebDriver
* **Navegador**: Google Chrome (ChromeDriver)
* **Build Tool**: Maven
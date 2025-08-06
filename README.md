# Proyecto Interfaz de Bienestar para Jóvenes Universitarios

## 🛑 ¿Por qué no se puede convertir directamente un formulario de Java a HTML?

En el desarrollo de software, los formularios son una parte fundamental para capturar datos del usuario. Sin embargo, no todos los formularios se crean igual. Un formulario hecho en Java usando Swing en NetBeans **no puede convertirse automáticamente a HTML**, ya que ambas tecnologías operan en entornos y lenguajes completamente distintos.

| Característica | Java Swing NetBeans | HTML (Servidor Web) |
| --- | --- | --- |
| Tipo de aplicación | Escritorio (GUI local) | Web (se ejecuta en navegador) |
| Lenguaje principal | Java | HTML + CSS + JavaScript |
| Entorno de ejecución | JVM (Java Virtual Machine) | Navegador Web |
| Componentes | `JButton`, `JTextField`, `JLabel`  | `<button>`, `<input>`, `<label>` |
| Gestión de eventos | `ActionListener`  | JavaScript (`addEventListener`) |

**Integrantes:** 

López Bautista Miguel Angel

Barragán Yescas José Francisco

**Introducción:**

Los jóvenes universitarios en esta nueva etapa pasan por diferentes problemas emocionales y situaciones que les generan ansiedad, estrés, miedo, tristeza, depresión, enojo, frustración, entre otros problemas. Esto debido a diferentes motivos como la transición inmediata a la etapa adulta, las enormes exigencias que exige la universidad tanto académicas como económicas, las altas expectativas que suele tener tanto la familia como las personas en la sociedad, la grande carga de trabajos y horarios pesados, entre otros motivos.

EmotiUni es una interfaz de Bienestar Universitario que busca ayudar a esos estudiantes a tener un mejor manejo de sus emociones con pequeños campos y áreas que se enfocan en darles actividades, guías, consejos, entre otros elementos y recomendaciones que les ayudarán a tener un mejor manejo en sus emociones y así tener un mejor control en sus estudios y estancia en la universidad.

## XAMAPP Creación de Base de Datos para el proyecto

En este apartado se guardará la base de datos y la respectiva tabla para el apartado de Diario, un apartado en donde el usuario podrá colocar y redactar un poco de su experiencia y su estado de ánimo para tener una zona de privacidad y tranquilidad, para posteriormente toda esa información se guardará en la base de datos donde tanto la información que escriba ahora como posteriormente, se guardará en la tabla con la base de datos.

---

**Realizar Conexion con MariaDB**

```sql
mysql -u root -h localhost -p
```

![image.png](2bed87ef-167b-436e-889f-a3df4db5c603.png)

---

**Crear base de datos**

```sql
CREATE DATABASE usuario;
```

![image.png](image.png)

---

**Seleccionar la base de datos usuario**

```sql
USE usuario;
```

![image.png](image%201.png)

---

**Crear la tabla**

```sql
CREATE TABLE Notas (
    idNota INT,
    nota VARCHAR(255),
    edoAnimo VARCHAR(255),
    fecha VARCHAR(255)
);
```

![image.png](image%202.png)

![image.png](image%203.png)

**Describir tabla:**

```jsx
DESCRIBE nota
```

```sql
INSERT INTO Notas (idNota, nota, edoAnimo, fecha) VALUES
(1, 'Hoy estuve feliz', 'Feliz', '26 de Julio'),
(2, 'Hoy estuve cansado', 'cansado', '2 de junio'),
(3, 'Me encuentro triste', 'triste', '14 de mayo'),
(4, 'Hoy me siento confiado', 'confiado', '1 de agosto'),
(5, 'Hoy me siento de maravilla', 'feliz', '1 de septiembre'),
(6, 'Hoy me asusté', 'asustado', '2 de agosto'),
(7, 'Hoy me fue de maravilla', 'alegre', '3 de agosto'),
(8, 'El día de ayer me pegaron', 'adolorido', '30 de julio'),
(9, 'Hoy me putearin', 'outeado', 'hoy'),
(10, 'Estoy triste', 'Triste', '4 de Agosto'),
(11, 'Me encuentro frustrado pues no pasé otro examen', 'Frustrado', '5 de Agosto'),
(12, 'Estoy cansado', 'cansado', '6 de agosto'),
(13, 'Estoy inspirada', 'Inspirada', '6 de agosto');
```

![image.png](image%204.png)

# Crear conexión de Java a MySQL

Primero hay que descargar los drives “Mysql connector Java.jar”

https://dev.mysql.com/downloads/connector/j/

![image.png](image%205.png)

**Archivo de conexion a la base de datos *ConexionBD.java***

```jsx
public class ConexionBD {
    private final String url;
    private final String usuario;
    private final String password;
    
    public ConexionBD(){
        url = "jdbc:mysql://localhost:3306/usuario";
        usuario = "root";
        password = "";
    }
    public Connection conecta(){
        Connection cx=null;
    
        try {
            cx = DriverManager.getConnection(url,usuario,password);
            System.out.println("Si conecto la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        
        return cx;
    }

```

![image.png](image%206.png)

# Funcionamiento de la interfaz

La interfaz se compone de una ventana de inicio de sesión llamada “Ventana”, en donde se pedirá el nombre de usuario y matrícula para
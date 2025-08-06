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

# Funcionamiento y contenidos de la interfaz

La interfaz se compone de una ventana de inicio de sesión llamada “Ventana”, en donde se pedirá el nombre de usuario y matrícula para poder ingresar a la interfaz, de lo contrario no permitirá el acceso.

**Diseño:**

![image.png](image%207.png)

Código:

En esta interfaz no se hará gran cosa, solamente colocar las condiciones para que al colocar los elementos pedidos este pueda dar o no dar acceso a la interfaz

```jsx
private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String nombre = txtNombre.getText();
        String matricula = txtMatricula.getText();
        String usuario = "Miguel";
        
        if (!nombre.isEmpty()){ //AND OR NOT EN JAVA 
           Inicio formulario = new Inicio();
            formulario.setVisible(true);
            this.dispose(); 
        }
    }             
```

**Interfaz “Inicio”**

Esta es la interfaz principal en donde se todas las funciones se darán a funcionar por medio de los botones, incluyendo imágenes para darles un toque y estilo, incluyendo códigos y funciones para que al darles click nos lleven a las interfaces de la respectiva función.

**Código de funciones:**

```jsx
private void btnDiarioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        DiarioDB formulario = new DiarioDB();
        formulario.setVisible(true);
        this.dispose();
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Emocion formulario = new Emocion();
        formulario.setVisible(true);
        this.dispose();
    }                                        

    private void btnMeditarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        Meditar formulario = new Meditar();
        formulario.setVisible(true);
        this.dispose();
    }                                          

    private void btnActividadActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        Actividad formulario = new Actividad();
        formulario.setVisible(true);
        this.dispose();
    }                                            

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        Imagen formulario = new Imagen();
        formulario.setVisible(true);
        this.dispose();
    }                                         

    private void btnRecomendacionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        Recomendacion formulario = new Recomendacion();
        formulario.setVisible(true);
        this.dispose();
    }                                                

```

![image.png](image%208.png)

![image.png](image%209.png)

![image.png](image%2010.png)

**Interfaz Emociones:**

En este apartado el usuario podrá elegir una de las ocho emociones planteadas en la interfaz por defecto, las cuales por medio de clases se conectarán a la clase “Emoción”, que es donde se da la función, y según la emoción, el programa le dará un consejo o frase motivadora a la persona con el fin de tratar de ayudarla a mejorar un poco su estado emocional si es negativo, y si es positivo, darle más ánimos para seguir adelante, esta función se compone por otras pequeñas interfaces de otras emociones que son: Feliz, asustado, nervioso, inspirado, enojado, curioso y triste.

Diseño:

![image.png](image%2011.png)

Código:

```jsx
private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        Inicio formVent = new Inicio();
        formVent.setVisible(true);
        this.dispose();
    }                                         

    private void btnFelizActionPerformed(java.awt.event.ActionEvent evt) {                                         
    Feliz formulario = new Feliz();
    formulario.setVisible(true);
    this.dispose();
        // TODO add your handling code here:
    }                                        

    private void btnAsustadoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Asustado formulario = new Asustado();
    formulario.setVisible(true);
    this.dispose();
    }                                           

    private void btnTristeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        Triste formulario = new Triste();
        formulario.setVisible(true);
        this.dispose();
    }                                         

    private void btnInspiradoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
       Inspirado formulario = new Inspirado();
       formulario.setVisible(true);
       this.dispose();
    }                                            

    private void btnEnojadoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    Enojado formulario = new Enojado();
    formulario.setVisible(true);
    this.dispose();
    }                                          

    private void btnCuriosoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    Curioso formulario = new Curioso();
    formulario.setVisible(true);
    this.dispose();
    }                                          

    private void btnSadActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    Sad formulario = new Sad();
    formulario.setVisible(true);
    this.dispose();
    }                                            
```

![image.png](image%2012.png)

Todas las clases de las emociones tienen el mismo código y función, pero cambiando unicamente el nombre de la emoción, por lo que ahora solo se mostrará un ejemplo, pero el procedimiento para el resto es el mismo, solo cambiando el nombre de la emoción.

![image.png](image%2013.png)

```jsx
private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        Emocion formVent = new Emocion();
        formVent.setVisible(true);
        this.dispose();
    }                                         

```
package practica4_4;

/**
 * Representa la clase Gato que implementa la clase Mamifero.
 * <p>
 * Un gato tiene los siguientes atributos:
 * <ol>
 * <li>Nombre. Indica el nombre del gato</li>
 * <li>Peso. Indica el peso del gato. el rango minimo es de 2 y el rango maximo es de 15</li>
 * <li>Muerto. Indica que si el gato est� muerto o no. Por defecto, el booleano sera falso, por lo
 * tanto se indicara que esta vivo.</li>
 * </ol>
 * 
 * @author Pablo Merida
 * 
 */
public class Gato implements Mamifero {

 /**
   * @param nombre Nombre del gato
   */
  String nombre;
 /**
   * @param peso Peso del gato
   */
  int peso = 2;
  /**
   * @param muerto Estado del gato
   */
  private boolean muerto = false;

  /**
   * Guarda el nombre del gato
   * 
   * @param nombre Nombre del gato
   * 
   */
  public Gato(String nombre) {
    super();
    setNombre(nombre);
  }



  /**
   * Hace que el gato mame leche
   * 
   * @throws MuertoException Si el gato esta muerto no puede hacer la accion de mamar
   * 
   */
  @Override
  public void mamar() throws MuertoException {
    // throws MuertoException {
    if (estaMuerto())
      return;
    setPeso(getPeso() + 1);
    return;
  }

  /**
   * Hace que el gato juegue
   * 
   * @throws MuertoException Si el gato esta muerto no puede hacer la accion de jugar
   */
  public void jugar() throws MuertoException {
    if (estaMuerto())
      return;
    setPeso(getPeso() - 1);
  }

  /**
   * Indica el peso por defecto o modificado del gato
   * 
   * @return Peso del gato
   * 
   */
  public int getPeso() {
    return peso;
  }

  /**
   * Modifica el peso del gato y hace que el gato se muere si cumple que el peso esta por debajo de
   * 1 o por encima de 15
   * 
   * @param peso Indica el peso del gato
   * 
   * @throws MuertoException Indica si el gato esta muerto o no
   */
  private void setPeso(int peso) throws MuertoException {
    this.peso = peso;
    if (getPeso() == 1) {
      morir();
      throw new MuertoException("Me acabo de morir. Demasiado juego");
    }
    if (getPeso() == 15) {
      morir();
      throw new MuertoException("Me acabo de morir. Demasiada comida");
    }
  }

  /**
   * Indica el nombre del gato
   * 
   * @return Nombre del gato
   */
  String getNombre() {
    return nombre;
  }


  /**
   * Indica el nombre del gato cambiado
   * 
   * @param nombre Nombre del gato
   */
  void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Indica por la pantalla de la terminal el nombre y el peso del gato actual
   * 
   */
  @Override
  public String toString() {
    return "Gato [nombre=" + nombre + ", peso=" + peso + "]";
  }

  /**
   * Indica si el gato esta muerto o no
   * 
   * @return Estado del gato
   */
  protected boolean estaMuerto() {
    return muerto;
  }

  /**
   * Modifica la variable booleana muerto e indica que el gato esta muerto.
   * 
   */
  protected void morir() {
    muerto = true;
  }

}

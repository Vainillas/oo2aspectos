package modelo;

import persistencia.ConectorDB;
import persistencia.IngresoPersonas;

public class MainPunto2 {

  public static void main(String[] args) {
    ConectorDB conector = new ConectorDB();
    //Abro la conexion en el main porque sino afecta en la diferencia
    //del tiempo de ejecucion. (El de 10 tarda mas que el de 1000)
    conector.open();
    System.out.println("El tiempo que tarda en agregar 10 personas es de :");
    IngresoPersonas.agregarPersonas(10);
    System.out.println("El tiempo que tarda en agregar 10000 personas es de :");
    IngresoPersonas.agregarPersonas(10000);
    conector.close();
  }
}

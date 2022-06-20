package aspectos;

import modelo.Arbitro;
import modelo.PersonaDelFutbol;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import persistencia.ComportamientoDisco;
import persistencia.SQLImpl;

@Aspect
public class Registracion {
  private SQLImpl mysql = new SQLImpl();

  @Before("execution(* modelo.*.insultarA(..))")
  public void loguearAntesBD(JoinPoint joinPoint) {
    mysql.open();

    PersonaDelFutbol unaPersona = (PersonaDelFutbol) joinPoint.getThis();
    Arbitro unArbitro = (Arbitro) joinPoint.getArgs()[0];
    //Base de datos o archivo
    mysql.registrarInsulto(unArbitro, unaPersona, unaPersona.insulto());
    mysql.close();
  }

  @Before("execution(* modelo.*.insultarA(..))")
  public void loguearAntesDisco(JoinPoint joinPoint) {
    PersonaDelFutbol unaPersona = (PersonaDelFutbol) joinPoint.getThis();
    Arbitro unArbitro = (Arbitro) joinPoint.getArgs()[0];
    ComportamientoDisco.escribirInsulto(unArbitro, unaPersona, unaPersona.insulto());
  }
}

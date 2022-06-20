package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MedidorDeTiempo {

  @Around("@annotation(aspectos.Time)")
  public void obtenerDiferenciaDeTiempo(JoinPoint jp) {
    Long diferencia = -1L;
    try {
      Long tiempo1 = System.currentTimeMillis();
      ((ProceedingJoinPoint) jp).proceed();
      Long tiempo2 = System.currentTimeMillis();
      diferencia = tiempo2 - tiempo1;
      System.out.println(diferencia / 1000f + " segundos");
    } catch (Throwable t) {}
  }
}

import java.util.*;
public class Lector extends Thread{
    private GestorJusto gestor;
    private int id;
    private static Random r=new Random();

    public Lector(int id, GestorJusto gestor){
        this.id=id;
        this.gestor=gestor;
    }

    public void run(){
        while (true){
            try {
                gestor.openL(id);
                Thread.sleep(r.nextInt(200));
                //leyendo
                gestor.closeL(id);
                Thread.sleep(r.nextInt(200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

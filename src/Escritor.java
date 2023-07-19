import java.util.*;
public class Escritor extends Thread{
    private GestorJusto gestor;
    private int id;
    private static Random r=new Random();
    public Escritor(int id, GestorJusto gestor){
        this.id=id;
        this.gestor=gestor;
    }

    public void run(){
        while (true){
            try {
                gestor.openE(id);
                Thread.sleep(r.nextInt(200));
                //escribiendo
                gestor.closeE(id);
                Thread.sleep(r.nextInt(200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

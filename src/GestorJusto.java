public class GestorJusto {
    private int numLec=0;
    private int numEsc=0;
    private boolean hayEsc=false;

    public synchronized void openL(int i) throws InterruptedException {
        while (hayEsc || numEsc>1){
            wait();
        }
        numLec++;
        System.out.println("Lector "+i+ " entra en la BD");
    }

    public synchronized void closeL(int i){
        System.out.println("Lector "+i+ " sale de la BD");
        numLec--;
        if(numLec==0){
            notifyAll();
        }
    }

    public synchronized void openE(int i) throws InterruptedException{
        numEsc++;
        while (hayEsc || numLec>0){
            wait();
        }
        hayEsc=true;
        System.out.println("Escritor "+i+ " entra en la BD");
    }

    public synchronized void closeE(int i){
        numEsc--;
        System.out.println("Escritor "+i+ " sale de la BD");
        hayEsc=false;
        notifyAll();
    }
}


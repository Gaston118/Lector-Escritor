public class Main {
    public static void main(String[] args) {
        GestorJusto gestorBD = new GestorJusto();
        Escritor [] escritores = new Escritor[3];
        Lector [] lectores = new Lector[10];
        //creo lectores
        for(int i=0; i<lectores.length; i++){
            lectores[i]= new Lector(i, gestorBD);
        }
        //creo escritores
        for (int i=0; i<escritores.length; i++){
            escritores[i]=new Escritor(i, gestorBD);
        }
        //Hacemos andar
        for(int i=0; i<lectores.length; i++){
            lectores[i].start();
        }
        for (int i=0; i<escritores.length; i++){
            escritores[i].start();
        }

    }
}
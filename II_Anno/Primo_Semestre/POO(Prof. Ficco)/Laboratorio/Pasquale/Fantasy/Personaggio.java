package game.scripts;

public abstract class Personaggio implements SuperPersonaggio {

    private static int lastID = 0;
    protected int id;
    protected String tipo;
    protected int energia;

    protected Posizione posizione;

    private Personaggio(String tipo, int energia) {
        this.id = ++lastID;
        this.tipo = tipo;
        this.energia = energia;
    }

    public Personaggio(String tipo, int energia, int startingPosX, int startingPosY) {
        this(tipo, energia);
        posizione = new Posizione(startingPosX, startingPosY);
    }

    public Personaggio(String tipo, int energia, Posizione posizione) {
        this(tipo, energia);
        this.posizione = posizione;
    }


    public void ruota(int g) {
        posizione.addGradi(g);
    }

    public void avanti(int s) {
        switch (posizione.direzione) {
            case UP -> posizione.y += s;
            case RIGHT -> posizione.x += s;
            case DOWN -> posizione.y -= s;
            case LEFT -> posizione.x -= s;
        }
    }

    public void indietro(int s) {
        avanti(-s);
    }


    public void subisciDanno(int danno) {
        energia -= danno;
    }



    @Override
    public String toString() {
        return "ID:" + id + " Tipo " + tipo + " Energia: " + energia +
                " Posizione[" + posizione + "]";
    }
}


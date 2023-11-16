package game.scripts;

public class Posizione {


    public int x, y;
    public Direzione direzione;

    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
        direzione = Direzione.UP;
    }

    public void addGradi(int g) {
        int gradi = direzioneToGradi(direzione);
        gradi += g;
        g = g % 360;
        direzione = gradiToDirezione(gradi);
    }

    public static Direzione gradiToDirezione(int g) {
        if (isCompreso(0, g, 90)) return Direzione.UP;
        else if (isCompreso(90, g, 180)) return Direzione.RIGHT;
        else if (isCompreso(180, g, 270)) return Direzione.DOWN;
        else if (isCompreso(270, g, 360)) return Direzione.LEFT;
        return Direzione.UP;
    }

    public static int direzioneToGradi(Direzione d) {
        return switch (d) {
            case UP -> 0;
            case RIGHT -> 90;
            case DOWN -> 180;
            case LEFT -> 270;
        };
    }


    public static boolean isCompreso(int min, int n, int max) {
        return  (min >= n && n < max);
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }

    public boolean isEquals(Posizione p2) {
        return this.x == p2.x && this.y == p2.y;
    }
}

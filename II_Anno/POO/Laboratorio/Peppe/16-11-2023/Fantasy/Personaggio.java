package Fantasy;


public abstract class Personaggio implements SuperPersonaggio{
    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }
    
    public int id;
    public String type;
    public int energy;
    public Posizione startPos;
    public Posizione pos;
    public int dir;
    public Direction direction;

    public Personaggio(int id, String type, int energy, Posizione startPos){
        this.id = id;
        this.type = type;
        this.energy = energy;
        this.startPos = startPos;
        this.pos = startPos;
        this.dir = 0;
        this.direction = Direction.values()[this.dir];
    }

    public int getEnergy()
    {
        return this.energy;
    }

    public int getId()
    {
        return this.id;
    }

    public String getType()
    {
        return this.type;
    }

    public Direction getDirection(){
        return this.direction;
    }
    

    public void Routa(int g){
        if(g % 90 == 0) {
            this.dir += g;
            if (this.dir >= 360) {
                this.dir -= 360;
            }
            this.direction = Direction.values()[this.dir / 90];
        }
    }

    public void Avanti(int s)
    {
        if (this.direction == Direction.UP) {
            this.pos.y += s;
        }
        else if (this.direction == Direction.RIGHT) {
            this.pos.x += s;
        }
        else if (this.direction == Direction.DOWN) {
            this.pos.y -= s;
        }
        else if (this.direction == Direction.LEFT) {
            this.pos.x -= s;
        }
    }

    public void Indietro(int s)
    {
        if(this.direction == Direction.UP)
        {
            this.pos.y -= s;
        }
        else if(this.direction == Direction.RIGHT)
        {
            this.pos.x -= s;
        }
        else if (this.direction == Direction.DOWN) {
            this.pos.y += s;
        }
        else if (this.direction == Direction.LEFT) {
            this.pos.x += s;
        }

    }
}
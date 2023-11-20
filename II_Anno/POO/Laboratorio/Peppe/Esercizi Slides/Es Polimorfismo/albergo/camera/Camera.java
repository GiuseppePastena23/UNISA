package albergo.camera;
public abstract class Camera {
    
    public enum State{
        OCCUPATA,
        LIBERA;
    }

    protected float price;
    protected State state;

    protected Camera(){
        this(0);
    }

    protected Camera(float price){
        this.price = price;
        this.state = State.LIBERA;
    }

    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }
    
}

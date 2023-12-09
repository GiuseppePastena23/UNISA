package CockAndBallTorture;

public class Entita
{
    private float Cock;
    private int Ball;
    private Boolean isExcrutiatingPain = false;
    private Boolean isAlive = true;

    Entita(float Cock, int Ball)
    {
        this.Cock = Cock;
        this.Ball = Ball;
        this.isExcrutiatingPain = false;
        this.isAlive = true;

    }

    public int getBall() {
        return Ball;
    }
    public float getCock() {
        return Cock;
    }
    public Boolean getIsAlive() {
        return isAlive;
    }
    public Boolean getIsExcrutiatingPain() {
        return isExcrutiatingPain;
    }
    public void setBall(int ball) {
        Ball = ball;
    }
    public void setCock(float cock) {
        Cock = cock;
    }
    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }
    public void setIsExcrutiatingPain(Boolean isExcrutiatingPain) {
        this.isExcrutiatingPain = isExcrutiatingPain;
        if(isAlive.equals(false))
        {
            setIsExcrutiatingPain(false);
        }
    }
    
    @Override
    public String toString()
    {
        if(isAlive.equals(true) && isExcrutiatingPain.equals(true))
        {
            return
            (
                "Subject is alive and in excrutiating pain\n" +
                "Cock lenght = " + getCock() + "\n" +
                "Balls counter = " + getBall() + "\n"
            );
        }
        else if(isAlive.equals(true) && isExcrutiatingPain.equals(false))
        {
            return
            (
                "Subject is alive and is feeling alright\n" +
                "Cock lenght = " + getCock() + "\n" +
                "Balls counter = " + getBall() + "\n"
            );
        }
        else
        {
            return
            (
                "Subject is fookin dead m8\n" +
                "Cock lenght = " + getCock() + "\n" +
                "Balls counter = " + getBall() + "\n"
            );
        }
    }
}

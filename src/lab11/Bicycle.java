package lab11;

public class Bicycle implements Cloneable {
private int cadence;
private int gear;
private int speed;

//////////////////////////////////////CONSTRUCTORS//////////////////////////////
    public Bicycle(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
    }
    
/////////////////////////////////GETTERS & SETTERS//////////////////////////////
    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
/////////////////////////////////CUSTOM METHODS/////////////////////////////////
    public void applyBrake(int decrement)
    {
        this.setSpeed(speed - decrement);
    }
    public void speedUp(int increment)
    {
        this.setSpeed(speed + increment);
    }
    
//////////////////////////////OVERRIDES/////////////////////////////////////////
    @Override
    public String toString() {
        return "Bicycle{" + "cadence=" + cadence + ", gear=" + gear + ", speed=" + speed + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bicycle other = (Bicycle) obj;
        if (this.cadence != other.cadence) {
            return false;
        }
        if (this.gear != other.gear) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Bicycle schwin = new Bicycle(2,3,4);
        Bicycle mongoose = new Bicycle(6,7,8);
        
        System.out.println(mongoose); //6, 7, 8
        mongoose.speedUp(5);
        System.out.println(mongoose); //6, 7, 13
        
        System.out.println();
        System.out.println("Schwin = mongoose: " + schwin.equals(mongoose)); //FALSE
        
        System.out.println();
        Bicycle mongooseTPO = (Bicycle)mongoose.clone(); //CLONE DOEES NOT EFFECT ORIGINAL
        System.out.println(mongooseTPO); //6,7,13
        mongooseTPO.speedUp(3);
        System.out.println(mongooseTPO); //6,7,16
        
    }
    
}

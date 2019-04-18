package lab11;

import java.util.Objects;

public class MountainBike extends Bicycle {

        private int seatHeight;
        private Brand brand;

    public MountainBike(Brand brand, int seatHeight, int cadence, int gear, int speed) {
        super(cadence, gear, speed);
        this.seatHeight = seatHeight;
        this.brand = brand;
    }

    public MountainBike(int seatHeight, int cadence, int gear, int speed) {
        super(cadence, gear, speed);
        this.seatHeight = seatHeight;
        this.brand = new Brand();
    }
        
        
    public MountainBike(int cadence, int gear, int speed) {
        super(cadence, gear, speed);
        this.brand = new Brand();
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public String getBrand() {
        return brand.getBrandName();
    }

    @Override
    public String toString() {
        return super.toString() + "MountainBike{" + "seatHeight=" + seatHeight + " BrandName= " + brand.getBrandName() + '}';
    }

    

    @Override
    protected Object clone() throws CloneNotSupportedException {
         MountainBike t = (MountainBike)super.clone(); 
         t.brand = (Brand)this.brand.clone();
         return t;
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
        final MountainBike other = (MountainBike) obj;
        if (this.seatHeight != other.seatHeight || !super.equals(obj)) {
            return false;
        }
        return true;
    }
    
    ////////////////////////////TESTING POINT//////////////////////////////////
    public static void main(String[] args) throws CloneNotSupportedException {
        MountainBike trailblazer = new MountainBike(7, 1, 2, 3);
        MountainBike GravelSpitter = new MountainBike(9, 3, 4, 5);
        Bicycle mongoose = new Bicycle(5, 6, 7);
        
        System.out.println(trailblazer);
        trailblazer.setSeatHeight(5);
        trailblazer.applyBrake(2);
        System.out.println(trailblazer);
        
        System.out.println("trailblazer's seat height equals GravelSpitter's: " + 
                trailblazer.equals(GravelSpitter));
        
        MountainBike Pivot = (MountainBike)trailblazer.clone();
        System.out.println("trailblazer's seat height equals Pivot's: " + 
                trailblazer.equals(Pivot));
        Pivot.setSeatHeight(3);
        Pivot.speedUp(4);
        System.out.println(Pivot);
        
        System.out.println("");
        Brand b1 = new Brand("Yamaha");
        Brand b2 = new Brand("Harley");
        MountainBike RedOne = new MountainBike(b1, 5, 6, 7, 8);
        System.out.println(RedOne); //DOES NOT PRINT BRAND
        System.out.println("RedOne's Brand: " + RedOne.getBrand()); //PRINTS BRAND
        
        System.out.println("Yamaha = Harley: " + b1.equals(b2));//FALSE
        
        MountainBike BlueOne = (MountainBike)RedOne.clone();
        System.out.println("RedOne = BlueOne: " + RedOne.equals(BlueOne)); // TRUE
        
        MountainBike YellowOne = new MountainBike(b2, 5, 6, 7, 8);
        System.out.println("RedOne Brand = YellowOne Brand: " +
                RedOne.getBrand().equals(YellowOne.getBrand())); // FALSE
        
    }

}
class Brand implements Cloneable{
    private String BrandName;
    
    public Brand()
    {
         BrandName = "unknown";
    }
    public Brand(String t) {
        this.BrandName = t;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
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
        final Brand other = (Brand) obj;
        if (!Objects.equals(this.BrandName, other.BrandName)) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       return super.clone();
               }
    
    
}


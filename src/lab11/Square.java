package lab11;

import java.util.ArrayList;
import java.util.Arrays;
public class Square extends GeometricObject implements Colorable, Comparable<Square> {

    private int side;

    public Square(int side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public Square(int side) {
        this.side = side;
    }

    public Square() {
        this.side = 0;
    }

    /**
     * Get the value of side
     *
     * @return the value of side
     */
    public int getSide() {
        return side;
    }

    /**
     * Set the value of side
     *
     * @param side new value of side
     */
    public void setSide(int side) {
        this.side = side;
    }

    public static ArrayList<Colorable> sortArray(ArrayList<Colorable> list)
            throws CloneNotSupportedException{
        Object[] temp = list.toArray();
       /* for (int i = 0; i < temp.length - 1; ++i) {
            for (int j = i + 1; j < temp.length; ++j) {
                Square a = (Square) temp[i];
                Square b = (Square) temp[j];
                Square c = new Square();
                if (a.getSide() > b.getSide()) {
                    c.setColor(a.getColor());
                    c.setFilled(a.isFilled());
                    c.setSide(a.getSide());
                    a.setColor(b.getColor());
                    a.setFilled(b.isFilled());
                    a.setSide(b.getSide());
                    b.setColor(c.getColor());
                    b.setFilled(c.isFilled());
                    b.setSide(c.getSide());
                }
            }
        }*/
        Arrays.sort(temp);
       ArrayList<Colorable> list2 = new ArrayList(Arrays.asList(temp));
       return list2;
       
        
        }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public int compareTo(Square o
    ) {
       return this.side - o.side;    }

    @Override
    public String toString() {
        return  "Square{" + "side=" + side + ", " + super.toString() + "}\n";
    }

    public static void main(String[] args)
            throws CloneNotSupportedException {
        Square a = new Square(4, "blue", false);
        Square b = new Square(6, "yellow", true);
        Square c = new Square(1, "green", false);
        System.out.println(a);
        System.out.println(a.getArea());
        System.out.println(a.getPerimeter());
        System.out.println(b.getArea());
        System.out.println(b.getPerimeter());
        System.out.println(a.compareTo(b));
        System.out.println("\n-----\t-----\t-----\t-----\t-----\t-----\t-----\n");
        ArrayList<Colorable> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list);
        ArrayList<Colorable> list2 = sortArray(list);
        System.out.println(list2);
        System.out.println(Square.max(c, a));
        
        
    }
}


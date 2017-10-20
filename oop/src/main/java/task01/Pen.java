package task01;

import lombok.Data;
import task03.Chancery;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
public class Pen extends Chancery {

    public Pen(String color, String material, boolean isAutomatic) {
        this.color = color;
        this.material = material;
        this.isAutomatic = isAutomatic;
    }

    public static class Color {
        Map<String, String> colors = new HashMap<>() {
            {
                put("BLACK", "\u001B[30m");
                put("RED", "\u001B[31m");
                put("GREEN", "\u001B[32m");
                put("YELLOW", "\u001B[33m");
                put("BLUE", "\u001B[34m");
                put("PURPLE" ,"\u001B[35m");
                put("CYAN", "\u001B[36m");
                put("WHITE", "\u001B[37m");
            }
        };

        String getColor(String color){
            if(colors.containsKey(color))
                return colors.get(color);
            else
                return null;
        }
    }

    String color;
    String material;
    boolean isAutomatic;

    public static void main(String[] args) {
        Pen pen = new Pen("YELLOW", "Plastic", false);
        pen.writeSomething();
        pen.setPrice(100555);
        System.out.println(pen.getPrice());
    }

    public void writeSomething(){
        System.out.println(new Color().getColor(color) + new Scanner(System.in).nextLine());
    }

}

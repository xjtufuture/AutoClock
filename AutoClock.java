import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.*;

public class AutoClock {

    public static  void main(String[]args){
        autoClick();
    }

    public static void stop(int s){
        try{
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void onclickSB(String lr){
        Robot robot =null;
        try{
            robot = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }

        if (lr.equals("right")){
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }else {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public static void onEnter(String lr){
        Robot robot =null;
        try{
            robot = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }

        if (lr.equals("Enter")){
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public static void altPlusF4(String lr){
        Robot robot =null;
        try{
            robot = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }

        if (lr.equals("Quit")){
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_F4);
        }
    }

    public static void change(int type, int x, int y){
        Point p = MouseInfo.getPointerInfo().getLocation();
        int width = (int) p.getX() + x;
        int heigh = (int) p.getY() + y;
        if (type == 0){
            width =x;
            heigh =y;
        }
        Robot robot;
        try{
            robot =new Robot();
            robot.mouseMove(width,heigh);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }

    public static void autoClick()

    {
        int x = 0;
        int y = 0;
        Point p =MouseInfo.getPointerInfo().getLocation();
        System.out.println(p.getX() + "---" + p.getY());


        Desktop desktop = Desktop.getDesktop();



        String url = "http://188.77.0.126/snerdiOA/share/kaoqin/kaoqin.jsp";

        try {
            Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        stop(2000);
        try {
            URI uri = new URI(url);
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        change(0,98,877);
//        onclickSB("left");
//        stop(5000);
//        change(0,1262,673);
//        onclickSB("left");

        stop(2000);
        onEnter("Enter");
        stop(2000);
        altPlusF4("Quit");
        onEnter("Enter");
        stop(2000);
        altPlusF4("Quit");
        change(0,(int)p.getX(),(int)p.getY());
        stop(5000);
    }
}

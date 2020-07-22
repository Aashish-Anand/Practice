package Leet;

public class L1401 {
    public static void main(String[] args) {
        new L1401().run();
    }

    private void run() {
        int radius = 1;
        int x_center = 0;
        int y_center = 0;
        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;

        System.out.println(checkOverlap(radius, x_center,y_center, x1, y1,x2,y2));
    }

    private boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

        if(x1 <= x_center && x2>=x_center && y1 <= y_center && y2>=y_center){
            return true;
        }
        if(y_center>=y1 && y_center<=y2){
            int nearestEdge = Math.min(Math.abs(x_center-x1), Math.abs(x_center-x2));
            if(nearestEdge <= radius){
                return true;
            }
        }

        if(x_center>=x1 && x_center <=x2){
            int nearestEdge = Math.min(Math.abs(y_center-y1), Math.abs(y_center-y2));
            if(nearestEdge <= radius){
                return true;
            }
        }

        double nearestCornerDistance = Math.sqrt(Math.pow(Math.min(Math.abs(x_center - x1), Math.abs(x_center - x2)), 2) + Math.pow(Math.min(Math.abs(y_center - y1), Math.abs(y_center - y2)), 2));

        if(nearestCornerDistance<=radius){
            return true;
        }
        return false;

    }
}

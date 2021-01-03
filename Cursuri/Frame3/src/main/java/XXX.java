public class XXX {


    int x = 5;
    int y = 4;


    public XXX() {
    }

    private static final class SingetonHolder{
        public static final XXX INSTANCE = new XXX();
    }

    public static XXX getInstance(){
        return SingetonHolder.INSTANCE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "XXX{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

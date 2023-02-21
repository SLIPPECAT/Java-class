package section2;

public class MyRectangle2 {
    public MyPoint2 lu;
    public MyPoint2 rl;

    public int width;
    public int height;

    public MyRectangle2( int x, int y, int w, int h )
    {
        lu = new MyPoint2( x, y );
        rl = new MyPoint2( x+w, y+h );
        width = w;
        height = h;
    }
    public MyRectangle2( MyPoint2 p, int w, int h )
    {
        lu = p;
        width = w;
        height = h;
    }
    public int calcArea(){
        return (rl.x-lu.x)*(lu.y-rl.y);
    }
    // toString 이 메서드는 특별하다. 그 이유는 나중에!
    // 문자열로 포장해서 return 해주는 함수가 필요할 때는 toString을 이용하자
    public String toString()
    {
        return "("+ lu.x+", "+lu.y+") "+width+" "+height;
    }
}

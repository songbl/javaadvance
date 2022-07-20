package create.bulider.standard;

public abstract class Builder {

    //这里不进行组装自行车，即不给自行车对象中的属性赋值，留给具体的Builder实现类做
    protected Bike mBike = new Bike();



    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike createBike();

}

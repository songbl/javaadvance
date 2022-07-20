package create.bulider.standard;

//ofo单车Builder类
public class OfoBuilder extends Builder {

    // 属性设置
    @Override
    public void buildFrame() {
        mBike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}

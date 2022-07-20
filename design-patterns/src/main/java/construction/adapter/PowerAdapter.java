package construction.adapter;

// 继承被适配者，为了获取被适配者的能力（功能），然后再转化成目标接口
public class PowerAdapter extends PowerAdaptee implements PowerTarget{

    @Override
    public int output5V() {
        int output = output220V();
        System.out.println("电源适配器开始工作，此时输出电压是：" + output);
        output = output/44;
        System.out.println("电源适配器工作完成，此时输出电压是：" + output);
        return output;
    }

}
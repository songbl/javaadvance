package bulider.simple;


public class Computer {

    private  String cpu;//必须
    private  String ram;//必须
    private  int usbCount;//可选
    private  String keyboard;//可选
    private  String display;//可选


    //最后构建使用的
    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.usbCount=builder.usbCount;
        this.keyboard=builder.keyboard;
        this.display=builder.display;
    }
    public static class Builder{
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选

        public Builder(String cup,String ram){
            this.cpu=cup;
            this.ram=ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }


        public Computer build(){
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return cpu+"=="+ram+"=="+usbCount+"==="+keyboard+"=="+display;
    }
}
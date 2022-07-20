package behavior.responsibilitychain;

public abstract class Approver  {

    Approver approver ;//下一个处理者


    String name;

    public Approver( String name) {
        this.name = name;
    }


    public void setApprover(Approver approver){
        this.approver = approver ;
    }


    //处理操作
    public abstract void handlerRequest(PurchaseRequest purchaseRequest);
}

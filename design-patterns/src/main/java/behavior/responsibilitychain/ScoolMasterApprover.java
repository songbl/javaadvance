package behavior.responsibilitychain;

public class ScoolMasterApprover extends Approver {
    public ScoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(PurchaseRequest purchaseRequest) {
        if ( purchaseRequest.getPrice()>30000){
            System.out.println("请求编号id="+purchaseRequest.getId()+"被"+this.name+"处理");
        }else {
            approver.handlerRequest(purchaseRequest);
        }
    }
}

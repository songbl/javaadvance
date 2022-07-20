package behavior.responsibilitychain;

public class ViceSchoolMasterApprover extends Approver {
    public ViceSchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>10000 && purchaseRequest.getPrice()<=30000){
            System.out.println("请求编号id="+purchaseRequest.getId()+"被"+this.name+"处理");
        }else {
            approver.handlerRequest(purchaseRequest);
        }
    }
}

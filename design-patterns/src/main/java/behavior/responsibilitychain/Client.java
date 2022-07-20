package behavior.responsibilitychain;

//职责链模式
public class Client {
    public static void main(String[] args) {
        //创建爱一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 8000, 1);

        //创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("赵副校长");
        ScoolMasterApprover scoolMasterApprover = new ScoolMasterApprover("王校长");

        //需要将各个审批级别的下一个设置好(处理人构成环状)
        //核心是：构造成链（设置了下一个处理者），每一个链节点都可能处理事件，或者传递给下一个节点
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(scoolMasterApprover);
        scoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.handlerRequest(purchaseRequest);


    }
}

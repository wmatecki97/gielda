package AllObjects.functionalClasses;

import AllObjects.functionalClasses.MenuFunctionality;

public class Purchase {

    private double amount;
    private int subjectId;
    private String subject;

    public Purchase(int subjectId, double amount){

        setSubjectId(subjectId);
        setAmount(amount);
        subject = MenuFunctionality.getGood(subjectId).getName();

    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
}

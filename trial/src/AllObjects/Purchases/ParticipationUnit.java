package AllObjects.Purchases;

public class ParticipationUnit {

    private int subjectId;
    private double amount;

    public ParticipationUnit(int sId, double am){

        subjectId = sId;
        amount = am;

    }

    public int getSubjectId() {
        return subjectId;
    }

    public double getAmount() {
        return amount;
    }



}

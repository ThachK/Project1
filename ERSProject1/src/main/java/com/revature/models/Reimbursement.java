package com.revature.models;

public class Reimbursement {
    private int reimbursement_id;
    private int reimbursement_amount;
    private String reimbursement_description;
    private User user;
    private ReimbursementType rt;
    private ReimbursementStatus rs;

    public Reimbursement() {
    }

    public Reimbursement(int reimbursement_id, int reimbursement_amount, String reimbursement_description, User user, ReimbursementType rt, ReimbursementStatus rs) {
        this.reimbursement_id = reimbursement_id;
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_description = reimbursement_description;
        this.user = user;
        this.rt = rt;
        this.rs = rs;
    }

    public Reimbursement(int reimbursement_amount, String reimbursement_description, User user, ReimbursementType rt, ReimbursementStatus rs) {
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_description = reimbursement_description;
        this.user = user;
        this.rt = rt;
        this.rs = rs;
    }

    public int getReimbursement_id() {
        return reimbursement_id;
    }

    public void setReimbursement_id(int reimbursement_id) {
        this.reimbursement_id = reimbursement_id;
    }

    public int getReimbursement_amount() {
        return reimbursement_amount;
    }

    public void setReimbursement_amount(int reimbursement_amount) {
        this.reimbursement_amount = reimbursement_amount;
    }

    public String getReimbursement_description() {
        return reimbursement_description;
    }

    public void setReimbursement_description(String reimbursement_description) {
        this.reimbursement_description = reimbursement_description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReimbursementType getRt() {
        return rt;
    }

    public void setRt(ReimbursementType rt) {
        this.rt = rt;
    }

    public ReimbursementStatus getRs() {
        return rs;
    }

    public void setRs(ReimbursementStatus rs) {
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "reimbursement_id=" + reimbursement_id +
                ", reimbursement_amount=" + reimbursement_amount +
                ", reimbursement_description='" + reimbursement_description + '\'' +
                ", user=" + user +
                ", rt=" + rt +
                ", rs=" + rs +
                '}';
    }
}

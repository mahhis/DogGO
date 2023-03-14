package by.fpmibsu.doggo.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private User customer;
    private User walker;

    private Date getOrder;
    private Date startWalk;
    private Date endWalk;

    private Integer walkTime;

    private List<Pet> petsForWalk;

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getWalker() {
        return walker;
    }

    public void setWalker(User walker) {
        this.walker = walker;
    }

    public Date getGetOrder() {
        return getOrder;
    }

    public void setGetOrder(Date getOrder) {
        this.getOrder = getOrder;
    }

    public Date getStartWalk() {
        return startWalk;
    }

    public void setStartWalk(Date startWalk) {
        this.startWalk = startWalk;
    }

    public Date getEndWalk() {
        return endWalk;
    }

    public void setEndWalk(Date endWalk) {
        this.endWalk = endWalk;
    }

    public Integer getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(Integer walkTime) {
        this.walkTime = walkTime;
    }

    public List<Pet> getPetsForWalk() {
        return petsForWalk;
    }

    public void setPetsForWalk(List<Pet> petsForWalk) {
        this.petsForWalk = petsForWalk;
    }
}

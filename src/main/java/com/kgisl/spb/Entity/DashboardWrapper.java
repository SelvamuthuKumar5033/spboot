package com.kgisl.spb.Entity;

public class DashboardWrapper {
    
   private long total;

   private long todayticket;

   private long pending;

   private long inprogress;

   public long getTotal() {
    return total;
   }

   public void setTotal(long total) {
    this.total = total;
   }

   public long getTodayTot() {
    return todayticket;
   }

   public void setTodayTot(long todayTot) {
    this.todayticket = todayTot;
   }

   public long getPending() {
    return pending;
   }

   public void setPending(long pending) {
    this.pending = pending;
   }

   public long getInprogress() {
    return inprogress;
   }

   public void setInprogress(long inprogress) {
    this.inprogress = inprogress;
   }


}

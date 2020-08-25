package com.zzh.utils;

public class Page {
    private int start=0;
    private int count=5;
    private int last=0;
    private int total=100;
    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
            this.start=start;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void cal(int total){
        this.total=total;

        last=(total%count==0)?(total-count):(total-total%count);
    }
}

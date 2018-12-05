package com.major.schedule.entity;

import java.util.List;

/**
 * Created by Major on 2018/12/5
 */
public abstract class Resp<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "data=" + data +
                '}';
    }
}

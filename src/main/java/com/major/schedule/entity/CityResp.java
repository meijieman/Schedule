package com.major.schedule.entity;

import java.util.List;

/**
 * Created by Major on 2018/12/6
 */
public class CityResp {

    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "CityResp{" +
                "cityList=" + cityList +
                '}';
    }
}

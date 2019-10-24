package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Provider;

public class Utility {


    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length();i++){
                    JSONObject provinceObjects = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObjects.getString("name"));
                    province.setProvinceCode(provinceObjects.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e ){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handzCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            try{
            JSONArray allCities = new JSONArray(response);
            for(int i = 0; i < allCities.length();i++) {
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response ,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for(int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObjext = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObjext.getString("name"));
                    county.setWeatherId(countyObjext.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e ){
                e.printStackTrace();
            }
        }return false;
    }
}

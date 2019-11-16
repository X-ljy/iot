package com.ljy.iot.entity;

/**
 * @author : 夕
 * @date : 2019/11/16
 */
public class WeatherBean {
    
    String ts;
    String id ;
    double wind_speed ;
    double rainfall ;
    double temperature ;
    double humidity ;
    double illumination ;
    double Photosynthesis ;
    double wind_direction ;
    double co2 ;
    double ph ;
    double soil_temperature_1 ;
    double soil_moisture_1 ;
    double soil_temperature_2 ;
    double soil_moisture_2 ;
    double soil_temperature_3 ;
    double soil_moisture_3 ;
    double conductance ;

    public String toSqlString(){
        return "insert into " + " iot.t_iot_weather_station " + " values " + " ( " +
                "\'" + getTs() + "\'," +
                "\'" + getId() + "\'," +
                "\'" + getWind_speed() + "\'," +
                "\'" + getRainfall() + "\'," +
                "\'" + getTemperature() + "\'," +
                "\'" + getHumidity() + "\'," +
                "\'" + getIllumination() + "\'," +
                "\'" + getPhotosynthesis() + "\'," +
                "\'" + getWind_direction() + "\'," +
                "\'" + getCo2() + "\'," +
                "\'" + getPh() + "\'," +
                "\'" + getSoil_temperature_1() + "\'," +
                "\'" + getSoil_moisture_1() + "\'," +
                "\'" + getSoil_temperature_2() + "\'," +
                "\'" + getSoil_moisture_2() + "\'," +
                "\'" + getSoil_temperature_3() + "\'," +
                "\'" + getSoil_moisture_3() + "\'," +
                "\'" + getConductance() + "\' " +
                ");";

    }



    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getIllumination() {
        return illumination;
    }

    public void setIllumination(double illumination) {
        this.illumination = illumination;
    }

    public double getPhotosynthesis() {
        return Photosynthesis;
    }

    public void setPhotosynthesis(double photosynthesis) {
        Photosynthesis = photosynthesis;
    }

    public double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getSoil_temperature_1() {
        return soil_temperature_1;
    }

    public void setSoil_temperature_1(double soil_temperature_1) {
        this.soil_temperature_1 = soil_temperature_1;
    }

    public double getSoil_moisture_1() {
        return soil_moisture_1;
    }

    public void setSoil_moisture_1(double soil_moisture_1) {
        this.soil_moisture_1 = soil_moisture_1;
    }

    public double getSoil_temperature_2() {
        return soil_temperature_2;
    }

    public void setSoil_temperature_2(double soil_temperature_2) {
        this.soil_temperature_2 = soil_temperature_2;
    }

    public double getSoil_moisture_2() {
        return soil_moisture_2;
    }

    public void setSoil_moisture_2(double soil_moisture_2) {
        this.soil_moisture_2 = soil_moisture_2;
    }

    public double getSoil_temperature_3() {
        return soil_temperature_3;
    }

    public void setSoil_temperature_3(double soil_temperature_3) {
        this.soil_temperature_3 = soil_temperature_3;
    }

    public double getSoil_moisture_3() {
        return soil_moisture_3;
    }

    public void setSoil_moisture_3(double soil_moisture_3) {
        this.soil_moisture_3 = soil_moisture_3;
    }

    public double getConductance() {
        return conductance;
    }

    public void setConductance(double conductance) {
        this.conductance = conductance;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "ts='" + ts + '\'' +
                ", id='" + id + '\'' +
                ", wind_speed=" + wind_speed +
                ", rainfall=" + rainfall +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", illumination=" + illumination +
                ", Photosynthesis=" + Photosynthesis +
                ", wind_direction=" + wind_direction +
                ", co2=" + co2 +
                ", ph=" + ph +
                ", soil_temperature_1=" + soil_temperature_1 +
                ", soil_moisture_1=" + soil_moisture_1 +
                ", soil_temperature_2=" + soil_temperature_2 +
                ", soil_moisture_2=" + soil_moisture_2 +
                ", soil_temperature_3=" + soil_temperature_3 +
                ", soil_moisture_3=" + soil_moisture_3 +
                ", conductance=" + conductance +
                '}';
    }


}

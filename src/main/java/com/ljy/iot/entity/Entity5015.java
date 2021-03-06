package com.ljy.iot.entity;

/**
 * @author : 夕
 * @date : 2019/8/30
 */
public class Entity5015 {

        private String ts;
        private String id;
        private String address;

        private float ambient_temperature ;
        private float temperature1 ;
        private float temperature2 ;
        private float temperature3 ;
        private float temperature4 ;
        private float temperature5 ;
        private float dew_point ;
        private float ambient_humidity ;
        private float land_humidity1 ;
        private float land_humidity2;
        private float land_humidity3 ;
        private float co2;
        private float evaporation;
        private float pressure;
        private float total_radiation_1;
        private float divergent_radiation;
        private float direct_radiation;
        private float total_radiation_2;
        private float net_radiation;
        private float photosynthetic_radiation;
        private float ultraviolet_radiation;
        private float soil_heat_flux1;
        private float wind_direction;
        private float wind_speed;
        private float average_wind_speed_2minute;
        private float average_wind_speed_10minute;
        private float cumulative_rainfall_interval;
        private float cumulative_sunshine_interval;
        private float total_radiation1_interval_cumulative;
        private float cumulative_divergent_radiation_interval;
        private float cumulative_direct_radiation_interval;
        private float total_radiation2_interval_cumulative;
        private float cumulative_net_radiation_interval;
        private float cumulative_interval_of_photosynthetic_radiation;
        private float cumulative_interval_of_ultraviolet_radiation;
        private float soil_heat_flux2;
        private float daily_cumulative_rainfall;
        private float daily_cumulative_sunshine;
        private float daily_cumulative_total_radiation1;
        private float daily_accumulation_of_scattered_radiation;
        private float daily_accumulation_of_direct_radiation;
        private float daily_cumulative_total_radiation2;
        private float daily_cumulative_of_net_radiation;
        private float daily_cumulative_photosynthetic_radiation;
        private float daily_cumulative_ultraviolet_radiation;
        private float soil_heat_flux3;
        private float illumination;
        private float electric_quantity;
        private float pm2_5;

    public Entity5015(String ts, String id, String address,
                      String ambient_temperature,
                      String temperature1, String temperature2, String temperature3, String temperature4, String temperature5,
                      String dew_point, String ambient_humidity, String land_humidity1, String land_humidity2,
                      String land_humidity3, String co2, String evaporation, String pressure, String total_radiation_1,
                      String divergent_radiation, String direct_radiation, String total_radiation_2, String net_radiation,
                      String photosynthetic_radiation, String ultraviolet_radiation, String soil_heat_flux1,
                      String wind_direction, String wind_speed, String average_wind_speed_2minute,
                      String average_wind_speed_10minute, String cumulative_rainfall_interval,
                      String cumulative_sunshine_interval, String total_radiation1_interval_cumulative,
                      String cumulative_divergent_radiation_interval, String cumulative_direct_radiation_interval,
                      String total_radiation2_interval_cumulative, String cumulative_net_radiation_interval,
                      String cumulative_interval_of_photosynthetic_radiation, String cumulative_interval_of_ultraviolet_radiation,
                      String soil_heat_flux2, String daily_cumulative_rainfall, String daily_cumulative_sunshine,
                      String daily_cumulative_total_radiation1, String daily_accumulation_of_scattered_radiation,
                      String daily_accumulation_of_direct_radiation, String daily_cumulative_total_radiation2,
                      String daily_cumulative_of_net_radiation, String daily_cumulative_photosynthetic_radiation,
                      String daily_cumulative_ultraviolet_radiation, String soil_heat_flux3, String illumination,
                      String electric_quantity, String pm2_5) {
        this.ts = ts;
        this.id = id;
        this.address = address;
        this.ambient_temperature = Float.parseFloat(ambient_temperature);
        this.temperature1 = Float.parseFloat(temperature1);
        this.temperature2 = Float.parseFloat(temperature2);
        this.temperature3 = Float.parseFloat(temperature3);
        this.temperature4 = Float.parseFloat(temperature4);
        this.temperature5 = Float.parseFloat(temperature5);
        this.dew_point = Float.parseFloat(dew_point);
        this.ambient_humidity = Float.parseFloat(ambient_humidity);
        this.land_humidity1 = Float.parseFloat(land_humidity1);
        this.land_humidity2 = Float.parseFloat(land_humidity2);
        this.land_humidity3 = Float.parseFloat(land_humidity3);
        this.co2 = Float.parseFloat(co2);
        this.evaporation = Float.parseFloat(evaporation);
        this.pressure = Float.parseFloat(pressure);
        this.total_radiation_1 = Float.parseFloat(total_radiation_1);
        this.divergent_radiation = Float.parseFloat(divergent_radiation);
        this.direct_radiation = Float.parseFloat(direct_radiation);
        this.total_radiation_2 = Float.parseFloat(total_radiation_2);
        this.net_radiation = Float.parseFloat(net_radiation);
        this.photosynthetic_radiation = Float.parseFloat(photosynthetic_radiation);
        this.ultraviolet_radiation = Float.parseFloat(ultraviolet_radiation);
        this.soil_heat_flux1 = Float.parseFloat(soil_heat_flux1);
        this.wind_direction = Float.parseFloat(wind_direction);
        this.wind_speed = Float.parseFloat(wind_speed);
        this.average_wind_speed_2minute = Float.parseFloat(average_wind_speed_2minute);
        this.average_wind_speed_10minute = Float.parseFloat(average_wind_speed_10minute);
        this.cumulative_rainfall_interval = Float.parseFloat(cumulative_rainfall_interval);
        this.cumulative_sunshine_interval = Float.parseFloat(cumulative_sunshine_interval);
        this.total_radiation1_interval_cumulative = Float.parseFloat(total_radiation1_interval_cumulative);
        this.cumulative_divergent_radiation_interval = Float.parseFloat(cumulative_divergent_radiation_interval);
        this.cumulative_direct_radiation_interval = Float.parseFloat(cumulative_direct_radiation_interval);
        this.total_radiation2_interval_cumulative = Float.parseFloat(total_radiation2_interval_cumulative);
        this.cumulative_net_radiation_interval = Float.parseFloat(cumulative_net_radiation_interval);
        this.cumulative_interval_of_photosynthetic_radiation = Float.parseFloat(cumulative_interval_of_photosynthetic_radiation);
        this.cumulative_interval_of_ultraviolet_radiation = Float.parseFloat(cumulative_interval_of_ultraviolet_radiation);
        this.soil_heat_flux2 = Float.parseFloat(soil_heat_flux2);
        this.daily_cumulative_rainfall = Float.parseFloat(daily_cumulative_rainfall);
        this.daily_cumulative_sunshine = Float.parseFloat(daily_cumulative_sunshine);
        this.daily_cumulative_total_radiation1 = Float.parseFloat(daily_cumulative_total_radiation1);
        this.daily_accumulation_of_scattered_radiation = Float.parseFloat(daily_accumulation_of_scattered_radiation);
        this.daily_accumulation_of_direct_radiation = Float.parseFloat(daily_accumulation_of_direct_radiation);
        this.daily_cumulative_total_radiation2 = Float.parseFloat(daily_cumulative_total_radiation2);
        this.daily_cumulative_of_net_radiation = Float.parseFloat(daily_cumulative_of_net_radiation);
        this.daily_cumulative_photosynthetic_radiation = Float.parseFloat(daily_cumulative_photosynthetic_radiation);
        this.daily_cumulative_ultraviolet_radiation = Float.parseFloat(daily_cumulative_ultraviolet_radiation);
        this.soil_heat_flux3 = Float.parseFloat(soil_heat_flux3);
        this.illumination = Float.parseFloat(illumination);
        this.electric_quantity = Float.parseFloat(electric_quantity);
        this.pm2_5 = Float.parseFloat(pm2_5);
    }

    public String toSqlString(){
        return "insert into " + " iot.t_iot_sun5015 " + " values " + " ( " +
                "\'" + getTs() + "\'," +
                "\'" + getId() + "\'," +
                "\'" + getAddress() + "\'," +
                "\'" + getAmbient_temperature() + "\'," +
                "\'" + getTemperature1() + "\'," +
                "\'" + getTemperature2() + "\'," +
                "\'" + getTemperature3() + "\'," +
                "\'" + getTemperature4() + "\'," +
                "\'" + getTemperature5() + "\'," +
                "\'" + getDew_point() + "\'," +
                "\'" + getAmbient_humidity() + "\'," +
                "\'" + getLand_humidity1() + "\'," +
                "\'" + getLand_humidity2() + "\'," +
                "\'" + getLand_humidity3() + "\'," +
                "\'" + getCo2() + "\'," +
                "\'" + getEvaporation() + "\'," +
                "\'" + getPressure() + "\'," +
                "\'" + getTotal_radiation_1() + "\'," +
                "\'" + getDivergent_radiation() + "\'," +
                "\'" + getDirect_radiation() + "\'," +
                "\'" + getTotal_radiation_2() + "\'," +
                "\'" + getNet_radiation() + "\'," +
                "\'" + getPhotosynthetic_radiation() + "\'," +
                "\'" + getUltraviolet_radiation() + "\'," +
                "\'" + getSoil_heat_flux1() + "\'," +
                "\'" + getWind_direction() + "\'," +
                "\'" + getWind_speed() + "\'," +
                "\'" + getAverage_wind_speed_2minute() + "\'," +
                "\'" + getAverage_wind_speed_10minute() + "\'," +
                "\'" + getCumulative_rainfall_interval() + "\'," +
                "\'" + getCumulative_sunshine_interval() + "\'," +
                "\'" + getTotal_radiation1_interval_cumulative() + "\'," +
                "\'" + getCumulative_divergent_radiation_interval() + "\'," +
                "\'" + getCumulative_direct_radiation_interval() + "\'," +
                "\'" + getTotal_radiation2_interval_cumulative() + "\'," +
                "\'" + getCumulative_net_radiation_interval() + "\'," +
                "\'" + getDaily_cumulative_photosynthetic_radiation() + "\'," +
                "\'" + getCumulative_interval_of_ultraviolet_radiation() + "\'," +
                "\'" + getSoil_heat_flux2() + "\'," +
                "\'" + getDaily_cumulative_rainfall() + "\'," +
                "\'" + getDaily_cumulative_sunshine() + "\'," +
                "\'" + getDaily_cumulative_total_radiation1() + "\'," +
                "\'" + getDaily_accumulation_of_scattered_radiation() + "\'," +
                "\'" + getDaily_accumulation_of_direct_radiation() + "\'," +
                "\'" + getDaily_cumulative_total_radiation2() + "\'," +
                "\'" + getDaily_cumulative_of_net_radiation() + "\'," +
                "\'" + getDaily_cumulative_photosynthetic_radiation() + "\'," +
                "\'" + getDaily_cumulative_ultraviolet_radiation() + "\'," +
                "\'" + getSoil_heat_flux3() + "\'," +
                "\'" + getIllumination() + "\'," +
                "\'" + getElectric_quantity() + "\'," +
                "\'" + getPm2_5() + "\' );";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAmbient_temperature() {
        return ambient_temperature;
    }

    public void setAmbient_temperature(float ambient_temperature) {
        this.ambient_temperature = ambient_temperature;
    }

    public float getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(float temperature1) {
        this.temperature1 = temperature1;
    }

    public float getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(float temperature2) {
        this.temperature2 = temperature2;
    }

    public float getTemperature3() {
        return temperature3;
    }

    public void setTemperature3(float temperature3) {
        this.temperature3 = temperature3;
    }

    public float getTemperature4() {
        return temperature4;
    }

    public void setTemperature4(float temperature4) {
        this.temperature4 = temperature4;
    }

    public float getTemperature5() {
        return temperature5;
    }

    public void setTemperature5(float temperature5) {
        this.temperature5 = temperature5;
    }

    public float getDew_point() {
        return dew_point;
    }

    public void setDew_point(float dew_point) {
        this.dew_point = dew_point;
    }

    public float getAmbient_humidity() {
        return ambient_humidity;
    }

    public void setAmbient_humidity(float ambient_humidity) {
        this.ambient_humidity = ambient_humidity;
    }

    public float getLand_humidity1() {
        return land_humidity1;
    }

    public void setLand_humidity1(float land_humidity1) {
        this.land_humidity1 = land_humidity1;
    }

    public float getLand_humidity2() {
        return land_humidity2;
    }

    public void setLand_humidity2(float land_humidity2) {
        this.land_humidity2 = land_humidity2;
    }

    public float getLand_humidity3() {
        return land_humidity3;
    }

    public void setLand_humidity3(float land_humidity3) {
        this.land_humidity3 = land_humidity3;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getEvaporation() {
        return evaporation;
    }

    public void setEvaporation(float evaporation) {
        this.evaporation = evaporation;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getTotal_radiation_1() {
        return total_radiation_1;
    }

    public void setTotal_radiation_1(float total_radiation_1) {
        this.total_radiation_1 = total_radiation_1;
    }

    public float getDivergent_radiation() {
        return divergent_radiation;
    }

    public void setDivergent_radiation(float divergent_radiation) {
        this.divergent_radiation = divergent_radiation;
    }

    public float getDirect_radiation() {
        return direct_radiation;
    }

    public void setDirect_radiation(float direct_radiation) {
        this.direct_radiation = direct_radiation;
    }

    public float getTotal_radiation_2() {
        return total_radiation_2;
    }

    public void setTotal_radiation_2(float total_radiation_2) {
        this.total_radiation_2 = total_radiation_2;
    }

    public float getNet_radiation() {
        return net_radiation;
    }

    public void setNet_radiation(float net_radiation) {
        this.net_radiation = net_radiation;
    }

    public float getPhotosynthetic_radiation() {
        return photosynthetic_radiation;
    }

    public void setPhotosynthetic_radiation(float photosynthetic_radiation) {
        this.photosynthetic_radiation = photosynthetic_radiation;
    }

    public float getUltraviolet_radiation() {
        return ultraviolet_radiation;
    }

    public void setUltraviolet_radiation(float ultraviolet_radiation) {
        this.ultraviolet_radiation = ultraviolet_radiation;
    }

    public float getSoil_heat_flux1() {
        return soil_heat_flux1;
    }

    public void setSoil_heat_flux1(float soil_heat_flux1) {
        this.soil_heat_flux1 = soil_heat_flux1;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getAverage_wind_speed_2minute() {
        return average_wind_speed_2minute;
    }

    public void setAverage_wind_speed_2minute(float average_wind_speed_2minute) {
        this.average_wind_speed_2minute = average_wind_speed_2minute;
    }

    public float getAverage_wind_speed_10minute() {
        return average_wind_speed_10minute;
    }

    public void setAverage_wind_speed_10minute(float average_wind_speed_10minute) {
        this.average_wind_speed_10minute = average_wind_speed_10minute;
    }

    public float getCumulative_rainfall_interval() {
        return cumulative_rainfall_interval;
    }

    public void setCumulative_rainfall_interval(float cumulative_rainfall_interval) {
        this.cumulative_rainfall_interval = cumulative_rainfall_interval;
    }

    public float getCumulative_sunshine_interval() {
        return cumulative_sunshine_interval;
    }

    public void setCumulative_sunshine_interval(float cumulative_sunshine_interval) {
        this.cumulative_sunshine_interval = cumulative_sunshine_interval;
    }

    public float getTotal_radiation1_interval_cumulative() {
        return total_radiation1_interval_cumulative;
    }

    public void setTotal_radiation1_interval_cumulative(float total_radiation1_interval_cumulative) {
        this.total_radiation1_interval_cumulative = total_radiation1_interval_cumulative;
    }

    public float getCumulative_divergent_radiation_interval() {
        return cumulative_divergent_radiation_interval;
    }

    public void setCumulative_divergent_radiation_interval(float cumulative_divergent_radiation_interval) {
        this.cumulative_divergent_radiation_interval = cumulative_divergent_radiation_interval;
    }

    public float getCumulative_direct_radiation_interval() {
        return cumulative_direct_radiation_interval;
    }

    public void setCumulative_direct_radiation_interval(float cumulative_direct_radiation_interval) {
        this.cumulative_direct_radiation_interval = cumulative_direct_radiation_interval;
    }

    public float getTotal_radiation2_interval_cumulative() {
        return total_radiation2_interval_cumulative;
    }

    public void setTotal_radiation2_interval_cumulative(float total_radiation2_interval_cumulative) {
        this.total_radiation2_interval_cumulative = total_radiation2_interval_cumulative;
    }

    public float getCumulative_net_radiation_interval() {
        return cumulative_net_radiation_interval;
    }

    public void setCumulative_net_radiation_interval(float cumulative_net_radiation_interval) {
        this.cumulative_net_radiation_interval = cumulative_net_radiation_interval;
    }

    public float getCumulative_interval_of_photosynthetic_radiation() {
        return cumulative_interval_of_photosynthetic_radiation;
    }

    public void setCumulative_interval_of_photosynthetic_radiation(float cumulative_interval_of_photosynthetic_radiation) {
        this.cumulative_interval_of_photosynthetic_radiation = cumulative_interval_of_photosynthetic_radiation;
    }

    public float getCumulative_interval_of_ultraviolet_radiation() {
        return cumulative_interval_of_ultraviolet_radiation;
    }

    public void setCumulative_interval_of_ultraviolet_radiation(float cumulative_interval_of_ultraviolet_radiation) {
        this.cumulative_interval_of_ultraviolet_radiation = cumulative_interval_of_ultraviolet_radiation;
    }

    public float getSoil_heat_flux2() {
        return soil_heat_flux2;
    }

    public void setSoil_heat_flux2(float soil_heat_flux2) {
        this.soil_heat_flux2 = soil_heat_flux2;
    }

    public float getDaily_cumulative_rainfall() {
        return daily_cumulative_rainfall;
    }

    public void setDaily_cumulative_rainfall(float daily_cumulative_rainfall) {
        this.daily_cumulative_rainfall = daily_cumulative_rainfall;
    }

    public float getDaily_cumulative_sunshine() {
        return daily_cumulative_sunshine;
    }

    public void setDaily_cumulative_sunshine(float daily_cumulative_sunshine) {
        this.daily_cumulative_sunshine = daily_cumulative_sunshine;
    }

    public float getDaily_cumulative_total_radiation1() {
        return daily_cumulative_total_radiation1;
    }

    public void setDaily_cumulative_total_radiation1(float daily_cumulative_total_radiation1) {
        this.daily_cumulative_total_radiation1 = daily_cumulative_total_radiation1;
    }

    public float getDaily_accumulation_of_scattered_radiation() {
        return daily_accumulation_of_scattered_radiation;
    }

    public void setDaily_accumulation_of_scattered_radiation(float daily_accumulation_of_scattered_radiation) {
        this.daily_accumulation_of_scattered_radiation = daily_accumulation_of_scattered_radiation;
    }

    public float getDaily_accumulation_of_direct_radiation() {
        return daily_accumulation_of_direct_radiation;
    }

    public void setDaily_accumulation_of_direct_radiation(float daily_accumulation_of_direct_radiation) {
        this.daily_accumulation_of_direct_radiation = daily_accumulation_of_direct_radiation;
    }

    public float getDaily_cumulative_total_radiation2() {
        return daily_cumulative_total_radiation2;
    }

    public void setDaily_cumulative_total_radiation2(float daily_cumulative_total_radiation2) {
        this.daily_cumulative_total_radiation2 = daily_cumulative_total_radiation2;
    }

    public float getDaily_cumulative_of_net_radiation() {
        return daily_cumulative_of_net_radiation;
    }

    public void setDaily_cumulative_of_net_radiation(float daily_cumulative_of_net_radiation) {
        this.daily_cumulative_of_net_radiation = daily_cumulative_of_net_radiation;
    }

    public float getDaily_cumulative_photosynthetic_radiation() {
        return daily_cumulative_photosynthetic_radiation;
    }

    public void setDaily_cumulative_photosynthetic_radiation(float daily_cumulative_photosynthetic_radiation) {
        this.daily_cumulative_photosynthetic_radiation = daily_cumulative_photosynthetic_radiation;
    }

    public float getDaily_cumulative_ultraviolet_radiation() {
        return daily_cumulative_ultraviolet_radiation;
    }

    public void setDaily_cumulative_ultraviolet_radiation(float daily_cumulative_ultraviolet_radiation) {
        this.daily_cumulative_ultraviolet_radiation = daily_cumulative_ultraviolet_radiation;
    }

    public float getSoil_heat_flux3() {
        return soil_heat_flux3;
    }

    public void setSoil_heat_flux3(float soil_heat_flux3) {
        this.soil_heat_flux3 = soil_heat_flux3;
    }

    public float getIllumination() {
        return illumination;
    }

    public void setIllumination(float illumination) {
        this.illumination = illumination;
    }

    public float getElectric_quantity() {
        return electric_quantity;
    }

    public void setElectric_quantity(float electric_quantity) {
        this.electric_quantity = electric_quantity;
    }

    public float getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(float pm2_5) {
        this.pm2_5 = pm2_5;
    }
}

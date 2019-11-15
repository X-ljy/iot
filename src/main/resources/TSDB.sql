-- 自动气象站 --
create table iot_automatic_weather_station (
ts timestamp,
id binary(20),
wind_speed float ,
rainfall float ,
temperature float ,
humidity float ,
illumination float ,
Photosynthesis float ,
wind_direction float ,
co2 float ,
ph float ,
soil_temperature_1 float ,
soil_moisture_1 float ,
soil_temperature_2 float ,
soil_moisture_2 float ,
soil_temperature_3 float ,
soil_moisture_3 float ,
conductance float
) tags (equipment_type binary(20),identification_id binary(20) );

create table t_iot_weather_station using iot_automatic_weather_station tags ('automatic_weather_station','16064201');

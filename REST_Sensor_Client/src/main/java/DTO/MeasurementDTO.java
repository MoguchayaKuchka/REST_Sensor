package DTO;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//Из-за ломбока хибернейт баговал (конкретно из-за нейминга raining)
//Можно в последствии отрефакторить
public class MeasurementDTO {
    private Double value;
    private Boolean isRaining;
    private SensorDTO sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return isRaining;
    }

    public void setRaining(Boolean raining) {
        isRaining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

}

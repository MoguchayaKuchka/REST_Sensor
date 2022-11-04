package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
//Конфликт ломбока и хибернейт
public class MeasurementResponse {
    List<MeasurementDTO> measurements;

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}

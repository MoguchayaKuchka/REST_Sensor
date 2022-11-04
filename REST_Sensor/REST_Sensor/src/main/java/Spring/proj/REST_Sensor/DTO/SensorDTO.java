package Spring.proj.REST_Sensor.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//@Getter
//@Setter
public class SensorDTO {
    @NotEmpty(message="Название сенсора не должно быть пустым")
    @Size(min=3,max=30,message="Название сенсора должно быть от 3 до 30 символов")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

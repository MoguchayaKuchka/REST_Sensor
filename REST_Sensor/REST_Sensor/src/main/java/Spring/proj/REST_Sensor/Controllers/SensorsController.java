package Spring.proj.REST_Sensor.Controllers;

import Spring.proj.REST_Sensor.DTO.SensorDTO;
import Spring.proj.REST_Sensor.Models.Sensor;
import Spring.proj.REST_Sensor.Services.SensorService;
import Spring.proj.REST_Sensor.utils.MeasurementErrorResponse;
import Spring.proj.REST_Sensor.utils.MeasurementException;
import Spring.proj.REST_Sensor.utils.SensorValidator;
import Spring.proj.REST_Sensor.utils.UtilError;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static Spring.proj.REST_Sensor.utils.UtilError.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorsController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    public SensorsController(SensorService sensorService, ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(
            @RequestBody @Valid SensorDTO sensorDTO,
            BindingResult bindingResult
            ){
        Sensor sensorToAdd = convertToSensor(sensorDTO);

        sensorValidator.validate(sensorToAdd,bindingResult);
        if(bindingResult.hasErrors()){
            returnErrorsToClient(bindingResult);
        }

        sensorService.register(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e)
    {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return ResponseEntity.badRequest().body(response);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO,Sensor.class);
    }
}

package Spring.proj.REST_Sensor.Repositories;

import Spring.proj.REST_Sensor.Models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
}

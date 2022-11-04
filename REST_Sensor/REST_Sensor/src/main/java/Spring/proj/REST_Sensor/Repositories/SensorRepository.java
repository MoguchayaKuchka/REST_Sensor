package Spring.proj.REST_Sensor.Repositories;

import Spring.proj.REST_Sensor.Models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,String> {
    Optional<Sensor> findByName(String name);
}

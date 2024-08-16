package repo;

import model.Device;
import model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    void deleteDeviceById(Long id);
    boolean existsById(Long id);
    Device findDeviceById(Long id);
}

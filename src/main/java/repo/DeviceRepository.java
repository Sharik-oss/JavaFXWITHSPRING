package repo;

import model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    void deleteDeviceById(Long id);

    Device findDeviceById(Long id);
}

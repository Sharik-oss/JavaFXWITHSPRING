package repo;

import model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    void deleteDeviceById(Long id);
    boolean existsById(Long id);
    Device findDeviceById(Long id);
}

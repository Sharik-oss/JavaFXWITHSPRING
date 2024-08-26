package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import model.Device;
import org.springframework.stereotype.Service;
import repo.DeviceRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServices {

    private final DeviceRepository deviceRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Device addDevice(Device device) {
        try {
            Device savedDevice = deviceRepository.save(device);
            return savedDevice;

        } catch (Exception e) {
            System.err.println("Error saving device: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long id) {
        return deviceRepository.findDeviceById(id);
    }

    @Transactional
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}

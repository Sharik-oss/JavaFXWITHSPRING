package services;

import lombok.RequiredArgsConstructor;
import model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.DeviceRepository;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class DeviceServices {

    private final DeviceRepository deviceRepository;
    @Autowired
    public DeviceServices(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void addDevice(Device device) {
            deviceRepository.save(device);
    }

    public List<Device> findAllDevice() {
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
        deviceRepository.deleteDeviceById(id);
    }
}

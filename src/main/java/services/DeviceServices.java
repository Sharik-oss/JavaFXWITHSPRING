package services;

import lombok.RequiredArgsConstructor;
import model.Device;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.DeviceRepository;

import java.util.List;

@Service
public class DeviceServices {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServices(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void addDevice(Device device){
        try {
            deviceRepository.save(device);
            System.out.println("Device saved successfully");
        } catch (Exception e) {
            System.err.println("Error saving device: " + e.getMessage());
        }
    }

    public List<Device> findAllDevice(){
        return deviceRepository.findAll();
    }

    public Device updateDevice(Device device){
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long id){
        return deviceRepository.findDeviceById(id);
    }


    @Transactional
    public void deleteDevice(Long id){
        deviceRepository.deleteDeviceById(id);
    }
}

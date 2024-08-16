package services;

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
    public DeviceServices(DeviceRepository playstationRepository){
        this.deviceRepository = playstationRepository;
    }


    public Device addPlaystation(Device device){
        return deviceRepository.save(device);
    }

    public List<Device> findAllPlaystation(){
        return deviceRepository.findAll();
    }

    public Device updatePlaystation(Device device){
        return deviceRepository.save(device);
    }

    public Device findPlaystationById(Long id){
        return deviceRepository.findDeviceById(id);
    }


    @Transactional
    public void deleteDevice(Long id){
        deviceRepository.deleteDeviceById(id);
    }
}

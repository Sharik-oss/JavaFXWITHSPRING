package services;

import model.Hookah;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.HookahRepository;

import java.util.List;


@Service
public class HookahServices {
    private final HookahRepository hookahRepository;

    @Autowired
    public HookahServices(HookahRepository hookahRepository){
        this.hookahRepository = hookahRepository;
    }


    public Hookah addHookah(Hookah hookah){
        return hookahRepository.save(hookah);
    }

    public List<Hookah> findAllHookah(){
        return hookahRepository.findAll();
    }

    public Hookah updateHookah(Hookah hookah){
        return hookahRepository.save(hookah);
    }

    public Hookah findHookahById(Long id){
        return hookahRepository.findHookahById(id);
    }


    @Transactional
    public void deleteHookah(Long id){
        hookahRepository.findHookahById(id);
    }
}

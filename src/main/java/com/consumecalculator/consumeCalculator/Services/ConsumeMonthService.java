package com.consumecalculator.consumeCalculator.Services;

import com.consumecalculator.consumeCalculator.DTO.ConsumeMonthDTO;
import com.consumecalculator.consumeCalculator.Entities.ConsumeMonth;
import com.consumecalculator.consumeCalculator.Entities.User;
import com.consumecalculator.consumeCalculator.Repositories.ConsumeMonthRepository;
import com.consumecalculator.consumeCalculator.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConsumeMonthService {
    @Autowired
    private ConsumeMonthRepository consumeMonthRepository;
    @Autowired
    private UserServices userServices;
    @Autowired
    private ConsumeMonthDTO consumeMonthDTO;

    public ConsumeMonth createConsumeRecord (ConsumeMonthDTO consumeMonthDTO) throws Exception {

        String date=consumeMonthDTO.getDate();
        String user = consumeMonthDTO.getUserId();

        boolean response = getRecordByUserAndDate(user, date).isEmpty();

        if (!response){
            throw new Exception("Record already in the DB");
        }else {
            ConsumeMonth consumeMonth = new ConsumeMonth();

            consumeMonth.setUser(userServices.getUserById(consumeMonthDTO
                    .getUserId()).orElseThrow(() -> new Exception("User not found")));
            consumeMonth.setIdConsumeMonth(consumeMonthDTO.getIdConsumeMonth());
            consumeMonth.setGasCons(consumeMonthDTO.getGasCons());
            consumeMonth.setWaterCons(consumeMonthDTO.getWaterCons());
            consumeMonth.setElectricityCons(consumeMonthDTO.getElectricityCons());
            consumeMonth.setDate(consumeMonthDTO.getDate());

            return consumeMonthRepository.save(consumeMonth);
        }
    }

    public List<ConsumeMonth> getRecordByUserAndDate (String userId, String date) throws Exception {

        User user = userServices.getUserById(userId).orElseThrow(()-> new Exception("User not found with ID: " + userId));

        return consumeMonthRepository.findByUserAndDate(user, date);
    }

    public Optional<ConsumeMonth> getRecordById(int recordId){
        return consumeMonthRepository.findById(String.valueOf(recordId));
    }

    public ConsumeMonth updateRecord(ConsumeMonthDTO consumeMonthDTO) throws Exception {
        ConsumeMonth consumeMonthInDB = getRecordById(consumeMonthDTO.getIdConsumeMonth())
                .orElseThrow(()-> new Exception
                        ("No record with ID: " + consumeMonthDTO.getIdConsumeMonth()));

        if (!consumeMonthDTO.getDate().equals(consumeMonthInDB.getDate())){
            consumeMonthInDB.setDate(consumeMonthDTO.getDate());
        }
        if (consumeMonthDTO.getGasCons()!=(consumeMonthInDB.getGasCons())){
            consumeMonthInDB.setGasCons(consumeMonthDTO.getGasCons());
        }
        if (consumeMonthDTO.getWaterCons()!=(consumeMonthInDB.getWaterCons())){
            consumeMonthInDB.setWaterCons(consumeMonthDTO.getWaterCons());
        }
        if (consumeMonthDTO.getElectricityCons()!=(consumeMonthInDB.getElectricityCons())){
            consumeMonthInDB.setElectricityCons(consumeMonthDTO.getElectricityCons());
        }
        return consumeMonthRepository.save(consumeMonthInDB);
    }

    public List<ConsumeMonth> getAllRecordsByUserId(String userId) throws Exception {
        User user = userServices.getUserById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        return consumeMonthRepository.findByUser(user);
    }

    public void deleteRecordByDateAndUserId (String userId, String date) throws Exception {
        User user = userServices.getUserById(userId).orElseThrow(()-> new Exception("User not found with ID: " + userId));
        consumeMonthRepository.deleteByUserAndDate(user, date);
    }
}

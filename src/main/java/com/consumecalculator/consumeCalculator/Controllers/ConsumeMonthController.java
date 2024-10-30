package com.consumecalculator.consumeCalculator.Controllers;

import com.consumecalculator.consumeCalculator.DTO.ConsumeMonthDTO;
import com.consumecalculator.consumeCalculator.Entities.ConsumeMonth;
import com.consumecalculator.consumeCalculator.Services.ConsumeMonthService;
import com.consumecalculator.consumeCalculator.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consume")
public class ConsumeMonthController {
    @Autowired
    private ConsumeMonthService consumeMonthService;
    @Autowired
    private ConsumeMonthDTO consumeMonthDTO;
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<ConsumeMonth> createMonthRecord(@RequestBody ConsumeMonthDTO consumeMonthDTO) throws Exception {
        ConsumeMonth consumeMonthRecord = consumeMonthService.createConsumeRecord(consumeMonthDTO);
        return new ResponseEntity<>(consumeMonthRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ConsumeMonthDTO> getAllRecords(){
        return null;
    }

    @GetMapping("/user/{id_user}")
    public List<ConsumeMonth> getRecordsByUserId(@PathVariable String id_user) throws Exception {
        return consumeMonthService.getAllRecordsByUserId(id_user);
    }

    @GetMapping("/user/{id_user}/{date}")
    public List<ConsumeMonth> getRecordsByUserId(@PathVariable String id_user, @PathVariable String date) throws Exception {
        return consumeMonthService.getRecordByUserAndDate(id_user, date);
    }

    @PutMapping
    public ResponseEntity<ConsumeMonth> updateRecord(@RequestBody ConsumeMonthDTO consumeMonthDTO) throws Exception {
        ConsumeMonth consumeMonthUpdateRecord = consumeMonthService.updateRecord(consumeMonthDTO);
        return new ResponseEntity<>(consumeMonthUpdateRecord, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecordByUserAndDate (String userId, String date) throws Exception {
        consumeMonthService.deleteRecordByDateAndUserId(userId, date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
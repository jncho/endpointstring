package es.gt.endpointstring.controller;

import es.gt.endpointstring.model.StringRecord;
import es.gt.endpointstring.repository.StringRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StringController {

    @Autowired
    private StringRecordRepository stringRecordRepository;

    @GetMapping("/add")
    public StringRecord add(@RequestParam(value="record") String record){
        return this.stringRecordRepository.save(new StringRecord(record,record.toUpperCase()));
    }

}

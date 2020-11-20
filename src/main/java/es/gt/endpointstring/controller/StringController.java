package es.gt.endpointstring.controller;

import es.gt.endpointstring.model.StringRecord;
import es.gt.endpointstring.model.StringRecordInput;
import es.gt.endpointstring.repository.StringRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestController
public class StringController {

    @Autowired
    private StringRecordRepository stringRecordRepository;

    @PostMapping("/add")
    public StringRecord add(@RequestBody StringRecordInput input) throws MissingServletRequestPartException {
        String record = input.getInputString();
        if (record == null){
            throw new MissingServletRequestPartException("inputString");
        }
        return this.stringRecordRepository.save(new StringRecord(record,record.toUpperCase()));
    }

}

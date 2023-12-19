package com.data.controller;

import com.data.model.Progress;
import com.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;
    private final Progress progress;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/employee", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    ResponseEntity<HttpStatus> loadCSV(@RequestParam("file") MultipartFile file) throws Exception {
        dataService.loadCSV(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/employee", produces = "application/json")
    public ResponseEntity findAllEmployee() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(dataService.findAllEmployee().get().size(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/percentage")
    public ResponseEntity<Integer> getProgressPercentage() {
        return new ResponseEntity<>(progress.getPercentComplete(), HttpStatus.OK);
    }
}

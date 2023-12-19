package com.data.service.impl;

import com.data.EmployeeRepository;
import com.data.Progress;
import com.data.domain.EmployeeDetail;
import com.data.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final Progress progress;
    private final EmployeeRepository employeeRepository;

    @Override
    @Async
    public CompletableFuture<List<EmployeeDetail>> loadCSV(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<EmployeeDetail> employeeDetailList = getEmployee(file);
        int totalRecords = employeeDetailList.size();
        for (int i = 0; i < totalRecords; i++) {
            employeeRepository.save(employeeDetailList.get(i));
            int percentComplete = (i + 1) * 100 / totalRecords;
            progress.setPercentComplete(percentComplete);
        }
        log.info("saving list of employee of size {}", employeeDetailList.size(), "" + Thread.currentThread().getName());
        long end = System.currentTimeMillis();
        log.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(employeeDetailList);
    }

    @Async
    public CompletableFuture<List<EmployeeDetail>> findAllEmployee() {
        log.info("get list of employee by " + Thread.currentThread().getName());
        List<EmployeeDetail> employeeDetailList = employeeRepository.findAll();
        return CompletableFuture.completedFuture(employeeDetailList);
    }

    static List<EmployeeDetail> getEmployee(final MultipartFile file) throws Exception {
        final List<EmployeeDetail> employeeDetailList = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final EmployeeDetail employeeDetail = new EmployeeDetail();
                    employeeDetail.setFirstName(data[0]);
                    employeeDetail.setLastName(data[1]);
                    employeeDetailList.add(employeeDetail);
                }
                return employeeDetailList;
            }
        } catch (final IOException e) {
            log.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }
}


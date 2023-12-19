package com.data.service;

import com.data.domain.EmployeeDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DataService {

    CompletableFuture<List<EmployeeDetail>> loadCSV(MultipartFile file) throws Exception;
    CompletableFuture<List<EmployeeDetail>> findAllEmployee();
}

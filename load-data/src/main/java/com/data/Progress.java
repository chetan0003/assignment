package com.data;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Progress {

    private volatile int percentComplete;
    
}

package com.gx.sp3.demo.gtmf.extension;

import com.gx.sp3.demo.gtmf.param.RequestSource;
import jakarta.annotation.Nonnull;
import lombok.Data;

import java.util.Set;

@Data
public abstract class ExecuteExtRequest {
    /**
     *
     */
    @Nonnull
    protected Set<String> bizCodes;

    /**
     *
     */
    protected RequestSource requestSource;

    protected ExecuteExtRequest() {
    }
}

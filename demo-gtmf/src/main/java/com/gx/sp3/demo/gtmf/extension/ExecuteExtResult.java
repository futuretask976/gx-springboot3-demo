package com.gx.sp3.demo.gtmf.extension;

import com.gx.sp3.demo.gtmf.metadata.ExtensionMetadata;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

public class ExecuteExtResult<T> {
    /**
     *
     */
    @Nonnull
    @Getter
    @Setter
    private ExtensionMetadata extensionMetadata;

    /**
     *
     */
    @Nonnull
    @Getter
    @Setter
    private T result;

    public ExecuteExtResult(ExtensionMetadata extensionMetadata, T result) {
        this.extensionMetadata = extensionMetadata;
        this.result = result;
    }
}

package com.fabits.crm.upload;

import java.util.Arrays;
import java.util.function.Consumer;

public enum UploadType {
    TRANSACTION_INFO {
        @Override
        public Consumer<String[]> process() {
            return (data) -> System.out.println(Arrays.asList(data));
        }

        @Override
        public Consumer<? extends Throwable> errorConsumer() {
            return null;
        }
    };

    public abstract Consumer<String[]> process();

    public abstract Consumer<? extends Throwable> errorConsumer();

}

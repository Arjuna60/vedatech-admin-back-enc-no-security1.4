package com.vedatech.admin.services.readfile;


import java.io.IOException;

public interface ReadTClassService<T, ID> {

    void readWithCsvBeanReader(Class<T> tClass, String file) throws IOException;

}

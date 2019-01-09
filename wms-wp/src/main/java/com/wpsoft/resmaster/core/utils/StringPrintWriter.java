package com.wpsoft.resmaster.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: WP
 * @Description:
 * @Date: 20:41 2019/1/3
 * @Modified By:
 */
public class StringPrintWriter extends PrintWriter {
    public StringPrintWriter(){
        super(new StringWriter());
    }
    public StringPrintWriter(int initialSize) {
        super(new StringWriter(initialSize));
    }

    public String getString() {
        flush();
        return ((StringWriter) this.out).toString();
    }

    @Override
    public String toString() {
        return getString();
    }
}

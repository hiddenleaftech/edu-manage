package com.hiddenleaf.util;
import java.io.Serializable;


public interface Identifiable<T extends Serializable> {

    T getId();
    T getPrefix();
}

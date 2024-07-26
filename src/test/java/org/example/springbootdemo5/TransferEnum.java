package org.example.springbootdemo5;

import org.apache.rocketmq.common.filter.impl.Op;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TransferEnum {

    ADDRESS_1("123","456");
     String fromAddress;
     String toAddress;

    TransferEnum(String fromAddress,String toAddress){
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }


    TransferEnum() {
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    @Test
    public void test1(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}

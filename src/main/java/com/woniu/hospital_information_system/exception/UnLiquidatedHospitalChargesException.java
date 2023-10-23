package com.woniu.hospital_information_system.exception;

public class UnLiquidatedHospitalChargesException extends RuntimeException {

    public UnLiquidatedHospitalChargesException() {
    }

    public UnLiquidatedHospitalChargesException(String message) {
        super(message);
    }

    public UnLiquidatedHospitalChargesException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnLiquidatedHospitalChargesException(Throwable cause) {
        super(cause);
    }

    public UnLiquidatedHospitalChargesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

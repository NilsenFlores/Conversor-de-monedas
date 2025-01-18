package com.nilsen.conversorMonedas;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public record DatosParMonedas(BigDecimal conversion_result, BigDecimal conversion_rate, String result, @SerializedName("error-type") String errorType) {
}

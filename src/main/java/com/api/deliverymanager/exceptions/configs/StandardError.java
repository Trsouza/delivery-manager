package com.api.deliverymanager.exceptions.configs;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer status;
    private String error;
    private String message;
    private String path;
    private Long timestamp;
}

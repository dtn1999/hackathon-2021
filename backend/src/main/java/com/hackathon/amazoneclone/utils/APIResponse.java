package com.hackathon.amazoneclone.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author danyls ngongang
 * @Created 12/09/2021-10:36
 * @Project user-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse<D,E> {
    private  boolean success;
    private D data;
    private E error;
}

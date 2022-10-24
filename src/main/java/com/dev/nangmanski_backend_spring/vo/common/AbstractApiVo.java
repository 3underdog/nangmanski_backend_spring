package com.dev.nangmanski_backend_spring.vo.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractApiVo extends AbstractBaseVo {
    private static final long serialVersionUID = 1L;
}

package org.leandroloureiro.demo.springdatajdbctest.model;

import javax.validation.constraints.NotBlank;

public record CustomerRequest(@NotBlank String name) {

}

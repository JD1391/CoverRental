package com.rentalcover.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    String browser();

    String url();

    String rentalCountry();

    String fromDate();

    String toDate();

    String actualString();

}

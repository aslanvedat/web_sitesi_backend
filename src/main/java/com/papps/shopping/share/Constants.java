package com.papps.shopping.share;

/**
 * @author : Onur TALANTIMUR
 * @mailto : onurta@netas.com.tr
 * @created : 12.07.2024, Friday
 **/
public class Constants {

    public static class JWT{
        public static final String KEY_ALGORITHM = "HmacSHA256";
        public static final int KEY_SIZE = 256;
        public static final String AUTHORITIES_CLAIM = "authorities";
        public static final String BEARER_PREFIX = "Bearer ";
    }

    public static class ROLES{
        public static final String ROLE_USER = "USER";
        public static final String ROLE_ADMIN = "ADMIN";
        public static final String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
    }


}

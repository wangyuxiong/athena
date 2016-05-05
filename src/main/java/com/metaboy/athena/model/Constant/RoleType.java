package com.metaboy.athena.model.Constant;

/**
 * Created by metaboy on 16/5/5.
 */
public enum RoleType {

    OWNER(1), PM(2), PD(3), DEV(4), TESTER(5), PE(6), READER(0);

    public int roleType;

    RoleType(int roleType) {
        this.roleType = roleType;
    }

    public int getValue() {
        return roleType;
    }
}

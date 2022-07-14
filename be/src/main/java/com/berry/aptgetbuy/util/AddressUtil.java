package com.berry.aptgetbuy.util;

public class AddressUtil {

    public static String assembleAddrPartsToLegacyAddr(
            String addrLv1,
            String addrLv2,
            String addrLv3,
            String bunjiMain,
            String bunjiSub
    ) {
        return addrLv1 + " " + addrLv2 + " " + addrLv3 + " " + assembleBunjiMainAndBunjiSub(bunjiMain, bunjiSub).trim();
    }

    public static String changeComplexAddrToLegacyAddr(
            String aptName,
            String complexAddr
    ) {
        return complexAddr.substring(0, complexAddr.length() - aptName.length()).trim();
    }

    public static String assembleBunjiMainAndBunjiSub(
            String bunjiMain,
            String bunjiSub
    ) {
        return bunjiSub.equals("0") ? bunjiMain : bunjiMain + "-" + bunjiSub;
    }

}

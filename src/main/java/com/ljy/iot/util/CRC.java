package com.ljy.iot.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * @author : 夕
 * @date : 2019/9/25
 */
public class CRC {

    /**
     * 计算CRC16校验码
     *
     * @param bytes
     * @return
     */
    public static byte[] getCRC(byte[] bytes) throws DecoderException {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }

        String temp = Integer.toHexString(CRC);

        System.out.println("校验返回值的lengh: " + temp.length());

        String a = temp.substring(0,2);
        String b = temp.substring(2,4);


        byte[] second = Hex.decodeHex(a);
        byte[] first  = Hex.decodeHex(b);

        byte[] resBytes = new byte[]{first[0],second[0]};

        return resBytes;
    }

//    System.out.println(Integer.toHexString(a));

}

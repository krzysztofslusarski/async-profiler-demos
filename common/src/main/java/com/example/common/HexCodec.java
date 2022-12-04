package com.example.common;

class HexCodec {
    public static long lowerHexToUnsignedLong(CharSequence lowerHex) {
        int length = lowerHex.length();
        if (length >= 1 && length <= 32) {
            int beginIndex = length > 16 ? length - 16 : 0;
            return lowerHexToUnsignedLong(lowerHex, beginIndex);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static long lowerHexToUnsignedLong(CharSequence value, int beginIndex) {
        int endIndex = Math.min(beginIndex + 16, value.length());
        long result = lenientLowerHexToUnsignedLong(value, beginIndex, endIndex);
        if (result == 0L) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static long lenientLowerHexToUnsignedLong(CharSequence value, int beginIndex, int endIndex) {
        long result = 0L;
        int pos = beginIndex;

        while(true) {
            while(pos < endIndex) {
                char c = value.charAt(pos++);
                result <<= 4;
                if (c < '0' || c > '9') {
                    if (c < 'a' || c > 'f') {
                        return 0L;
                    }

                    result |= (long)(c - 97 + 10);
                } else {
                    result |= (long)(c - 48);
                }
            }

            return result;
        }
    }
}

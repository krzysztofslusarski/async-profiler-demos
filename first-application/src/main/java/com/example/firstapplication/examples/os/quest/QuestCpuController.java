package com.example.firstapplication.examples.os.quest;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/os/quest/cpu")
@RequiredArgsConstructor
class QuestCpuController {
    public static final int COUNT = 10000;

    private final AtomicInteger counter = new AtomicInteger();

    private final CharSeqFirstImpl charSequence1 = new CharSeqFirstImpl(RandomStringUtils.random(100));
    private final CharSeqSecondImpl charSequence2 = new CharSeqSecondImpl(charSequence1.toString());
    private final CharSeqThirdImpl charSequence3 = new CharSeqThirdImpl(charSequence1.toString());

    @GetMapping("/megamorphic")
    String megamorphic() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMega(charSequence1);
            currentVal += hashCodeMega(charSequence2);
            currentVal += hashCodeMega(charSequence3);
        }
        return "" + currentVal;
    }

    @GetMapping("/megamorphic-fixed")
    String megamorphicFixed() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMegaFixed(charSequence1);
            currentVal += hashCodeMegaFixed(charSequence2);
            currentVal += hashCodeMegaFixed(charSequence3);
        }
        return "" + currentVal;
    }

    @GetMapping("/megamorphic-hacked")
    String megamorphicHacked() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMegaHacked(charSequence1);
            currentVal += hashCodeMegaHacked(charSequence2);
            currentVal += hashCodeMegaHacked(charSequence3);
        }
        return "" + currentVal;
    }

    public static int hashCodeMega(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaHacked0(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaHacked1(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaHacked2(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaHacked3(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaHacked(CharSequence value) {
        return switch (value.getClass().hashCode() & 3) {
            case 0 -> hashCodeMegaHacked0(value);
            case 1 -> hashCodeMegaHacked1(value);
            case 2 -> hashCodeMegaHacked2(value);
            case 3 -> hashCodeMegaHacked3(value);
            default -> throw new IllegalStateException("Unexpected value: " + (value.getClass().hashCode() & 3));
        };
    }

    public static int hashCodeMegaFixed(CharSeqFirstImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaFixed(CharSeqSecondImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    public static int hashCodeMegaFixed(CharSeqThirdImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }
}

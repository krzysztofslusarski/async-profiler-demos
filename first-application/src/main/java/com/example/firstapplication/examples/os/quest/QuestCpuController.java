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
    private static final int COUNT = 10000;

    private final AtomicInteger counter = new AtomicInteger();

    private final CharSeqFirstImpl charSequence1 = new CharSeqFirstImpl(RandomStringUtils.random(100));
    private final CharSeqSecondImpl charSequence2 = new CharSeqSecondImpl(charSequence1.toString());
    private final CharSeqThirdImpl charSequence3 = new CharSeqThirdImpl(charSequence1.toString());
    private final CharSeqForthImpl charSequence4 = new CharSeqForthImpl(charSequence1.toString());

    @GetMapping("/megamorphic")
    String megamorphic() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMega(charSequence1);
            currentVal += hashCodeMega(charSequence2);
            currentVal += hashCodeMega(charSequence3);
            currentVal += hashCodeMega(charSequence4);
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
            currentVal += hashCodeMegaFixed(charSequence4);
        }
        return "" + currentVal;
    }

    private static int hashCodeMega(CharSequence value) {
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

    private static int hashCodeMegaFixed(CharSeqFirstImpl value) {
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

    private static int hashCodeMegaFixed(CharSeqSecondImpl value) {
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

    private static int hashCodeMegaFixed(CharSeqThirdImpl value) {
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

    private static int hashCodeMegaFixed(CharSeqForthImpl value) {
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

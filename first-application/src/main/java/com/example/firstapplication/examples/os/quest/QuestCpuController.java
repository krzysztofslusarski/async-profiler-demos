package com.example.firstapplication.examples.os.quest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/os/quest/cpu")
@RequiredArgsConstructor
class QuestCpuController {
    private final QuectCpuInterfaceService interfaceService;
    private final QuectCpuClassesService classesService;

    @GetMapping("/interface/megamorphic")
    String interfaceMegamorphic() {
        return String.valueOf(interfaceService.megamorphic());
    }

    @GetMapping("/interface/megamorphic-hacked")
    String interfaceMegamorphicHacked() {
        return String.valueOf(interfaceService.megamorphicHacked());
    }

    @GetMapping("/interface/megamorphic-type-check")
    String interfaceMegamorphicTypeCheck() {
        return String.valueOf(interfaceService.megamorphicTypeCheck());
    }

    @GetMapping("/interface/megamorphic-fixed")
    String interfaceMegamorphicFixed() {
        return String.valueOf(interfaceService.megamorphicFixed());
    }

    @GetMapping("/classes/megamorphic")
    String classesMegamorphic() {
        return String.valueOf(classesService.megamorphic());
    }

    @GetMapping("/classes/megamorphic-hacked")
    String classesMegamorphicHacked() {
        return String.valueOf(classesService.megamorphicHacked());
    }

    @GetMapping("/classes/megamorphic-type-check")
    String classesMegamorphicTypeCheck() {
        return String.valueOf(classesService.megamorphicTypeCheck());
    }

    @GetMapping("/classes/megamorphic-fixed")
    String classesMegamorphicFixed() {
        return String.valueOf(classesService.megamorphicFixed());
    }
}

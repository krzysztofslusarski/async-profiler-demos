package com.example.firstapplication.examples.cpu;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
class CpuService {
    private final SampleEntityRepository sampleEntityRepository;
    private final SampleConfigurationRepository sampleConfigurationRepository;

    @Transactional
    public UUID prepare() {
        Set<SampleSubEntity> subEntities = new HashSet<>();
        for (long i = 0; i < 100_000; i++) {
            subEntities.add(new SampleSubEntity(new UUID(0L, i)));
        }
        SampleEntity entity = new SampleEntity(UUID.randomUUID(), subEntities, false);
        sampleEntityRepository.save(entity);
        for (int i = 0; i < 100; i++) {
            sampleConfigurationRepository.save(new SampleConfiguration("key-" + i, "value-" + i));
        }
        return entity.getId();
    }

    @Transactional
    public void inverse(UUID uuid) {
        sampleEntityRepository.findById(uuid).ifPresent(sampleEntity -> {
            boolean allConfigPresent = true;
            for (int i = 0; i < 100; i++) {
                allConfigPresent = allConfigPresent && sampleConfigurationRepository.existsById("key-" + i);
            }
            sampleEntity.setFlag(!sampleEntity.isFlag());
        });
    }
}

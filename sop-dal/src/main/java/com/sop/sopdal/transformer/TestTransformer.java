package com.sop.sopdal.transformer;

import com.sop.sopdal.domain.Test;
import com.sop.sopdal.dto.TestDTO;
import org.springframework.stereotype.Component;

@Component
public class TestTransformer implements Transformer<Test, TestDTO> {

    @Override
    public Test toEntity(TestDTO dto) {
        Test test = new Test();
        test.setTest(dto.getTest());
        return test;
    }

    @Override
    public TestDTO toDTO(Test entity) {
        TestDTO testDTO = new TestDTO();
        testDTO.setTest(entity.getTest());
        return testDTO;
    }
}

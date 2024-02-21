package com.stack.model;

import com.stack.model.license.LicensePlate;
import com.stack.model.license.LicensePlateFactory;
import com.stack.model.license.State;
import com.stack.model.provider.LicensePlateArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LicensePlateFactoryTest {

    @ParameterizedTest
    @ArgumentsSource(LicensePlateArgumentsProvider.class)
    void testMakeNextPlate(State prefix, int nextNumber, String expected) {
        LicensePlateFactory maker = new LicensePlateFactory(prefix, nextNumber);

        List<LicensePlate> plates = new ArrayList<>();
        plates.add(maker.makeNextPlate());
        plates.add(maker.makeNextPlate());
        plates.add(maker.makeNextPlate());
        plates.add(maker.makeNextPlate());
        plates.add(maker.makeNextPlate());
        assertEquals(expected, plates.get(0).plate());

        for (int i = 1; i < plates.size(); i++) {
            assertEquals(prefix.getAbbreviation() + "-"+ (nextNumber + i) ,
                         plates.get(i).plate());
        }
    }
}

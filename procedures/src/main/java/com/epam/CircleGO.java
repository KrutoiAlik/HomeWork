package com.epam;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

import static java.lang.Math.PI;

@Log4j2
@Value
public class CircleGO extends GeometricObject {

    private double radius;

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * WARN!!! Use for tests only! Don`t use it for business-logic!
     */
    @SneakyThrows
    public CircleGO setRadius(double radius) {
        Field field;
        field = CircleGO.class.getField("radius");
        field.setAccessible(true);
        field.set(this, radius);

        return this;
    }
}

package com.stack.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Board {
    private String name;
    private String location;
    private Route route;
    private boolean busy;
    private double speed;
    private double x;
    private double y;
    private double angle;

    private boolean noBusy() {
        return !busy;
    }

    private void calculatePosition(RoutePath direction) {
        double t = direction.getProgress() / 100;
        double toX = (1 - t) * direction.getFrom().getX() + t * direction.getTo().getX();
        double toY = (1 - t) * direction.getFrom().getY() + t * direction.getTo().getY();
        double deltaX = this.x - toX;
        double deltaY = this.y - toY;
        this.angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
        if (this.angle < 0) {
            this.angle = 360 + this.angle;
        }
        this.x = toX;
        this.y = toY;
    }
}

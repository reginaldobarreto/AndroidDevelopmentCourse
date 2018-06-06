package br.com.barrsoft.androiddevelopmentcourse.events;

import br.com.barrsoft.androiddevelopmentcourse.models.RocketModel;

public class SpacexEvent {

    private final RocketModel rocket;

    public SpacexEvent(RocketModel rocket) {
        this.rocket = rocket;
    }

    public RocketModel getRocket() {
        return rocket;
    }
}

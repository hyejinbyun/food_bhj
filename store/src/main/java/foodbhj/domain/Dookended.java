package foodbhj.domain;

import foodbhj.domain.*;
import foodbhj.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Dookended extends AbstractEvent {

    private Long id;

    public Dookended(Cook aggregate) {
        super(aggregate);
    }

    public Dookended() {
        super();
    }
}

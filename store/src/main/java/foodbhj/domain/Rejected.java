package foodbhj.domain;

import foodbhj.domain.*;
import foodbhj.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;

    public Rejected(Cook aggregate) {
        super(aggregate);
    }

    public Rejected() {
        super();
    }
}

package foodbhj.domain;

import foodbhj.domain.*;
import foodbhj.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordercnceled extends AbstractEvent {

    private Long id;

    public Ordercnceled(Order aggregate) {
        super(aggregate);
    }

    public Ordercnceled() {
        super();
    }
}

package foodbhj.domain;

import foodbhj.domain.*;
import foodbhj.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cookstarted extends AbstractEvent {

    private Long id;
    private String orderid;

    public Cookstarted(Cook aggregate) {
        super(aggregate);
    }

    public Cookstarted() {
        super();
    }
}

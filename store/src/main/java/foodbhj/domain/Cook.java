package foodbhj.domain;

import foodbhj.StoreApplication;
import foodbhj.domain.Cookstarted;
import foodbhj.domain.Dookended;
import foodbhj.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String foodid;

    private String opttion;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();

        Dookended dookended = new Dookended(this);
        dookended.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public static void foodOrder(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}

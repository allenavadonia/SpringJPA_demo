package jpaTest.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Bonus entity.
 */
@Entity
@Table(name = "bonus")
public class BonusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bonus_id")
    private int bonusId;

    @ManyToOne
    @JoinColumn(name = "worker_ref_id")
    private WorkerEntity workerRefId;

    @Column(name = "bonus_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date bonusDate;

    @Column(name = "bonus_amount")
    private int bonusAmount;

    public BonusEntity() {
    }

    public BonusEntity(WorkerEntity workerRefId) {
        this.workerRefId = workerRefId;
    }

    /**
     * Gets bonus id.
     *
     * @return the bonus id
     */
    public int getBonusId() {
        return bonusId;
    }

    /**
     * Sets bonus id.
     *
     * @param bonusId the bonus id
     */
    public void setBonusId(int bonusId) {
        this.bonusId = bonusId;
    }

    /**
     * Gets worker ref id.
     *
     * @return the worker ref id
     */
    public WorkerEntity getWorkerRefId() {
        return workerRefId;
    }

    /**
     * Sets worker ref id.
     *
     * @param workerRefId the worker ref id
     */
    public void setWorkerRefId(WorkerEntity workerRefId) {
        this.workerRefId = workerRefId;
    }

    /**
     * Gets bonus date.
     *
     * @return the bonus date
     */
    public Date getBonusDate() {
        return bonusDate;
    }

    /**
     * Sets bonus date.
     *
     * @param bonusDate the bonus date
     */
    public void setBonusDate(Date bonusDate) {
        this.bonusDate = bonusDate;
    }

    /**
     * Gets bonus amount.
     *
     * @return the bonus amount
     */
    public int getBonusAmount() {
        return bonusAmount;
    }

    /**
     * Sets bonus amount.
     *
     * @param bonusAmount the bonus amount
     */
    public void setBonusAmount(int bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
}

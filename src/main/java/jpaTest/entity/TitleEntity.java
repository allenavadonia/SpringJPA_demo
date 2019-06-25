package jpaTest.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Title entity.
 */
@Entity
@Table(name = "title")
public class TitleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_ref_id")
    private int workerRefId;

    @Column(name = "worker_title")
    private String workerTitle;

    @Column(name = "affected_from")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH/mm/ss")
    private Date affectFrom;

    @OneToOne(mappedBy = "titleEntity",cascade = CascadeType.ALL)
    private WorkerEntity workerEntity;

    /**
     * Instantiates a new Title entity.
     */
    public TitleEntity() {
    }

    /**
     * Gets worker ref id.
     *
     * @return the worker ref id
     */
    public int getWorkerRefId() {
        return workerRefId;
    }

    /**
     * Sets worker ref id.
     *
     * @param workerRefId the worker ref id
     */
    public void setWorkerRefId(int workerRefId) {
        this.workerRefId = workerRefId;
    }

    /**
     * Gets worker title.
     *
     * @return the worker title
     */
    public String getWorkerTitle() {
        return workerTitle;
    }

    /**
     * Sets worker title.
     *
     * @param workerTitle the worker title
     */
    public void setWorkerTitle(String workerTitle) {
        this.workerTitle = workerTitle;
    }

    /**
     * Gets affect from.
     *
     * @return the affect from
     */
    public Date getAffectFrom() {
        return affectFrom;
    }

    /**
     * Sets affect from.
     *
     * @param affectFrom the affect from
     */
    public void setAffectFrom(Date affectFrom) {
        this.affectFrom = affectFrom;
    }

    /**
     * Gets worker entity.
     *
     * @return the worker entity
     */
    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    /**
     * Sets worker entity.
     *
     * @param workerEntity the worker entity
     */
    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }
}

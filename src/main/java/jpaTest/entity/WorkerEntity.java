package jpaTest.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Worker entity.
 */
@Entity
@Table(name = "worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private int workerId;

    @Column(name = "firstname")
    private String fName;

    @Column(name = "lastname")
    private String lName;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date     joiningDate;

    @Column(name = "department")
    private String department;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TitleEntity titleEntity;

    @OneToMany(mappedBy = "workerRefId",cascade = CascadeType.ALL)
    private List<BonusEntity> bonusEntities;

    /**
     * Instantiates a new Worker entity.
     */
    public WorkerEntity() {
    }

    /**
     * Gets worker id.
     *
     * @return the worker id
     */
    public int getWorkerId() {
        return workerId;
    }

    /**
     * Sets worker id.
     *
     * @param workerId the worker id
     */
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets name.
     *
     * @param fName the f name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets name.
     *
     * @param lName the l name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "WorkerEntity{" +
                "workerId=" + workerId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", department='" + department + '\'' +
                ", titleEntity=" + titleEntity +
                ", bonusEntities=" + bonusEntities +
                '}';
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Gets joining date.
     *
     * @return the joining date
     */
    public Date getJoiningDate() {
        return joiningDate;
    }

    /**
     * Sets joining date.
     *
     * @param joiningDate the joining date
     */
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets title entity.
     *
     * @return the title entity
     */
    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    /**
     * Sets title entity.
     *
     * @param titleEntity the title entity
     */
    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    /**
     * Gets bonus entities.
     *
     * @return the bonus entities
     */
    public List<BonusEntity> getBonusEntities() {
        return bonusEntities;
    }

    /**
     * Sets bonus entities.
     *
     * @param bonusEntities the bonus entities
     */
    public void setBonusEntities(List<BonusEntity> bonusEntities) {
        this.bonusEntities = bonusEntities;
    }
}



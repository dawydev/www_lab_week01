package vn.edu.iuh.fit.week1_lab.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @EmbeddedId
    private GrantAccessId id;

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "is_grant", nullable = false)
    private Boolean isGrant = false;

    @Column(name = "note", length = 250)
    private String note;

    public GrantAccessId getId() {
        return id;
    }

    public void setId(GrantAccessId id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(Boolean isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
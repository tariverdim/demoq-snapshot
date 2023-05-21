package com.example.demoq.model.data;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "store", schema = "sakila")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Long storeId;
    @Basic
    @Column(name = "manager_staff_id")
    private Long managerStaffId;
    @Basic
    @Column(name = "address_id")
    private Long addressId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Long managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEntity that = (StoreEntity) o;
        return Objects.equals(storeId, that.storeId) && Objects.equals(managerStaffId, that.managerStaffId) && Objects.equals(addressId, that.addressId) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
    }
}

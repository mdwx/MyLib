package base.greendao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import greendao.generator.CustomerDao;
import greendao.generator.DaoSession;
import greendao.generator.OrderDao;

/**
 * Created by Vince on 2017/1/5.
 * E_mail :  xhys01@163.com
 * Description :
 */

@Entity(indexes = {
        @Index(value = "customerId, registerDate DESC")
})
public class Customer extends Person{
    @Id(autoincrement = true)
    private Long customerId;
    private java.util.Date registerDate;


    @ToMany(joinProperties = {
            @JoinProperty(name = "customerId", referencedName = "customerId")
    })
    private List<Order> orders;


    public Customer(@NotNull Long personId, String name, int age, String gender,
                    java.util.Date birthdate, java.util.Date recorded, Long customerId, java.util.Date registerDate) {
        super( personId,  name,  age,  gender,
                birthdate, recorded);
        this.customerId = customerId;
        this.registerDate = registerDate;
    }
    @Override
    public String toString() {
        return "Customer{"+
                "PersonId="+ super.getPersonId()+
                "customerId=" + customerId +
                ", registerDate=" + registerDate +
                ", orders=" + orders +
                '}';
    }

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
/** Used for active entity operations. */
@Generated(hash = 1697251196)
private transient CustomerDao myDao;


@Generated(hash = 22320166)
public Customer(Long customerId, java.util.Date registerDate) {
    this.customerId = customerId;
    this.registerDate = registerDate;
}


@Generated(hash = 60841032)
public Customer() {
}


public Long getCustomerId() {
    return this.customerId;
}


public void setCustomerId(Long customerId) {
    this.customerId = customerId;
}


public java.util.Date getRegisterDate() {
    return this.registerDate;
}


public void setRegisterDate(java.util.Date registerDate) {
    this.registerDate = registerDate;
}


/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 242226189)
public List<Order> getOrders() {
    if (orders == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        OrderDao targetDao = daoSession.getOrderDao();
        List<Order> ordersNew = targetDao._queryCustomer_Orders(customerId);
        synchronized (this) {
            if (orders == null) {
                orders = ordersNew;
            }
        }
    }
    return orders;
}


/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1446109810)
public synchronized void resetOrders() {
    orders = null;
}


/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}


/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}


/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}


/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 462117449)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getCustomerDao() : null;
}

    
}

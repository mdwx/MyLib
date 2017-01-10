package base.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * Created by Vince on 2017/1/6.
 * E_mail :  xhys01@163.com
 * Description :
 */
@Entity
public class SelectedProducts{

    @Id
    private Long id;

    @NotNull
    private Long productId;
    @NotNull
    private Long customerId;

    private Long number;
    private Date date;

    @Generated(hash = 1923706352)
    public SelectedProducts(Long id, @NotNull Long productId,
            @NotNull Long customerId, Long number, Date date) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.number = number;
        this.date = date;
    }
    @Generated(hash = 51658547)
    public SelectedProducts() {
    }
    public Long getProductId() {
        return this.productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getNumber() {
        return this.number;
    }
    public void setNumber(Long number) {
        this.number = number;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}

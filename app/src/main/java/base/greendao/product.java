package base.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Vince on 2017/1/6.
 * E_mail :  xhys01@163.com
 * Description :
 */
@Entity (indexes = {
@Index(value = "name DESC")
})
public class Product {
    @Id(autoincrement = true)
    @NotNull
    private Long productId;

    private String name;
    private String type;


    @Generated(hash = 365436647)
    public Product(@NotNull Long productId, String name, String type) {
        this.productId = productId;
        this.name = name;
        this.type = type;
    }
    @Generated(hash = 1890278724)
    public Product() {
    }
    public Long getProductId() {
        return this.productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
}

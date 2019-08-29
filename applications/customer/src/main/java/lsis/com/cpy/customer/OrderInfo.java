package lsis.com.cpy.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderInfo {

    private long id;
    private long customer_id;
    private String item;
    private String address;

    public OrderInfo() {

    }

    public OrderInfo(long id, long customer_id, String item, String address) {
        this.id = id;
        this.customer_id = customer_id;
        this.item = item;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return id == orderInfo.id &&
                customer_id == orderInfo.customer_id &&
                Objects.equals(item, orderInfo.item) &&
                Objects.equals(address, orderInfo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer_id, item, address);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", item='" + item + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author s_ele
 */
public class Order {
    
    private int idorder;
    private int length;
    private int width;
    private int height;
    public enum OrderStatus {
        pending("pending"), 
        sent("sent");
    
        private String status;
        
        OrderStatus(String status) {
            this.status = status;
        }
        
        public String getName() {
            return status;
        }
    }
    private OrderStatus status;
    private int user_iduser;

    public Order(int length, int width, int height, OrderStatus status, int user_iduser) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.status = status;
        this.user_iduser = user_iduser;
    }

    
    public int getIdorder() {
        return idorder;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getUser_iduser() {
        return user_iduser;
    }
    
    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setUser_iduser(int user_iduser) {
        this.user_iduser = user_iduser;
    }

    @Override
    public String toString() {
        return "Order{" + "idorder=" + idorder + ", length=" + length + ", width=" + width + ", height=" + height + ", status=" + status + ", user_iduser=" + user_iduser + '}';
    }

    

    
    
    
}

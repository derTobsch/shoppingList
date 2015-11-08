package de.yannicklem.shoppinglist.core.list.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.yannicklem.shoppinglist.core.item.entity.Item;
import de.yannicklem.shoppinglist.core.user.entity.SLUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class ShoppingList {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToMany
    private final Set<SLUser> owners;

    
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)
    private final Set<Item> items;

    public ShoppingList() {
        this.owners = new HashSet<>();
        this.items = new HashSet<>();
    }

    public void setOwners(Set<SLUser> owners){
        
        this.owners.clear();
        
        if(owners != null){
            this.owners.addAll(owners);
        }
    }
    
    public Set<SLUser> getOwners(){
        
        return owners;
    }

    public void setItems(Set<Item> items){
        
        this.items.clear();
        
        if(items != null){
            this.items.addAll(items);
        }
    }
}
